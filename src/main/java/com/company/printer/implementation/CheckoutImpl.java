package com.company.printer.implementation;

import com.company.printer.Checkout;
import com.company.printer.repository.ItemRepository;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutImpl implements Checkout {

    private ItemRepository itemRepository;

    Map<String, Integer> receipt;

    private PrintWriter printer;

     public CheckoutImpl(ItemRepository itemRepository, PrintWriter printer ){
        this.itemRepository = itemRepository;
        receipt = new HashMap<>();
        this.printer = printer;
    }

    @Override
    public void scan(String item) {
        if (!itemRepository.isItemExist(item)) {
            throw new ItemNotFoundException();
        }

        receipt.put(item, itemRepository.getItemsPrice(item));
    }

    @Override
    public void printReceipt() {
        receipt.forEach( (k,v) -> printer.println(k + " " + v));
    }
}
