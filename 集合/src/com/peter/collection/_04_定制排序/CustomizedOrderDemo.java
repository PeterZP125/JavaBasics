package com.peter.collection._04_定制排序;

import com.peter.collection.beans.Person;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class CustomizedOrderDemo {
    public static void main(String[] args) {
        Set set = new TreeSet((Object o1, Object o2) -> {
            Person p1 = (Person) o1;
            Person p2 = (Person) o2;

            return Integer.compare(p1.getAge(), p2.getAge());
        });

        set.add(new Person("Peter", 20));
        set.add(new Person("Som", 23));
        set.add(new Person("Jerry", 20));

        for (Object o : set) {
            Person p = (Person) o;
            System.out.println(p);
        }

    }
}
