
public class Account {

    private String accNumber;
    private static int nextAccNumber = 101;

    private String fullName;
    private String pin;
    private double balance = 0;

    public Account(String fullName, String pin) {
        this.fullName = fullName;
        this.pin = pin;

        accNumber = "LT" + nextAccNumber;
        nextAccNumber++;
    }


    public boolean withdraw(double amount) {
        if(amount > balance || amount < 0) {
            return false;
        }
        balance -= amount;
        return true;
    }


    public double deposit(double amount) {
        if(amount < 0) return balance;

//        balance = balance + amount;
        balance += amount;
        return balance;
    }


    public void print() {
        System.out.println("------------------");
        System.out.printf("%s - %s\n", fullName, accNumber);
        System.out.printf("Balance: %seur\n", balance);
    }

    public double getBalance() {
        return balance;
    }
}
