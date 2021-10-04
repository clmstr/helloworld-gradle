package com.example;

public class Philosopher extends Thread {
   private final static int BITES = 10;
   private Chopstick left, right;
   private String name;

   public Philosopher(String name, Chopstick left, Chopstick right){
      this.name = name;
       this.left = left;
       this.right = right;
   }

   public void eat(int i) {
       pickUp();
       chew(i);
       putDown();
   }

    private void chew(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " is chewing: " + i + " bite.");
    }

    private void putDown() {
       left.putDown();
       right.putDown();
    }

    private void pickUp() {
       left.pickUp();
       right.pickUp();
    }


    @Override
    public void run() {
        for (int i = 0; i < this.BITES; i++){
            eat(i);
        }
    }
}
