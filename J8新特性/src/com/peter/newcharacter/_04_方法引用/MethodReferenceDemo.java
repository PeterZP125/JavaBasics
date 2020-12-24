package com.peter.newcharacter._04_方法引用;

import com.peter.newcharacter.bean.Person;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        Person p = new Person("peter", 10);
        Supplier<String> stringSupplier = () -> p.getName();

        stringSupplier = new Person("Tom", 20) :: getName;
        System.out.println(stringSupplier.get());

        System.out.println("---------------------");
        Comparator<Integer> comparator = (num1, num2) -> num1.compareTo(num2);

        System.out.println(comparator.compare(2, 3));

        Comparator<Integer> comparator1 = Integer :: compareTo;

        System.out.println("----------------------");
        Function<Person, String> function = Person :: getName;
        Function<Person, String> functionLambda = (Person e) -> e.getName();
        System.out.println(functionLambda.apply(new Person("ttt", 40)));
        System.out.println(function.apply(new Person("Tom", 20)));
    }
}
