package com.jetbrains.marco.photozclone.util;

import java.util.Random;

public class RandomClass {

    public int Random2(){
        Random random = new Random();

        // Generate a random number between 1 and 2 (inclusive)
        int randomNumber = random.nextInt(2) + 1;
        return randomNumber;

    }
}
