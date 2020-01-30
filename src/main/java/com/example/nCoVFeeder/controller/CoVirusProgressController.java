package com.example.nCoVFeeder.controller;

import com.example.nCoVFeeder.broker.CoVirusProgressBroker;
import com.example.nCoVFeeder.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoVirusProgressController {

    @GetMapping("/progress")
    public CoronavirusResultWrapper getCoVirusProgress(@RequestParam(value="city", defaultValue="") String city, @RequestParam(value="rumor", defaultValue="") String rumor){
        CoronaVirusRequestWrapper request = new CoronaVirusRequestWrapper();
        request.setCity(city);
        request.setRumor(rumor);

        CoVirusProgressBroker broker = new CoVirusProgressBroker();
        return broker.sendRequest(request);
    }
}
