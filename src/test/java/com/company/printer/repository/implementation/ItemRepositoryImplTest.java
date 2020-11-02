package com.company.printer.repository.implementation;

import com.company.printer.repository.ItemRepository;
import com.sun.media.sound.InvalidDataException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import static org.assertj.core.api.Assertions.assertThat;



@RunWith(BlockJUnit4ClassRunner.class)
public class ItemRepositoryImplTest {

    ItemRepository repository;

    @Before
    public void setup(){
        repository = new ItemRepositoryImpl();
    }

    @Test
    public void whenItemDoesNotExist_ThenIsItemExistReturnFalse(){
        assertThat(repository.isItemExist("NotExsistingItem")).isFalse();
    }

    @Test
    public void whenItemExist_ThenIsItemExistReturnFalse(){
        assertThat(repository.isItemExist("Milk")).isTrue();
    }

    @Test
    public void whenItemDoesExist_thenReturnPrice(){
        int price = repository.getItemsPrice("Milk");
        assertThat(price).isEqualTo(1);
    }




}