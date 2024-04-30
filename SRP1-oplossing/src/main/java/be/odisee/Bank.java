package be.odisee;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    /**
     * The bank accounts.
     */
    private final List<BankAccount> bankAccounts = new ArrayList<>();

    /**
     * Adds a bank account.
     */
    public void voegAccountToe(String naam, double balans, int nummer) {
        bankAccounts.add(new BankAccount(naam, balans, nummer));
    }
    public void voegAccountToe(String naam,int nummer) {
        bankAccounts.add(new BankAccount(naam, 0, nummer));
    }

    /**
     * Zoek het bankaccount
     * @param nummer bank account number
     * @return bank account
     * @throws IllegalArgumentException Onbekend nummer
     */
    private BankAccount zoekBankAccount(int nummer) throws IllegalArgumentException {
        for (BankAccount ba : bankAccounts) {
            if (ba.getNummer() == nummer) {
                return ba;
            }
        }
        throw new IllegalArgumentException("Onbekend bankaccount met nummer " + nummer);
    }

    public void printRekeningen() {
        System.out.println("Aantal rekeningen: " + bankAccounts.size());
        for (BankAccount ba : bankAccounts) {
            System.out.println(ba.toString());
        }
    }

    public void stort(int rekeningNummer,double bedrag) {
        BankAccount ba = zoekBankAccount(rekeningNummer);
        ba.storten(bedrag);
    }

    public boolean afhalen(int rekeningNummer, double bedrag) {
        BankAccount ba = zoekBankAccount(rekeningNummer);
        return ba.afhalen(bedrag);
    }

}
