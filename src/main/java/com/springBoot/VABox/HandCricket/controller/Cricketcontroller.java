package com.springBoot.VABox.HandCricket.controller;

import com.springBoot.VABox.HandCricket.model.Response;
import com.springBoot.VABox.HandCricket.service.GameService;
import com.springBoot.VABox.HandCricket.service.SecondPhaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Cricketcontroller {
    @Autowired
    private final GameService tossServ;
    private final SecondPhaseService matchServ;

    private static final Logger logger = LoggerFactory.getLogger(Cricketcontroller.class);
    Response result=new Response();
    String data;

    public Cricketcontroller(GameService tossServ, SecondPhaseService matchServ) {
        this.tossServ = tossServ;
        this.matchServ = matchServ;
    }

    @PostMapping("/toss")
    public Response printTossResult(@RequestBody String toss)  {

        result.setTossResult(tossServ.CoinTossAction(toss));
        result.setActualToss(tossServ.ActualTossSer());
        result.setComWonTossFlag(tossServ.doesComputerWonToss());
        result.setComputerChoiceVar(tossServ.computerChooseBatorBowl());
        logger.info("Value of actual toss in controller is {}",result.getActualToss());
        return result;

    }
    @PostMapping("/playerChoosingEndpoint")
    public Response printBatOrBowlResult(@RequestBody String playerChoice) {
        result.setbatOrBowl(tossServ.playChoosingAction(playerChoice));
        data=result.getbatOrBowl();
        return result;
    }
    @PostMapping("/getPlayerInputEndpoint")
    public Response tempName(@RequestBody String value){
        logger.info("Value passed to service is {}",value);
        matchServ.valuePressedByPlayer(value);
        result.setCoumputerGuessVar(matchServ.compGuess);
        result.setCurrentTotalVar(matchServ.total);
        if(matchServ.compGuess==Integer.parseInt(value)){
            result.setTargetScoreVar(matchServ.target);
        }
        result.setMatchOverVar(matchServ.MatchOver);
        result.playerScore= tossServ.getPlayerScore();
        result.computerScore= tossServ.getComputerScore();
        if(matchServ.MatchOver){
            logger.info("match over condition{}",result.getActualToss());
            result.setMatchResult(matchServ.MatchDecision());
        }
        return result;
    }

    @PostMapping("/resetGlobalObject")
    public void resetGlobalObject() {
        tossServ.resetGlobalToss();
        matchServ.resetGlobalSecondSer();
    }
}
