package com.peter._09_类型转换;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Param2Bean {
    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "Peter");
        params.put("age", 22);
        Person p = param2Bean(params, Person.class);
        System.out.println(p);

    }

    public static <T> T param2Bean(Map params, T t){
        try {
            BeanUtils.populate(t, params);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static <T> T param2Bean(Map params, Class<?> clazz){
        T obj = null;
        try {
            obj = (T) clazz.newInstance();
            BeanUtils.populate(obj, params);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
