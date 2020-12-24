package com.peter.myjuc._05_辅助工具类;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
       /*
       传统方式无法控制线程的最终执行语句在哪里。
       for (int i = 0; i < 6; i++) {
            new Thread(() -> System.out.println(Thread.currentThread().getName() + "离开了"),
                    String.valueOf(i)).start();
        }
        System.out.println("保安来锁门了");*/

        /*原理：
        *   当一个或多个线程调用await方法时，这些线程会阻塞。
        *   其他线程调用countDown方法会将计数器减1(调用countDown方法的线程不会阻塞)
        *   当计数器的值变为0时，因await方法阻塞的线程会被唤醒，继续执行。
        * */
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() ->
                {
                    System.out.println(Thread.currentThread().getName() + "离开了");
                    countDownLatch.countDown();
                }
            ,String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("保安来锁门了");

    }
}
