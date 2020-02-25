package com.peter.multiThread._02_常用方法;

import com.peter.multiThread._01_线程的创建.实现Runnable.MyRunnableThread;
import com.peter.multiThread._01_线程的创建.继承Thread.MyThread;

class CommonMyThread extends Thread {
    @Override
    public void run() {
        for(int i =1; i <= 100; i++){
            if(i % 2 == 0){
                System.out.println(i+"我在线程"+Thread.currentThread().getName()+"中");
            }
            if(i % 4 == 0){
                //释放CPU执行权
                this.yield();
            }
        }
    }
}

public class CommonMethod {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnableThread());
        //设置线程名称
        thread.setName("LearningThread");
        thread.start();

        for(int i =1; i <= 100; i++){
            if(i % 2 == 0){
                System.out.println(i+"*******我在线程"+Thread.currentThread().getName()+"中*******");
            }
            if (i % 10 == 0) {
                try {
                    //在线程a中调用线程b的join()方法，此时线程a进入阻塞状态，知道线程b执行结束
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
