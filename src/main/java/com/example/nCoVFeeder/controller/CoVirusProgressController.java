package com.example.nCoVFeeder.controller;

import com.example.nCoVFeeder.broker.CoVirusProgressBroker;
import com.example.nCoVFeeder.model.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class CoVirusProgressController {
    private static final Locale CHINESE = Locale.SIMPLIFIED_CHINESE;
    @Value("${azure.secret}")
    private String secret;

    @Autowired
    private CoVirusProgressBroker broker;
    @Operation(summary = "Get the current situation of New Cornovirus in China",
                description = "## This endpoint use open api doc ")
    @GetMapping(value = "/progress", produces = MediaType.APPLICATION_JSON_VALUE)
    public CoronavirusResultWrapper getCoVirusProgress(@RequestHeader(value = "Accept-Language", required = false, defaultValue = "zh-CN") String rawLocale,
                                                           @RequestParam(value="city", defaultValue="") String city,
                                                       @RequestParam(value="rumor", defaultValue="") String rumor){
        CoronaVirusRequestWrapper request = new CoronaVirusRequestWrapper();
        request.setCity(city);
        request.setRumor(rumor);
        request.setAcceptLanguage(new Locale(rawLocale));
        return broker.sendRequest(request);
    }
}
