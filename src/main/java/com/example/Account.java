package com.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private String accountNumber;
    private int amount;
    Lock lock = new ReentrantLock();

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAmount() {
        return amount;
    }

    public boolean getLock(){
        return lock.tryLock();
    }

    public void unlock(){
        lock.unlock();
    }

    public void setAmount(int amount) {
            this.amount = amount;
    }
}
