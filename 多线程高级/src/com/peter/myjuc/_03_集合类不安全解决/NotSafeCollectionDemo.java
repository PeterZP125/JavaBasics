package com.peter.myjuc._03_集合类不安全解决;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

public class NotSafeCollectionDemo {
    public static void main(String[] args) {
//        testList();
//        testSet();
        testMap();
    }

    public static void testList(){
        List list = new ArrayList();

//        list = Collections.synchronizedList(list);
//        list = new CopyOnWriteArrayList(list);
        /*ConcurrentModificationException
        * 解决方案：
        *   1）：使用Vector
        *   2）：使用Collections.synchronizedList(list);
        *           list = new CopyOnWriteArrayList(list);
        *   3）：使用java.util.concurrent.CopyOnWriteArrayList<E>
                    list = new CopyOnWriteArrayList(list);
         * */
        for (int i = 0; i < 30 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }

    public static void testSet(){
        Set set = new CopyOnWriteArraySet();

        for (int i = 0; i < 30 ; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
        try {
            //睡眠新方法
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(set.size());
    }
    public static void testMap(){
        Map map = new ConcurrentHashMap();

        for (int i = 0; i < 30 ; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
        try {
            //睡眠新方法
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(map.size());
    }

}
