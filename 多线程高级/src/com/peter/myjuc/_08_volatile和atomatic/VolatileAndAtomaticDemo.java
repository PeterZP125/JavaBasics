package com.peter.myjuc._08_volatile和atomatic;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileAndAtomaticDemo implements Runnable{
    public AtomicInteger num = new AtomicInteger();
//    public static int num = 0;

    public int getNum(){
        return num.getAndIncrement();
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":"+getNum());
    }

    public static void main(String[] args) {
        VolatileAndAtomaticDemo t = new VolatileAndAtomaticDemo();

        for (int i = 0; i < 20; i++) {
            new Thread(t).start();
        }
    }
}
