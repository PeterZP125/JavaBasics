package com.peter.multiThread._01_线程的创建.继承Thread;

public class MyThread extends Thread {
    @Override
    public void run() {
        for(int i =1; i <= 100; i++){
            if(i % 2 == 0){
                System.out.println(i+"我在线程"+Thread.currentThread().getName()+"中");
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for(int i =1; i <= 100; i++){
            if(i % 2 == 0){
                System.out.println(i+"*******我在线程"+Thread.currentThread().getName()+"中*******");
            }
        }
    }
}
