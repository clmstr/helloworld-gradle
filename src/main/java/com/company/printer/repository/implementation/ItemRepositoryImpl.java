package com.company.printer.repository.implementation;

import com.company.printer.repository.ItemRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class ItemRepositoryImpl implements ItemRepository {

    private Map<String,Integer> items;

    public ItemRepositoryImpl(){
       items = new HashMap<>();
       items.put("Milk",1);
       items.put("Bread",3);
    }


    @Override
    public boolean isItemExist(String name) {
        return items.containsKey(name);
    }

    @Override
    public int getItemsPrice(String name) {
        return items.get(name);
    }
}
