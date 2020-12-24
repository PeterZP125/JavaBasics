package com.peter.myjuc._04_callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class MyThreadDetail implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("正在计算。。。。");
        TimeUnit.SECONDS.sleep(2);
        return 710;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThreadDetail myThreadDetail = new MyThreadDetail();
        FutureTask futureTask = new FutureTask(myThreadDetail);

        new Thread(futureTask, "A").start();
        /*虽然启动了两个线程，但是因为使用的是同一个资源对象，
        * Callable接口实现的线程只会执行一次。
        * 所以只会打印一次"正在计算。。。。"。
        * */
        new Thread(futureTask, "B").start();

        System.out.println("数据正在计算中。。。。。。。");
        /*因为futureTask.get()会阻塞，所以放在最后*/
        System.out.println(futureTask.get());
    }
}
