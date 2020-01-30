package com.example.nCoVFeeder.client;

import com.example.nCoVFeeder.model.CoronavirusProgress;
import com.example.nCoVFeeder.model.Rumor;
import com.example.nCoVFeeder.model.api;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;

public class CoVirusClient {

    private final String CONOVIRUS_PROGRESS = api.CORONOVIRUS_PROGRESS.url();
    private final String CONOVIRUS_RUMOR = api.CORONOVIRUSRUMOR.url();

    public CoronavirusProgress requestProgress(){
        ObjectMapper mapper  = new ObjectMapper();
        CoronavirusProgress coronavirusProgress = new CoronavirusProgress();

        try{
            URL url = new URL(CONOVIRUS_PROGRESS);
            coronavirusProgress = mapper.readValue(url, CoronavirusProgress.class);

        }catch (Exception e){
            e.printStackTrace();
        }

        return coronavirusProgress;
    }

    public Rumor requestRumor(){
        ObjectMapper mapper  = new ObjectMapper();
        Rumor rumor = new Rumor();

        try{
            URL url = new URL(CONOVIRUS_RUMOR);
            rumor = mapper.readValue(url, Rumor.class);

        }catch (Exception e){
            e.printStackTrace();
        }

        return rumor;
    }

}
