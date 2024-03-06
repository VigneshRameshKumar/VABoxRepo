package com.jetbrains.marco.photozclone.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jetbrains.marco.photozclone.model.Response;
import com.jetbrains.marco.photozclone.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Cricketcontroller {
    @Autowired
    private final GameService tossServ;
    private static final Logger logger = LoggerFactory.getLogger(Cricketcontroller.class);
    Response result=new Response();
    String data;
    public Cricketcontroller(GameService tossServ) {
        this.tossServ = tossServ;
    }

    @PostMapping("/toss")
    public Response printTossResult(@RequestBody String toss)  {
        // Process form data (you can save it to a database, perform some logic, etc.)
        // For simplicity, we'll just echo back a response.

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

}
