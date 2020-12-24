package com.peter.fanxing._01_继承性;

import java.util.ArrayList;
import java.util.List;

public class CommonCharacterDemo {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        print(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("A");
        list2.add("B");
        list2.add("C");
        print(list2);

        List<?> a = new ArrayList<>();
        a = list1;
        a.add(null);
        print(a);

    }

    /*使用了泛型后，如果要遍历打印集合，反而出现了麻烦，对不同类型的集合都要写不同的方法来进行遍历。*/
    public static void list(List<String> list) {
    }

    public static void list1(List<Integer> list) {
    }

    /*解决方案：使用通配符?*/
    public static void print(List<?> list){
        for (Object o : list) {
            System.out.println(o);
        }
    }

}


