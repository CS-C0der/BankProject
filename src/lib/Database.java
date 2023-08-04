package lib;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeMap;

public class Database {

    private LinkedList<BankInstitution> listOfAllBankInstitution = new LinkedList<>();

    private TreeMap<String, String> treeMapOfAllCurrentAccount = new TreeMap<String, String>();

    private LinkedList<BankCustomer> listOfAllBankCustomer = new LinkedList<>();

    public void addBank(String bankName_) throws IllegalArgumentException {
        if (Utility.checkIfNotUsed(bankName_, listOfAllBankInstitution)) {
            BankInstitution newBank = new BankInstitution(bankName_);
            this.listOfAllBankInstitution.add(newBank);
            System.out.println("Neue Bankinstitution " + newBank.getNameOfBank() + " erfolgreich angelegt.");
        }
        else throw new IllegalArgumentException("Bank existiert bereits.");
    }

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

        if (!treeMapOfAllCurrentAccount.containsValue(customerName_)) {
            for (BankCustomer customerForAccount : listOfAllBankCustomer) {
                if (customerForAccount.getNameOfBankCustomer().equals(customerName_)) {
                    CurrentAccount newAccount = new CurrentAccount(Utility.getRandomIBAN());
                    customerForAccount.setCurrentAccount(newAccount);
                    this.treeMapOfAllCurrentAccount.put(newAccount.getIBANOfCurrentAccount(), customerForAccount.getNameOfBankCustomer());
                    System.out.println("Neuer Account für Kunde " + customerForAccount.getNameOfBankCustomer() + " mit IBAN " + newAccount.getIBANOfCurrentAccount() + " erfolgreich angelegt.");

                }
            }
        }
        else throw new IllegalAccessError ("Kunde hat bereits ein Konto.");

    }

    public void deposit(String customerName_, int amount_) {

        if (treeMapOfAllCurrentAccount.containsValue(customerName_)) {
            for (BankCustomer customerForDeposit : listOfAllBankCustomer) {
                if (customerForDeposit.getNameOfBankCustomer().equals(customerName_)) {
                    customerForDeposit.getCurrentAccount().setBalance(amount_);
                    System.out.println("Einzahlung über " + amount_ + "€ von Kunde " + customerForDeposit.getNameOfBankCustomer() + " auf Konto mit IBAN " + customerForDeposit.getCurrentAccount().getIBANOfCurrentAccount() + " erfolgreich getätigt.");
                }
            }
        }
    }

}
