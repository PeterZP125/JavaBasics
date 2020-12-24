package _01_volatile;

import java.util.concurrent.atomic.AtomicInteger;

class C{
    volatile int num = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

//  方案1:为方法加同步锁
    public synchronized void addPlus(){
        num++;
    }
//  方案2:使用原子类（原理是CAS）
    public void atomicIntegerAddPlus(){
        atomicInteger.getAndIncrement();
    }
}

public class _03_不保证原子性_解决方案 {
    public static void main(String[] args) {
        C c = new C();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for(int j =0; j < 1000; j++){
                   c.addPlus();
                   c.atomicIntegerAddPlus();
                }
            }, String.valueOf(i)).start();
        }

//        默认有main()线程和GC线程
        while(Thread.activeCount() > 2){
            Thread.yield();
        }
//运行后，发现num!=20000;
        System.out.println(c.num);
        System.out.println(c.atomicInteger.get());
    }
}
