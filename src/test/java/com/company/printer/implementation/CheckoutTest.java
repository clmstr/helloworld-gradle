package com.company.printer.implementation;

import com.company.printer.repository.ItemRepository;
import com.company.printer.repository.implementation.ItemRepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.PrintWriter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class CheckoutTest {

    public CheckoutImpl checkout;
    @Mock
    PrintWriter printWriter;


    @Before
    public void setup() {
        ItemRepository itemRepository = new ItemRepositoryImpl();
        checkout = new CheckoutImpl(itemRepository, printWriter);
    }

    @Test(expected = ItemNotFoundException.class)
    public void whenItemIsNotStored_thenThrowException() {
        checkout.scan("NotExistingItem");
    }

    @Test
    public void whenItemIsStored_thenSuccess() {
        checkout.scan("Milk");
        assertThat(checkout.receipt.containsKey("Milk")).isTrue();
    }

    @Test
    public void whenPrintReceiptIsCalled_thenAllTheItemsArePrinted() {
        checkout.scan("Milk");
        checkout.printReceipt();
        verify(printWriter).println("Milk" +" "+ 1);
    }


}