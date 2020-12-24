package com.peter.multiThread.案例.生产者和消费者;

import java.util.function.Consumer;

public class Clerk {
    private int cakeNum;

    public void orderCake() {
        while (true) {
            synchronized (this) {
                if (cakeNum < 20) {
                    System.out.println(Thread.currentThread().getName() + "生产了第" + cakeNum + "块蛋糕");
                    ++cakeNum;
                    notifyAll();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void sellCake() {
        while(true){
            synchronized (this){
                if(cakeNum > 0){
                    System.out.println(Thread.currentThread().getName() + "买了一块蛋糕");
                    --cakeNum;
                    notifyAll();
                }else{
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public int getCakeNum() {
        return cakeNum;
    }

    public void setCakeNum(int cakeNum) {
        this.cakeNum = cakeNum;
    }

    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Productor productor = new Productor(clerk);
        Customer customer = new Customer(clerk);

        productor.setName("梦工厂");
        customer.setName("Peter");

        productor.start();
        customer.start();
    }
}
