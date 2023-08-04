package lib;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeMap;

public class Database {

    private LinkedList<BankInstitution> listOfAllBankInstitution = new LinkedList<>();

    private TreeMap<String, String> treeMapOfAllCurrentAccount = new TreeMap<String, String>();

    private LinkedList<BankCustomer> listOfAllBankCustomer = new LinkedList<>();

    public boolean addBank(String bankName_) {
        if (Utility.checkIfNotUsed(bankName_, listOfAllBankInstitution)) {
            BankInstitution newBank = new BankInstitution(bankName_);
            this.listOfAllBankInstitution.add(newBank);
            System.out.println("Neue Bankinstitution " + newBank.getNameOfBank() + " erfolgreich angelegt.");
            return true;
        }
        return false;
    }

    public boolean addCustomer(String customerName_) {

        if (true) {
            BankCustomer newCustomer = new BankCustomer(UserInput.INSTANCE.getUserInputCustomer());
            this.listOfAllBankCustomer.add(newCustomer);
            System.out.println("Neuer Kunde " + newCustomer.getNameOfBankCustomer() + " erfolgreich eingetragen.");
            return true;
        }
        return false;
    }

    public boolean addAccount(String customerName_) {

        BankCustomer customerForAccount;
        for (ListIterator<BankCustomer> iterator = listOfAllBankCustomer.listIterator();
             iterator.hasNext();) {
            customerForAccount = iterator.next();
            if (customerForAccount.getNameOfBankCustomer() == customerName_) {
                CurrentAccount newAccount = new CurrentAccount(Utility.getRandomIBAN());
                customerForAccount.setCurrentAccount(newAccount);
                this.treeMapOfAllCurrentAccount.put(newAccount.getIBANOfCurrentAccount(), customerForAccount.getNameOfBankCustomer());
                System.out.println("Neuer Account für Kunde " + customerForAccount.getNameOfBankCustomer() + " mit IBAN " + newAccount.getIBANOfCurrentAccount() + " erfolgreich angelegt.");
                return true;
            }
        }
        return false;
    }

}
