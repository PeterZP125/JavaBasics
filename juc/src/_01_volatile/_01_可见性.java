package _01_volatile;

class A {
    /*如果number不加volatile修饰符，那main()不会结束*/
    volatile int number = 0;
}

public class _01_可见性 {
    public static void main(String[] args) {
        A a = new A();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "start...");
            try {
                Thread.sleep(3000);
                a.number = 60;
                System.out.println(Thread.currentThread().getName() + "end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();


        while(a.number == 0){

        }
        System.out.println(Thread.currentThread().getName()+"finished,a.number="+ a.number);
    }
}
