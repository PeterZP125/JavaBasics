package com.peter.myjuc._02_生产消费;

class Condition {
    public int temp = 0;

    public synchronized void increase() {
        while (temp != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        temp++;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "调高了1度，当前温度为" + temp);
        notifyAll();
    }

    public synchronized void degree() {
        while (temp == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        temp--;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "降低了1度，当前温度为" + temp);
        notifyAll();
    }
}

public class MultiThreadNodifyDemo {
    public static void main(String[] args) {
        Condition c = new Condition();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                c.increase();
            }
        }, "Peter").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                c.increase();
            }
        }, "Jay").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                c.degree();
            }
        }, "小王").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                c.degree();
            }
        }, "小李").start();
    }
}
