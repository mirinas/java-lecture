package org.example;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        Scanner s = new Scanner(System.in);

        Account selectedAcc = null;
        System.out.println("Enter a command: deposit, withdraw, print, quit");
        while(true) {

            String cmd = s.next();
            switch (cmd) {
                case "login" -> {
//                    System.out.println("Login to an account: " + accounts.keySet());

                    String accNo = s.next();
                    System.out.print("Enter PIN: ");
                    String pin = s.next();

                    Account loggedIn = Data.readAccount(accNo);
                    // jeigu prie sito acc galima prisijungti suvestu slaptazodziu
                    if(loggedIn.login(pin)) {
                        selectedAcc = loggedIn;
                        selectedAcc.print();
                    } else {
                        System.err.println("Incorrect PIN");
                    }

                }
                case "register" -> {
                    String name = s.next();
                    String pin = s.next();

                    Account newAcc = new Account(name, pin);
                    Data.saveAccount(newAcc);
                }
                case "deposit" -> {

                    try {
                        double amount = s.nextDouble();
                        double newBalance = selectedAcc.deposit(amount);
                        System.out.println("Your new balance: " + newBalance + "eur");

                    } catch (InputMismatchException e) {
                        System.err.println("Deposit amount must be a number");
                    }

                }
                case "withdraw" -> {
                    try {
                        double amount = s.nextDouble();

                        if (selectedAcc.withdraw(amount)) {
                            System.out.println("Your new balance: " + selectedAcc.getBalance() + "eur");
                        } else {
                            System.err.println("Insufficient funds!");
                        }
                    } catch (InputMismatchException e) {
                        System.err.println("Deposit amount must be a number");
                    }
                }
                case "print" -> selectedAcc.print();
                case "quit" -> {
                    System.out.println("Bye bye!");
                    return;
                }
//                default -> System.err.println("Invalid command. Available: quit");
            }
        }
    }
}
