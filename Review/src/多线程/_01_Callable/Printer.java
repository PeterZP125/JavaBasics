package 多线程._01_Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Printer implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("正在计算。。。");
        int a = 100 / 2;
        TimeUnit.SECONDS.sleep(2);
        return a;
    }

    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new Printer());
        new Thread(futureTask,"AB").start();
        System.out.println("计算中，请稍等");
        try {
            Integer ret  = (Integer) futureTask.get();
            System.out.println(ret);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
