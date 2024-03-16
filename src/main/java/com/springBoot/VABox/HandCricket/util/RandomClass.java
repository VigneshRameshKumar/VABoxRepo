package com.springBoot.VABox.HandCricket.util;

import java.util.Random;

public class RandomClass {
    Random random = new Random();

    public int Random2(){
        // Generate a random number between 1 and 2 (inclusive)
        return random.nextInt(2) + 1;
    }

    public int Random6(){
         return random.nextInt(6)+1;
    }
}
