package data;

import model.BankCustomer;
import model.BankInstitution;
import model.CurrentAccount;
import util.Utility;

import java.util.LinkedList;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class Database {

    private TreeMap<String, CurrentAccount> treeMapOfAllCurrentAccount = new TreeMap<String, CurrentAccount>();

    private LinkedList<BankCustomer> listOfAllBankCustomer = new LinkedList<>();

    public void addCustomer(String customerName_) throws IllegalArgumentException {

        boolean alreadyUsed = false;
        for (BankCustomer customerForAccount : listOfAllBankCustomer) {
            if (customerForAccount.getNameOfBankCustomer().equals(customerName_)) {
                alreadyUsed = true;
            }
        }
        if (!alreadyUsed) {
            BankCustomer newCustomer = new BankCustomer(customerName_);
            this.listOfAllBankCustomer.add(newCustomer);
            System.out.println("Neuer Kunde " + newCustomer.getNameOfBankCustomer() + " erfolgreich eingetragen.");
        }
        else throw new IllegalArgumentException ("Kunde existiert bereits.");
    }

    public void addAccount(String customerName_) throws IllegalAccessError {

        if (!treeMapOfAllCurrentAccount.containsKey(customerName_)) {
            boolean customerExists = false;
            for (BankCustomer customerForAccount : listOfAllBankCustomer) {
                if (customerForAccount.getNameOfBankCustomer().equals(customerName_)) {
                    CurrentAccount newAccount = new CurrentAccount(Utility.getRandomIBAN());
                    customerForAccount.setCurrentAccount(newAccount);
                    this.treeMapOfAllCurrentAccount.put(customerForAccount.getNameOfBankCustomer(), newAccount);
                    System.out.println("Neues Konto für Kunde " + customerForAccount.getNameOfBankCustomer() + " mit IBAN " + newAccount.getIBANOfCurrentAccount() + " erfolgreich angelegt.");
                    customerExists = true;
                }
            }
            if (!customerExists) throw new IllegalAccessError ("Dieser Kunde ist noch nicht eingetragen.");
        }
        else throw new IllegalAccessError ("Dieser Kunde besitzt bereits ein Konto. Jeder Kunde kann nur ein Konto besitzen.");

    }

    public void deposit(String customerName_, int amount_) throws IllegalAccessError {

        if (treeMapOfAllCurrentAccount.containsKey(customerName_)) {
            for (BankCustomer customerForDeposit : listOfAllBankCustomer) {
                if (customerForDeposit.getNameOfBankCustomer().equals(customerName_)) {
                    customerForDeposit.getCurrentAccount().setBalance(customerForDeposit.getCurrentAccount().getBalance() + amount_);
                    System.out.println("Einzahlung über " + amount_ + "€ von Kunde " + customerForDeposit.getNameOfBankCustomer() + " auf Konto " + customerForDeposit.getCurrentAccount().getIBANOfCurrentAccount() + " erfolgreich getätigt.");
                }
            }
        }
        else throw new IllegalAccessError ("Kontozugriff nicht möglich. Geben Sie einen existierenden Kunden ein.");
    }

    public void showAll() throws NullPointerException {

        try {
            System.out.println("Hier sehen Sie alle Kunden der " + BankInstitution.INSTANCE.getNameOfBank() + " mit ihren Kontoständen: ");
            BiConsumer<String, CurrentAccount> outputOfAllCurrentAccounts = (key, value) -> System.out.println(key + " hat "  + value.getBalance() + "€" + " auf Konto " + value.getIBANOfCurrentAccount());
            treeMapOfAllCurrentAccount.forEach(outputOfAllCurrentAccounts);

        }
        catch (NullPointerException e) {
            throw new NullPointerException("Datenzugriff nicht möglich. Haben Sie alles Nötige angelegt?");
        }

    }

}
