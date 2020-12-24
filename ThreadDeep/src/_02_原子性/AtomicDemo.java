package _02_原子性;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    public volatile int num;
    public AtomicInteger atomicInteger = new AtomicInteger();
    
    public void addPlus(){
            num++;
    }
    
    public void addAtomicInteger(){
        atomicInteger.getAndIncrement();
    }

    public static void main(String[] args) {
        AtomicDemo atomicErr = new AtomicDemo();

        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    atomicErr.addPlus();
                    atomicErr.addAtomicInteger();
                }
            }).start();
        }

        while(Thread.activeCount() > 2){//获取当前的活动线程数
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + ":num="+atomicErr.num);
        System.out.println(Thread.currentThread().getName() + ":automicInteger="+atomicErr.atomicInteger);
        
        /*运行后发现，有时候num！=20000。
        * 虽然num字段增加了volatile修饰符，但是因为addPlus()方法并没有
        *使用同步方法，所以多个线程会去抢占执行。而i++在底层是分为了三步：
        * 1)先复制num值到各自的线程中
        * 2)+1操作
        * 3)将修改写回堆中num
        * 虽然volatile保证一个线程执行完后需要“通知”其他线程获取主内存中
        * 的最新值，但是其他线程可能此时被挂起了还没来得及获取最新值，就又写入主内存了。
        * 发生了丢失写值的情况。
        * 解决方案：
        * 1）synchronize
        * 2）automicInteger
        * */
    }
}
