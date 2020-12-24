package com.peter.myjuc._02_生产消费;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Condition1 {
    public int temp = 0;
    Lock lock = new ReentrantLock();
    java.util.concurrent.locks.Condition condition = lock.newCondition();

    public void increase() {
        lock.lock();
        try {
            while (temp != 0) {
                condition.await();
            }
            temp++;
            System.out.println(Thread.currentThread().getName() + "调高了1度，当前温度为" + temp);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void degree() {
        lock.lock();
        try {
            while (temp == 0) {
                condition.await();
            }
            temp--;
            System.out.println(Thread.currentThread().getName() + "降低了1度，当前温度为" + temp);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
}

public class MultiThreadNodifyDemoNew1 {
    public static void main(String[] args) {
        Condition1 c = new Condition1();

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
