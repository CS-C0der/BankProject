package data;

import model.BankCustomer;
import model.BankInstitution;
import model.CurrentAccount;
import util.Utility;

import java.util.LinkedList;
import java.util.TreeMap;
import java.util.function.BiConsumer;

/**
 * Handles data storage, access and updating
 */
public class Database {

    private TreeMap<String, CurrentAccount> treeMapOfAllCurrentAccount = new TreeMap<String, CurrentAccount>();

    private LinkedList<BankCustomer> listOfAllBankCustomer = new LinkedList<>();

    /**
     * Adds a new customer to the list while checking that the name is not used yet
     *
     * @param customerName_ - passes the name of the customer entered by the user
     * @throws IllegalArgumentException - reports to the user that this customer exists already
     */
    public void addCustomer(String customerName_) throws IllegalAccessError {

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
        else throw new IllegalAccessError ("Dieser Kunde existiert bereits.");
    }

    /**
     * Adds a new account to the Treemap using the name of the customer as key and the class CurrentAccount as value.
     * This option is separated from adding a customer because in the future, a customer might pick his selection from a variety of account types
     *
     * @param customerName_ - passes the name of the customer entered by the user, for which an account should be created
     * @throws IllegalAccessError - reports to the user either if the referenced customer does not exist, or if he already owns an account. In both cases no account is created.
     */
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

    /**
     * Deposits the amount entered by the user onto the account of the customer referenced by the user
     *
     * @param customerName_ - passes the name of the customer onto whose account the deposit goes.
     *                      This works because every customer can have only one account, and it's a lot more user-friendly than entering an IBAN.
     *                      When extending the program to other types of accounts like credit cards, this needs to be updated.
     * @param amount_ - int value that simply gets added to the current balance
     * @throws IllegalAccessError - reports to the user in case the referenced customer does not exist
     */
    public void deposit(String customerName_, int amount_) throws IllegalAccessError {

        if (treeMapOfAllCurrentAccount.containsKey(customerName_)) {
            for (BankCustomer customerForDeposit : listOfAllBankCustomer) {
                if (customerForDeposit.getNameOfBankCustomer().equals(customerName_)) {
                    customerForDeposit.getCurrentAccount().setBalance(customerForDeposit.getCurrentAccount().getBalance() + amount_);
                    System.out.println("Einzahlung über " + amount_ + "€ von Kunde " + customerForDeposit.getNameOfBankCustomer() + " auf Konto " + customerForDeposit.getCurrentAccount().getIBANOfCurrentAccount() + " erfolgreich getätigt.");
                }
            }
        }
        else throw new IllegalAccessError ("Das hat leider nicht geklappt. Stellen Sie sicher, dass der Kunde und ein Konto für ihn angelegt sind.");
    }

    /**
     * Displays in a first list all customers, regardless to whether they have an account.
     * Displays in a second list all customers with their balances and IBANs.
     * References to the current name of the bank.
     *
     * @throws NullPointerException - reports to the user when there is less than one complete entry in the list to show
     */
    public void showAll() throws NullPointerException {

        if (treeMapOfAllCurrentAccount.isEmpty()) {
            throw new NullPointerException("Das hat leider nicht geklappt. Haben Sie mindestens einen Kunden und ein Konto für diesen angelegt?");
        }
        else {
            System.out.println("Hier sehen Sie alle Kunden der " + BankInstitution.INSTANCE.getNameOfBank() + ":");
            for (BankCustomer customerToPrint : listOfAllBankCustomer) {
                System.out.println(customerToPrint.getNameOfBankCustomer());
            }
            System.out.println();

            System.out.println("Hier sehen Sie alle Kunden mit Kontos bei der " + BankInstitution.INSTANCE.getNameOfBank() + " mit ihren Kontoständen: ");
            BiConsumer<String, CurrentAccount> outputOfAllCurrentAccounts = (key, value) -> System.out.println(key + " besitzt " + value.getBalance() + "€" + " auf Konto " + value.getIBANOfCurrentAccount());
            treeMapOfAllCurrentAccount.forEach(outputOfAllCurrentAccounts);
        }
    }

}
