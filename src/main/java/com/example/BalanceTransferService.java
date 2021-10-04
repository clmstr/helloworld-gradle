package com.example;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BalanceTransferService {


    void transfer(Account from, Account to, int amount) {

        // Begin Transaction;

        if (from.getLock()) {
            if (to.getLock()) {
                from.setAmount(from.getAmount() - amount);
                to.setAmount(to.getAmount() + amount);
                to.unlock();
            }
            from.unlock();
        }
        //UPDATE Account (id, amount)
        // SET amount=from.amount
        // where id = from.id;

        //UPDATE Account (id, amount)
        // SET amount=to.amount
        // where id = to.id;

        //commit;
        //End Transaction;
    }

}
