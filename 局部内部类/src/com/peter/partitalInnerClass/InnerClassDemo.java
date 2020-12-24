package com.peter.partitalInnerClass;

public class InnerClassDemo {

    //方式一
    public Comparable getM() {
        class MyComparable implements Comparable {

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }

        return new MyComparable();
    }


    //方式二
    public Comparable get() {
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }
}
