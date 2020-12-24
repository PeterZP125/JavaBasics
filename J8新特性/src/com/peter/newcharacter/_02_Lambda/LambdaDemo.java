package com.peter.newcharacter._02_Lambda;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaDemo {
    //    无参，无返回值
    public static void test1() {
        Runnable r = () -> {
            System.out.println("无参无返回值");
        };
        r.run();
    }

    //    有1个参，无返回值
    public static void test2() {
        Consumer<String> consumer = (String s) -> {
            System.out.println(s);
        };
        consumer.accept("有一个参数，无返回值");

        Consumer<String> consumer1 = (s) -> {
            System.out.println(s);
        };
        consumer1.accept("有一个参数，无返回值。参数类型可省去");

        Consumer<String> consumer2 = s -> System.out.println(s);

        consumer2.accept("有一个参数，无返回值。参数类型可省去，小括号也可省去，方法体也可以省去");
    }

    //    有两个以上参数，有返回值，有多条语句
    public static void test3() {
        Comparator<Integer> comparator = (num1, num2) -> {
            System.out.println(num1);
            System.out.println(num2);
            return num1.compareTo(num2);
        };


        System.out.println(comparator.compare(2, 3));

    }

    //    有两个以上参数，有返回值，一条语句
    public static void test4() {
        Comparator<Integer> comparator = (num1, num2) -> num1.compareTo(num2);
        comparator = Integer :: compare;
        System.out.println(comparator.compare(3, 3));

    }


    public static void main(String[] args) {
        LambdaDemo.test1();
        LambdaDemo.test2();
        LambdaDemo.test3();
        LambdaDemo.test4();
    }
}
