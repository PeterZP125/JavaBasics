package com.peter.multiThread._03_线程同步.同步方法;

public class SellTicketExtend extends Thread{
    private static int tickets = 100;

    @Override
    public void run() {
        while(true){
            sellTicket();
        }
    }

    public synchronized static void sellTicket(){
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + "正在售出第" + tickets + "张票");
            tickets--;
        }
    }

    public static void main(String[] args) {
        Thread t1 = new SellTicketExtend();
        t1.setName("售票员Peter");
        Thread t2 = new SellTicketExtend();
        t2.setName("售票员Tom");
        Thread t3 = new SellTicketExtend();
        t3.setName("售票员Jay");

        t1.start();
        t2.start();
        t3.start();
    }
}
