package com.jetbrains.marco.photozclone.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jetbrains.marco.photozclone.model.ComputerModelClass;
import com.jetbrains.marco.photozclone.model.PlayerClass;
import com.jetbrains.marco.photozclone.util.JsonHelperClass;
import com.jetbrains.marco.photozclone.util.RandomClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class GameService extends RandomClass {

    static PlayerClass player=new PlayerClass("Player");
    static PlayerClass computer=new PlayerClass("Computer");
    JsonHelperClass convert = new JsonHelperClass();
    ComputerModelClass comStore=new ComputerModelClass();
    Boolean compare;
    public static final Logger logger = LoggerFactory.getLogger(GameService.class);


    public String CoinTossAction(String choice)  {
        String removeQuotesTemp=convert.removeQuotes(choice);
        comStore.setComWonToss(false);
        int choiceInt= (removeQuotesTemp).equals("Head")?1:2;
        int computerToss=Random2();
       // logger.info("{} output of removeQuotes",removeQuotesTemp);
       // logger.info("actual toss in Service is {},User value {}",computerToss,choiceInt);
        comStore.setActualToss(computerToss==1?"Head":"Tail");
        compare=choiceInt==computerToss?true:false;
        if(!compare){
            comStore.setComWonToss(true);
        }

        convert.delayInSeconds(1);
        return compare?"Toss won":"Lost the toss";

    }
    public String ActualTossSer(){
       // logger.info("Value of actual toss in Service is {}",comStore.getActualToss());
        return comStore.getActualToss();
    }
    public  boolean doesComputerWonToss(){
        return comStore.isComWonToss();
    }
    public String computerChooseBatorBowl(){
        String computerChoiceTempVar = Random2()==1?"Batting":"Bowling";
        computer.setBatting(computerChoiceTempVar.equals("Batting")?"first":"second");
        player.setBatting(computer.getBatting().equals("first")?"second":"first");
        return computerChoiceTempVar;
    }

    public String playChoosingAction(String playerChoice) {

        String removeQuotesTemp=convert.removeQuotes(playerChoice);

        player.setBatting("Batting".equals(removeQuotesTemp)?"first":"second");
        computer.setBatting(player.getBatting().equals("first")?"second":"first");
        return player.getBatting();
    }

}
