package com.peter.fanxing._01_继承性;

import java.util.ArrayList;
import java.util.List;

public class GenericMethodDemo {

}


class Creature<T>{
    private String name;
    private String livingPlace;

    public <E> List<E> walkWay(E walkWay){
        List<E> list = new ArrayList<>();
        return list;
    }
}