package com.springBoot.VABox.HandCricket.service;

import com.springBoot.VABox.HandCricket.model.PlayerClass;
import com.springBoot.VABox.HandCricket.util.JsonHelperClass;
import com.springBoot.VABox.HandCricket.util.RandomClass;
import org.springframework.stereotype.Service;

@Service
public class SecondPhaseService extends RandomClass {


    boolean isSecondBatting=false;
    public boolean MatchOver =false;
    public int total=0;
    public int compGuess=0;
    public int target=0;
    PlayerClass currentBatting=null;
    JsonHelperClass convert = new JsonHelperClass();


    public void valuePressedByPlayer(String value){
        //logger.info("player batting ? {} ",player.getBatting());
        //logger.info("computer batting ? {} ",computer.getBatting());


        int valueInt = Integer.parseInt(convert.removeQuotes(value));
        if(currentBatting==null && !isSecondBatting){
            currentBatting=GameService.player.getBatting().equals("first")? GameService.player : GameService.computer;
        }

        batting(currentBatting,valueInt);

        GameService.logger.info("Current Player = {}",currentBatting.name);
        GameService.logger.info("Computer guess = {}",compGuess);
        GameService.logger.info("Player guess = {}",valueInt);
        GameService.logger.info("Total = {}",total);
        GameService.logger.info("Target = {}",target);
        GameService.logger.info("Is match over = {}", MatchOver);

    }
    public void batting(PlayerClass obj,int guess){
        if(MatchOver){
            GameService.logger.info("Player score = {} and Computer score ={}", GameService.player.getScore(), GameService.computer.getScore());
            return;
        }
        compGuess = Random6();

        if (guess != compGuess ) {
            total += obj.name.equals("Player") ? guess : compGuess;
            obj.setScore(total);
            if (isSecondBatting && total > target) {
                GameService.logger.info("Reached Target");
                obj.setScore(total);
                MatchOver = true;
            }
        }
        else {
            obj.setScore(total);

            if (!isSecondBatting) {
                target = obj.getScore();
                currentBatting = obj.name.equals("Player") ? GameService.computer : GameService.player;
                isSecondBatting=true;
                total = 0;
            }
            else {
                GameService.logger.info("Out before target reached");
                MatchOver = true;
            }
        }
    }
    public String MatchDecision(){
        String matchResult="Match Draw";
        if(GameService.player.getScore()!=GameService.computer.getScore()){
            matchResult=GameService.player.getScore()>GameService.computer.getScore()?"Player won by ":"Computer won by ";
            matchResult=matchResult+Math.abs(GameService.player.getScore()-GameService.computer.getScore()) + " runs";
        }

        return matchResult;
    }


public void resetGlobalSecondSer(){
    isSecondBatting=false;
    MatchOver =false;
    total=0;
    compGuess=0;
    target=0;
    currentBatting=null;
    }

}
