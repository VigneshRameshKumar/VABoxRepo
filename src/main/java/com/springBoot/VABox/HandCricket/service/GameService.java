package com.springBoot.VABox.HandCricket.service;


import com.springBoot.VABox.HandCricket.model.ComputerModelClass;
import com.springBoot.VABox.HandCricket.model.PlayerClass;
import com.springBoot.VABox.HandCricket.util.JsonHelperClass;
import com.springBoot.VABox.HandCricket.util.RandomClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service
public class GameService extends RandomClass {

    // Initializing two Players one is computer and other User
    static PlayerClass player=new PlayerClass("Player");
    static PlayerClass computer=new PlayerClass("Computer");


    JsonHelperClass convert = new JsonHelperClass();
    ComputerModelClass comStore=new ComputerModelClass();
    Boolean compare;
    public static final Logger logger = LoggerFactory.getLogger(GameService.class);


// Function to perform toss
    public String CoinTossAction(String choice)  {
        // Remove "" from Head or Tail
        String removeQuotesTemp=convert.removeQuotes(choice);
        // This flag is used to indicate whether Computer won the toss
        comStore.setComWonToss(false);
        // Convert Head or tail to int
        int choiceInt= (removeQuotesTemp).equals("Head")?1:2;
        // Get a random 2 number to stimulate a coin toss scenario and store it
        int computerToss=Random2();
        // This will be return to endpoint to give what toss was
        comStore.setActualToss(computerToss==1?"Head":"Tail");
        // Check if the user choice match the toss
        compare=choiceInt==computerToss?true:false;

        if(!compare){
            //If user choice was not set that means computer won the toss
            comStore.setComWonToss(true);
        }

        convert.delayInSeconds(1);

        return compare?"Toss won":"Lost the toss";
    }

    //To get  actual toss was from the CoinTossAction()
    public String ActualTossSer(){
        return comStore.getActualToss();
    }

    //Function to return whether computer won the toss or not from the CoinTossAction()
    public  boolean doesComputerWonToss(){
        return comStore.isComWonToss();
    }

    //This function will be called when computer won the toss and returns computer choice to bat or bowl
    public String computerChooseBatorBowl(){
        String computerChoiceTempVar = Random2()==1?"Computer choose to Bat first":"Computer choose to Bowl first";
        computer.setBatting(computerChoiceTempVar.equals("Batting")?"first":"second");
        player.setBatting(computer.getBatting().equals("first")?"second":"first");
        return computerChoiceTempVar;
    }

    // This function will be called when User won the toss , Batting or bowling Fn
    public String playChoosingAction(String playerChoice) {

        String removeQuotesTemp=convert.removeQuotes(playerChoice);

        player.setBatting("Batting".equals(removeQuotesTemp)?"first":"second");
        computer.setBatting(player.getBatting().equals("first")?"second":"first");
        return player.getBatting();
    }
    //Player score for scoreboard
    public int getPlayerScore(){
        return player.getScore();
    }
    //Computer score for scoreboard
    public int getComputerScore(){
        return computer.getScore();
    }

    // This fn to be called when refresh button is pressed , clear all global variable to initial state
    public void resetGlobalToss(){
        player=new PlayerClass("Player");
        computer=new PlayerClass("Computer");
    }

}
