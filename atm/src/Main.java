import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Account acc1 = new Account("Augustas", "abcd");
        Account acc2 = new Account("Petras", "xyz");


        Scanner s = new Scanner(System.in);
        System.out.println("Enter a command: deposit, withdraw, print, quit");
        while(true) {

            String cmd = s.next();
            switch (cmd) {
                case "deposit" -> {
                    double amount = s.nextDouble();
                    double newBalance = acc1.deposit(amount);
                    System.out.println("Your new balance: " + newBalance + "eur");
                }
                case "withdraw" -> {
                    double amount = s.nextDouble();

                    if(acc1.withdraw(amount)) {
                        System.out.println("Your new balance: " + acc1.getBalance() + "eur");
                    } else {
                        System.err.println("Insufficient funds!");
                    }
                }
                case "print" -> acc1.print();
                case "quit" -> {
                    System.out.println("Bye bye!");
                    return;
                }
                default -> System.err.println("Invalid command. Available: quit");
            }
        }


    }
}