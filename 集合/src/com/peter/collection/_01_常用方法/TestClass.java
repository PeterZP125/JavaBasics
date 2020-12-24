package com.peter.collection._01_常用方法;

public class TestClass {

    public static void main(String[] args) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        a = b;
        a.append("123");
        a.append("345");

        System.out.println(a.toString());
        System.out.println(b.toString());

        b = a;
        System.out.println(a.toString());
        System.out.println(b.toString());
    }
}
