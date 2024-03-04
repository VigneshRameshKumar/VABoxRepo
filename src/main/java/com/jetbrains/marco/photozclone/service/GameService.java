package com.jetbrains.marco.photozclone.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jetbrains.marco.photozclone.model.PlayerClass;
import com.jetbrains.marco.photozclone.util.JsonHelperClass;
import com.jetbrains.marco.photozclone.util.RandomClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GameService extends RandomClass {
    PlayerClass player=new PlayerClass("Player");
    PlayerClass computer=new PlayerClass("Computer");
    JsonHelperClass convert = new JsonHelperClass();
    String actualTossVar;
    private static final Logger logger = LoggerFactory.getLogger(GameService.class);


    public String CoinTossAction(String choice)  {
        String removeQuotesTemp=convert.removeQuotes(choice);
        int choiceInt= (removeQuotesTemp).equals("Head")?1:2;
        int computerToss=Random2();
       // logger.info("{} output of removeQuotes",removeQuotesTemp);
        logger.info("actual toss in Service is {},User value {}",computerToss,choiceInt);
        actualTossVar=computerToss==1?"Head":"Tail";
        return choiceInt==computerToss?"Toss won":"Lost the toss";

    }
    public String ActualTossSer(){
        logger.info("Value of actual toss in Service is {}",actualTossVar);
        return actualTossVar;
    }
    public String playChoosingAction(String playerChoice) {

        String removeQuotesTemp=convert.removeQuotes(playerChoice);

        player.setBatting("Batting".equals(removeQuotesTemp)?"first":"second");
        return player.getBatting();
    }

}
