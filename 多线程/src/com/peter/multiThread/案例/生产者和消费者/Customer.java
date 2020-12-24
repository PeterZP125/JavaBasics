package com.peter.multiThread.案例.生产者和消费者;

public class Customer extends Thread{
    private Clerk clerk;

    public Customer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        clerk.sellCake();
    }
}
