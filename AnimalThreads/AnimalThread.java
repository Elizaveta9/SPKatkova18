package com.company;

public class AnimalThread extends Thread {
    private String name;
    private int dist = 50;
    private int initialSpeed = 10;
    private int speed;
    private static int count = 1;


    public AnimalThread(String name, int prior) {
        this.name = name;
        this.setPriority(prior);
    }

    void timerForSwitch(int i) {

        if (i == 15) {
            System.out.println("    СМЕНА СКОРОСТЕЙ");
            Thread thread = Thread.currentThread();
            if (thread.getPriority() == Thread.MAX_PRIORITY) {
                thread.setPriority(Thread.MIN_PRIORITY);
            } else if (thread.getPriority() == Thread.MIN_PRIORITY) {
                thread.setPriority(Thread.MAX_PRIORITY);
            }

        }

    }

    public void run() {

        speed = initialSpeed * (getPriority());
        try {
            for (int i = 0; i < dist; i++) {
                System.out.printf("%s пробежал %d м делая шаг каждые %d мс\n", name, i, speed);
                Thread.sleep(speed);
                timerForSwitch(i);
                speed = initialSpeed * (getPriority());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " ФИНИШИРОВАЛ " + count);
        count++;
    }
}
