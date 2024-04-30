package be.odisee;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Application class executing the scenario and tracking the bankaccounts.
 */
public class SRP1  {
    private static final Bank myBank = new Bank();

    /**
     * start scenario:
     * add the bank accounts
     * */
    private static void startScenarios() {
        myBank.voegAccountToe("me", 100.0,1);
        myBank.voegAccountToe("myself",0.0, 2);
        myBank.voegAccountToe("Geeraard", 666.0,666);
    }

    /**
     * increase the first account balance by 100
     * decrease the third account balance by 200
     * decrease the second account balance by 100 (should fail)
      */
    private static void scenario1() {
        boolean success = true;
        myBank.stort(1,100);
        if(!myBank.afhalen(666,100) &&  myBank.afhalen(2,200)) {
            System.out.println("scenario1 faalt - te weinig op rekening");
        }
    }
    /**
     * add a fourth account
     * increase the fourth account balance by 10
     */
    private static void scenario2() {
        myBank.voegAccountToe("Jane Doe", 4);
        myBank.stort(4,10);
    }


    public static void main(String[] args) {
        startScenarios();
        System.out.println("Rekeningen op het begin:");
        myBank.printRekeningen();
        scenario1();

        System.out.println("Rekeningen na transacties:");
        myBank.printRekeningen();

        scenario2();

        System.out.println("Rekeningen op het einde:");
        myBank.printRekeningen();
    }


}