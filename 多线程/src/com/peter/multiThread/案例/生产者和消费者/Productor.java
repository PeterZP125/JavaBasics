package com.peter.multiThread.案例.生产者和消费者;

public class Productor extends  Thread {
    private Clerk clerk;
    private int totalNum;

    public Productor(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        clerk.orderCake();
    }
}
