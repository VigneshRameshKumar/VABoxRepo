package com.jetbrains.marco.photozclone.service;

import com.jetbrains.marco.photozclone.util.RandomClass;
import org.springframework.stereotype.Service;

@Service
public class tossService extends RandomClass {

    public String CoinToss(String choice){
        int choiceInt=choice=="Head"?1:2;
        return choiceInt==Random2()?"Toss won":"Lost the toss";
    }
}
