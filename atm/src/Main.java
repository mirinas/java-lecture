import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Account acc1 = new Account("Augustas", "abcd");
        Account acc2 = new Account("Petras", "xyz");

        HashMap<String, Account> accounts = new HashMap<>();
        accounts.put(acc1.getAccNumber(), acc1);
        accounts.put(acc2.getAccNumber(), acc2);


        Account selectedAcc = null;
        System.out.println("Login to an account: " + accounts.keySet());

        String accNumber = s.next();
        System.out.print("Enter PIN: ");
        String pin1 = s.next();
        Account acc0 = accounts.get(accNumber);
        if(acc0.login(pin1)) {
            selectedAcc = accounts.get(accNumber);
            selectedAcc.print();
        } else {
            System.err.println("Incorrect PIN!");
            return;
        }


        System.out.println("Enter a command: deposit, withdraw, print, quit");
        while(true) {

            String cmd = s.next();
            switch (cmd) {
                case "login" -> {
                    System.out.println("Login to an account: " + accounts.keySet());

                    String accNo = s.next();
                    System.out.print("Enter PIN: ");
                    String pin = s.next();

                    Account loggedIn = accounts.get(accNo);
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

                    accounts.put(newAcc.getAccNumber(), newAcc);
                }
                case "deposit" -> {
                    double amount = s.nextDouble();
                    double newBalance = selectedAcc.deposit(amount);
                    System.out.println("Your new balance: " + newBalance + "eur");
                }
                case "withdraw" -> {
                    double amount = s.nextDouble();

                    if(selectedAcc.withdraw(amount)) {
                        System.out.println("Your new balance: " + selectedAcc.getBalance() + "eur");
                    } else {
                        System.err.println("Insufficient funds!");
                    }
                }
                case "print" -> selectedAcc.print();
                case "quit" -> {
                    System.out.println("Bye bye!");
                    return;
                }
                default -> System.err.println("Invalid command. Available: quit");
            }
        }


    }
}