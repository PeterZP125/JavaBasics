package com.peter.collection._03_iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add(1);
        c.add(3);
        c.add(2);
        c.add(4);

        Iterator iterator = c.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
