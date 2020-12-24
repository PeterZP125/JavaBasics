package com.peter.newcharacter._03_内置函数式接口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class OOFDemo {

    public static List<String> filterString(List<String> list, Predicate<String> predicate){
        List<String> filterLists = new ArrayList<>();

        for (String s : list) {
            if(predicate.test(s)){
                filterLists.add(s);
            }
        }
        return filterLists;
    }

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("周杰伦","周杰","周婕","王力宏");
        List<String> filterStrs = OOFDemo.filterString(strs, s -> s.contains("周"));
//        原来的写法
//        filterStrs = OOFDemo.filterString(strs, new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.contains("杰");
//            }
//        });

        System.out.println(filterStrs.toString());
    }
}
