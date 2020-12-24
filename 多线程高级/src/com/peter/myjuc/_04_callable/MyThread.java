package com.peter.myjuc._04_callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("我是使用Callable接口实现类创建的线程");
        return 710;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread thread = new MyThread();
        FutureTask futureTask = new FutureTask(thread);
        new Thread(futureTask, "B").start();
        System.out.println(futureTask.get());
    }
}
