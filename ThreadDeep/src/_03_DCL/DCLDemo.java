package _03_DCL;

import java.util.concurrent.atomic.AtomicInteger;

public class DCLDemo {
    private volatile static DCLDemo instance = null;

    private DCLDemo(){
        System.out.println("DCLDemo()....");
    }

    public static DCLDemo getInstance(){
        if(instance == null){
            synchronized(DCLDemo.class){
                if(instance == null){
                    instance = new DCLDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                DCLDemo.getInstance();
            }).start();
        }
    }
}


