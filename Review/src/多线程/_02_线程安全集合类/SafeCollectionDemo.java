package 多线程._02_线程安全集合类;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class SafeCollectionDemo {

    public static void main(String[] args) {
//        testList();
        testSafeList();
    }

    public static void testList(){
//        由于ArrayList的add()方法是线程不安全的，所以在多线程环境下会出现并发修改异常
//        java.util.ConcurrentModificationException
        List list= new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,4));
                System.out.println(list);
            }).start();
        }
    }

    public static void testSafeList(){
        List list = new CopyOnWriteArrayList();

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,4));
                System.out.println(list);
            }).start();
        }
    }
}
