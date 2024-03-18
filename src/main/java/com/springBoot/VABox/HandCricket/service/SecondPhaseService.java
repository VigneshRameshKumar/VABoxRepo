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

    // when number from 1 to 6 is pressed this service is called
    public void valuePressedByPlayer(String value){

        // Removing the quotes and  converting  to Int
        int valueInt = Integer.parseInt(convert.removeQuotes(value));

        // Set who is going to bat if not set
        if(currentBatting==null && !isSecondBatting){
            currentBatting=GameService.player.getBatting().equals("first")? GameService.player : GameService.computer;
        }

        //Batting logic and calculation
        batting(currentBatting,valueInt);

        GameService.logger.info("Current Player = {}",currentBatting.name);
        GameService.logger.info("Computer guess = {}",compGuess);
        GameService.logger.info("Player guess = {}",valueInt);
        GameService.logger.info("Total = {}",total);
        GameService.logger.info("Target = {}",target);
        GameService.logger.info("Is match over = {}", MatchOver);

    }
    public void batting(PlayerClass obj,int guess){

        // Continue if match is not over
        if(MatchOver){
            GameService.logger.info("Player score = {} and Computer score ={}",
                    GameService.player.getScore(), GameService.computer.getScore());
            return;
        }
        // computer generated value from 1 to 6
        compGuess = Random6();

        // Player guess and computer generated value should not be same to add score
        if (guess != compGuess ) {

            /* based on the current batsman score will be added that is in case of player batting guess to be added
             * and if computer is batting computer generate value to be added  */
            total += obj.name.equals("Player") ? guess : compGuess;
            obj.setScore(total);

            //Logic to end the game if it is second Batting and targeted run is reached
            if (isSecondBatting && total > target) {
                GameService.logger.info("Reached Target");
                obj.setScore(total);
                MatchOver = true;
            }
        }
        //The guess is equal which means batsman is out
        else {
            obj.setScore(total);

            // If not second batting we nned to set the target run
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

    //Function for comparing the score of player and computer and declare the result
    public String MatchDecision(){
        String matchResult="Match Draw";
        if(GameService.player.getScore()!=GameService.computer.getScore()){
            matchResult=GameService.player.getScore()>GameService.computer.getScore()?"Player won by ":"Computer won by ";
            matchResult=matchResult+Math.abs(GameService.player.getScore()-GameService.computer.getScore()) + " runs";
        }
        return matchResult;
    }

// Function to reset all the global variable back when refresh is clicked
public void resetGlobalSecondSer(){
    isSecondBatting=false;
    MatchOver =false;
    total=0;
    compGuess=0;
    target=0;
    currentBatting=null;
    }

}
