package com.peter.collection._02_重写equals;

import com.peter.collection.beans.Person;

import java.util.ArrayList;
import java.util.Collection;

public class EqualsDemo {
    public static void main(String[] args) {
        Collection c = new ArrayList();

        c.add(1);
        c.add(new Person("Peter", 30));

        System.out.println(c.contains(new Person("Peter",30)));
    }
}
