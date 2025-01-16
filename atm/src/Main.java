import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Account acc1 = new Account("Augustas", "abcd");
        Account acc2 = new Account("Petras", "xyz");

        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(acc1);
        accounts.add(acc2);

        Account selectedAcc = null;
        System.out.println("Login to an account: 0-" + (accounts.size() - 1));
        int index = s.nextInt();
        selectedAcc = accounts.get(index);
        selectedAcc.print();

        System.out.println("Enter a command: deposit, withdraw, print, quit");
        while(true) {

            String cmd = s.next();
            switch (cmd) {
                case "login" -> {
                    int i = s.nextInt();
                    selectedAcc = accounts.get(i);
                    selectedAcc.print();
                }
                case "register" -> {
                    String name = s.next();
                    String pin = s.next();


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