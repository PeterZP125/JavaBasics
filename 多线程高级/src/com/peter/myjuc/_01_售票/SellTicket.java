package com.peter.myjuc._01_售票;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket {
    private int totalTickets = 50;

    public void saleTickets() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            if (totalTickets > 0) {
                System.out.println(Thread.currentThread().getName() + "售出第" + totalTickets + "张票，剩余" + (--totalTickets) + "张");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class SellTicket {
    public static void main(String[] args) {
        Ticket t = new Ticket();
        new Thread(() -> { for (int i = 0; i < 40; i++) { t.saleTickets(); }}, "A").start();
        new Thread(() -> { for (int i = 0; i < 40; i++) { t.saleTickets(); }}, "B").start();
        new Thread(() -> { for (int i = 0; i < 40; i++) { t.saleTickets(); }}, "C").start();
    }
}
