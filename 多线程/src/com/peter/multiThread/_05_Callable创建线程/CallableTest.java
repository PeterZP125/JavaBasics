package com.peter.multiThread._05_Callable创建线程;

import javafx.concurrent.Task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for(int i = 0; i <= 100; i++){
            System.out.println(i);
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        CallableTest callableTest = new CallableTest();
        FutureTask task = new FutureTask(callableTest);
        Thread thead = new Thread(task);
        thead.start();

        try {
            int num = (int)task.get();
            System.out.println("总和"+num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
