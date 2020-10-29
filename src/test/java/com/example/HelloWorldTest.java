package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(BlockJUnit4ClassRunner.class)
public class HelloWorldTest {

    private HelloWorld helloWorld;

    @Before
    public void setUp() {
        helloWorld = new HelloWorld();
    }

    @Test
    public void whenHelloWorldIsCalled_theMessageIsNotEmpty() {
        String actualMessage = helloWorld.getHelloWorldMessage();
        assertThat(actualMessage).isNotBlank();
    }

    @Test
    public void whenHelloWorldIsCalled_thenMessageReturned() {
        String actualMessage = helloWorld.getHelloWorldMessage();
        assertThat(actualMessage).isEqualTo("Hello World!");
    }


}