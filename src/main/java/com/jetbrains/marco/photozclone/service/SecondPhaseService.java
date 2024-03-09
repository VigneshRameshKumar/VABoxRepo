package com.jetbrains.marco.photozclone.service;

import com.jetbrains.marco.photozclone.model.PlayerClass;
import org.springframework.stereotype.Service;

@Service
public class SecondPhaseService extends GameService {
    boolean isSecondBatting=false;
    public boolean isMatchOver=false;
    public int total=0;
    public int compGuess=0;
    int target=0;
    PlayerClass currentBatting=null;


    public int valuePressedByPlayer(String value){
        logger.info("player batting ? {} ",player.getBatting());
        logger.info("computer batting ? {} ",computer.getBatting());

        int currentTotal;
        int valueInt = Integer.parseInt(convert.removeQuotes(value));
        if(currentBatting==null && !isSecondBatting){
            currentBatting=GameService.player.getBatting().equals("first")?player:computer;
        }

        batting(currentBatting,valueInt);

        logger.info("Total = {}",total);
        logger.info("Computer guess = {}",compGuess);
        return compGuess;
    }
    public void batting(PlayerClass obj,int guess){
        compGuess=Random6();
        if(guess!=compGuess){
            if(obj.name.equals("Player")){
                total=total+guess;
            }
            else {
                total=total+compGuess;
            }
            if(isSecondBatting){
                if(total>=target){
                    obj.setScore(total);
                    isMatchOver=true;
                }
            }
        }
        else {
            obj.setScore(total);
            if (!isSecondBatting){
                currentBatting=currentBatting.name.equals("Player")?computer:player;
                total=0;
            }
            else {
                isMatchOver=true;
            }

        }

    }

}
