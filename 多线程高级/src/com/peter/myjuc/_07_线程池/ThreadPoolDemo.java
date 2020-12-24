package com.peter.myjuc._07_线程池;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    //    一池固定线程
    public static Executor executor = Executors.newFixedThreadPool(5);
    //    一池单线程
    public static Executor executor1 = Executors.newSingleThreadExecutor();
    //    自动化线程
    public static Executor executor2 = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            executor.execute(()-> System.out.println(Thread.currentThread().getName()+"正在处理数据"));
        }
    }
}
