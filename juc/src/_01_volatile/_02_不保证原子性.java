package _01_volatile;

class B{
    volatile int num = 0;

    public void addPlus(){
        num++;
    }
}

public class _02_不保证原子性 {
    public static void main(String[] args) {
        B b = new B();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for(int j =0; j < 1000; j++){
                   b.addPlus();
                }
            }, String.valueOf(i)).start();
        }

//        默认有main()线程和GC线程
        while(Thread.activeCount() > 2){
            Thread.yield();
        }
//运行后，发现num!=20000;
        System.out.println(b.num);
    }
}
