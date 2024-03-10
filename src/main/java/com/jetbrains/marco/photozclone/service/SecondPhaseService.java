package com.jetbrains.marco.photozclone.service;

import com.jetbrains.marco.photozclone.model.PlayerClass;
import org.springframework.stereotype.Service;

@Service
public class SecondPhaseService extends GameService {
    boolean isSecondBatting=false;
    public boolean MatchOver =false;
    public int total=0;
    public int compGuess=0;
    int target=0;
    PlayerClass currentBatting=null;


    public int valuePressedByPlayer(String value){
        //logger.info("player batting ? {} ",player.getBatting());
        //logger.info("computer batting ? {} ",computer.getBatting());


        int valueInt = Integer.parseInt(convert.removeQuotes(value));
        if(currentBatting==null && !isSecondBatting){
            currentBatting=GameService.player.getBatting().equals("first")?player:computer;
        }
        if(!MatchOver){
            batting(currentBatting,valueInt);
        }
        logger.info("Current Player = {}",currentBatting.name);
        logger.info("Computer guess = {}",compGuess);
        logger.info("Player guess = {}",valueInt);
        logger.info("Total = {}",total);
        logger.info("Target = {}",target);
        logger.info("Is match over = {}", MatchOver);
        return compGuess;
    }
    public void batting(PlayerClass obj,int guess){
        compGuess = Random6();

        if (guess != compGuess && !MatchOver) {
            total += obj.name.equals("Player") ? guess : compGuess;

            if (isSecondBatting && total >= target) {
                logger.info("Reached Target");
                obj.setScore(total);
                MatchOver = true;
            }
        }
        else {
            obj.setScore(total);

            if (!isSecondBatting) {
                target = obj.getScore();
                currentBatting = obj.name.equals("Player") ? computer : player;
                isSecondBatting=true;
                total = 0;
            }
            else {
                logger.info("Out before target reached");
                MatchOver = true;
            }
        }
    }

}
