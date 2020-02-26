package com.peter.multiThread._03_线程同步.Lock锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SellTicketInterface implements Runnable {
    private int tickets = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在售出第" + tickets + "张票");
                    tickets--;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        SellTicketInterface interfaceThread = new SellTicketInterface();

        Thread t1 = new Thread(interfaceThread);
        t1.setName("售票员Peter");
        Thread t2 = new Thread(interfaceThread);
        t2.setName("售票员Tom");
        Thread t3 = new Thread(interfaceThread);
        t3.setName("售票员Jay");

        t1.start();
        t2.start();
        t3.start();
    }
}
