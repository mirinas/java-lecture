package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Account {
    private String accNumber;

    private String fullName;
    private String pin;

    private int wholeBalance = 0;
    private int cents = 0;

    public Account(String fullName, String pin) {
        this.fullName = fullName;
        this.pin = pin;

        accNumber = "LT" + (int) (Math.random() * 1000);
    }


    public boolean login(String pin) {
        return pin.trim().equals(this.pin.trim());
    }


    public boolean withdraw(double amount) {
        if(amount > getBalance() || amount < 0) {
            return false;
        }
        // balance -= amount;
        setBalance(getBalance() - amount);
        return true;
    }


    public double deposit(double amount) {
        if(amount < 0) return getBalance();

//        balance = balance + amount;
        setBalance(getBalance() + amount);
        return getBalance();
    }


    public void print() {
        System.out.println("------------------");
        System.out.printf("%s - %s\n", fullName, accNumber);
        System.out.printf("Balance: %seur\n", getBalance());
    }


    public double getBalance() {
        return (double) wholeBalance + (double) cents / 100;
    }


    private void setBalance(double amount) {
        wholeBalance = (int) amount;
        cents = (int) (amount * 100 - wholeBalance * 100);
    }
}
