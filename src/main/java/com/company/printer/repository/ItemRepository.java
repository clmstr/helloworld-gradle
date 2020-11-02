package com.company.printer.repository;

public interface ItemRepository {

    boolean isItemExist(String name);

    int getItemsPrice(String name);
}
