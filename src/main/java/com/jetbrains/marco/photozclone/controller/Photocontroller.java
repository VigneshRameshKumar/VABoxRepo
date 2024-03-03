package com.jetbrains.marco.photozclone.controller;

import com.jetbrains.marco.photozclone.model.Response;
import com.jetbrains.marco.photozclone.service.tossService;
import org.springframework.web.bind.annotation.*;

@RestController
public class Photocontroller {
    private final tossService tossServ;

    public Photocontroller(tossService tossServ) {
        this.tossServ = tossServ;
    }

    @PostMapping("/toss")
    public Response submitForm(@RequestBody String toss) {
        // Process form data (you can save it to a database, perform some logic, etc.)
        // For simplicity, we'll just echo back a response.
        Response result=new Response();
        result.setTossResult(tossServ.CoinToss(toss));
        return result;




    }



}
