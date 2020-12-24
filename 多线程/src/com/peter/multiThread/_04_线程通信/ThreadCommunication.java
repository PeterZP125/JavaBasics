package com.peter.multiThread._04_线程通信;

import org.omg.PortableServer.THREAD_POLICY_ID;

public class ThreadCommunication implements Runnable{

    private int fileNo = 1;

    @Override
    public void run() {
        while(true) {
            synchronized (this) {
                notifyAll();
                //唤醒其他线程
                if (fileNo < 20) {
                    System.out.println(Thread.currentThread().getName() + "打印了第" + fileNo + "份文件");
                    fileNo++;
                }
                try {
                    Thread.sleep(500);
                    //进入阻塞状态并释放锁
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadCommunication threadCommunication = new ThreadCommunication();

        Thread t1 = new Thread(threadCommunication);
        Thread t2 = new Thread(threadCommunication);
        t1.setName("Peter");
        t2.setName("Tom");

        t1.start();
        t2.start();
    }
}
