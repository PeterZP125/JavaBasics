package com.peter.collection._01_常用方法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CommonMethods {
    public static void main(String[] args) {
        Collection collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add("Peter");
        collection.add(new int[]{1, 2, 3});
        System.out.println(collection);
//        contains(Object obj):判断集合中是否有指定元素
        System.out.println(collection.contains(1));
//        containsAll(Collection coll):判断集合中是否包含指定集合中的所有元素
        System.out.println(collection.containsAll(Arrays.asList(1, 2)));
//        remove(Object obj):删除某元素
        collection.remove(2);
        System.out.println(collection);
//        removeAll(Collection coll):删除集合和指定集合中的交集元素
        collection.add(2);
        collection.removeAll(Arrays.asList(1,2,3));
        System.out.println(collection);
//        retrainAll(Collection coll):获取指定集合和当前集合的交集
        collection.retainAll(Arrays.asList("Peter"));
        System.out.println(collection);
//        equals(Object obj):看集合中元素和指定集合中元素相等，是否需要看有序需要依据实现类
        System.out.println(collection.equals(Arrays.asList("Peter")));
//        hashCode()
//        toArray()：转换为数组
//        iterator():返回Iterator接口的实例。用于遍历
    }
}
