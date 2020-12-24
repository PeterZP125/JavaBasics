package com.peter.newcharacter._01_接口;

public class Bat implements Creature {
    public void sleep(){
        System.out.println("蝙蝠白天睡觉");
        //调用接口的默认方法
        Creature.super.sleep();
        //调用接口的静态方法
        Creature.breath();
    }
}
