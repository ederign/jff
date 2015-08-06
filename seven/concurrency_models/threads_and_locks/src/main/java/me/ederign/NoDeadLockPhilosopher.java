package me.ederign;

import java.util.Random;

public class NoDeadLockPhilosopher extends Thread {
    private Chopstick first, second;
    private Random random;
    private int thinkCount;

    public NoDeadLockPhilosopher(Chopstick left, Chopstick right) {
        //always acquire locks in a fixed, global order. -> No Deadlock
        if(left.getId() < right.getId()) {
            first = left; second = right;
        } else {
            first = right; second = left;
        }
        random = new Random();
    }

    public void run() {
        try {
            while(true) {
                ++thinkCount;
                if (thinkCount % 10 == 0)
                    System.out.println("Philosopher " + this + " has thought " + thinkCount + " times");
                Thread.sleep(random.nextInt(1000));     // Think for a while
                synchronized(first) {                   // Grab first chopstick
                    synchronized(second) {                // Grab second chopstick
                        Thread.sleep(random.nextInt(1000)); // Eat for a while
                    }
                }
            }
        } catch(InterruptedException e) {}
    }

    private class Chopstick {
        public Integer getId() {
            //return a specific item id
            return -1;
        }
    }
}