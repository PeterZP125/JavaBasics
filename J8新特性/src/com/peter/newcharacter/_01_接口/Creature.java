package com.peter.newcharacter._01_接口;

import javax.sound.midi.Soundbank;

public interface Creature {

    public static void breath(){
        System.out.println("所有生物都需要呼吸");
    }

    public default void sleep(){
        System.out.println("所有动物都要睡觉");
    }

}
