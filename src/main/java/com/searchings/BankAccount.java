package com.searchings;

/**
 * Created by davicres on 10/06/2015.
 */
public final class BankAccount {

    private Calculator calculator;
    private final int balance;

    private BankAccount(int initialDeposit) {
        balance = initialDeposit;
    }

    public static BankAccount open(int initialDeposit) {
        return new BankAccount(initialDeposit);
    }

    public BankAccount makeADeposit(int deposit) {
        int sum = calculator.add(balance, deposit);
        return new BankAccount(sum);
    }


    public int getBalance() {
        return balance;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

}
