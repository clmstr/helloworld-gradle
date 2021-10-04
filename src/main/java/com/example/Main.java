package com.example;

import java.util.List;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        HelloWorld helloWorld = new HelloWorld();
        System.out.println(helloWorld.getHelloWorldMessage());
        List<Philosopher> philosophers = new ArrayList<>();
        Chopstick first = new Chopstick();
        Chopstick second = new Chopstick();
        Chopstick third = new Chopstick();
        Chopstick fourth = new Chopstick();
        Chopstick fifth = new Chopstick();


        philosophers.add(new Philosopher("phil1",first,second));
        philosophers.add( new Philosopher("phil2",second,third));
        philosophers.add( new Philosopher("phil3",third,fourth));
        philosophers.add( new Philosopher("phil4",fourth,fifth));
        philosophers.add( new Philosopher("phil5",fifth,first));

        philosophers.forEach(
                Thread::start
        );

    }
}
