package org.example.entities;

public class Wallet {
    private double amount;

    public Wallet(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "amount=" + amount +
                '}';
    }
}
