package com.peter.multiThread._03_线程同步.同步代码块;

public class SellTicketInterface implements Runnable{
    private int tickets = 100;

    @Override
    public void run() {
        while(true){
            synchronized (this){
                if(tickets > 0){
                    System.out.println(Thread.currentThread().getName()+"正在售出第" + tickets+"张票");
                    tickets --;
                }else{
                    break;
                }
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
