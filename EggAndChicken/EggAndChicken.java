package com.company;

public class EggAndChicken {
    public static void main(String[] args) throws InterruptedException {
        MyThread egg = new MyThread("Яйцо");
        egg.start();
        MyThread chicken = new MyThread("Кукрица");
        chicken.start();

        chicken.join();

        if (egg.isAlive()) {
            egg.join();
            System.out.println("Спор выиграло Яйцо");
        } else {
            System.out.println("Спор выиграла Кукрица");
        }
    }
}

class MyThread extends Thread {

    public MyThread(String name) {
        this.setName(name);
    }

    public void run() {
        for (int i = 0; i != 10; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
