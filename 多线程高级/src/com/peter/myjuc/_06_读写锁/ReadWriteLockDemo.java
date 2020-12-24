package com.peter.myjuc._06_读写锁;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    private volatile Map<String, Integer> map = new HashMap<>();
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void write(String key, Integer value) {
        Lock lock = readWriteLock.writeLock();
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "正在写数据=====");
            map.put(key, value);
            TimeUnit.MILLISECONDS.sleep(200);
            System.out.println(Thread.currentThread().getName() + "录入完成====");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void read(String key) {
        Lock lock = readWriteLock.readLock();
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "正在读数据");
            map.get(key);
            TimeUnit.MILLISECONDS.sleep(200);
            System.out.println(Thread.currentThread().getName() + "读取完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();

        for (int i = 0; i < 5; i++) {
            final int ret = i;
            new Thread(() -> {
                demo.write(String.valueOf(ret), ret);
            }).start();
        }
        for (int i = 0; i < 5; i++) {
            final int ret = i;
            new Thread(() -> {
                demo.read(String.valueOf(ret));
            }).start();
        }
    }
}
