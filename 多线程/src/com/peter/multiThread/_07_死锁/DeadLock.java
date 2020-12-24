package com.peter.multiThread._07_死锁;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class DeadLock implements Runnable{
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    @Override
    public void run() {
        m1();
        m2();
    }

    public void m1(){
        lock1.lock();
        for (int i = 0; i < 10; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+i);
            lock1.unlock();
        }
    }

    public void m2(){
        lock2.lock();
        for (int i = 0; i < 10; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+i);
            lock2.unlock();
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();

        Thread t1 = new Thread(deadLock);
        Thread t2 = new Thread(deadLock);

        t1.start();
        t2.start();
    }
}
