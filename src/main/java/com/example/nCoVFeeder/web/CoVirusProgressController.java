package com.example.nCoVFeeder.web;

import com.example.nCoVFeeder.model.City;
import com.example.nCoVFeeder.model.CoronavirusProgress;
import com.example.nCoVFeeder.model.Newslist;
import com.example.nCoVFeeder.model.api;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;

@RestController
public class CoVirusProgressController {
    private String httpUrl = api.CORONAVIRUS_PROGRESS.url();


    @GetMapping("/progress")
    public Object getCoVirusProgress(@RequestParam(value = "city", defaultValue = "") String arg){

        CoronavirusProgress totalRes = request(httpUrl);

        if(getCityconoraVirusProgress(totalRes, arg) == null){
            return totalRes;
        }

        return getCityconoraVirusProgress(totalRes,arg);


    }

    private City getCityconoraVirusProgress(CoronavirusProgress coronavirusProgress, String arg){
        Newslist[] newsLists = coronavirusProgress.getNewslist();

        for (Newslist newslist : newsLists) {
            City[] cityList = newslist.getCities();

            for (City city : cityList) {
                if (city.getCityName().equals(arg)) {
                    return city;
                }
            }

        }

        return null;
    }





    private CoronavirusProgress request(String httpUrl){
        ObjectMapper mapper  = new ObjectMapper();
        CoronavirusProgress coronavirusProgress = new CoronavirusProgress();

        try{
            URL url = new URL(httpUrl);
            coronavirusProgress = mapper.readValue(url, CoronavirusProgress.class);

        }catch (Exception e){
            e.printStackTrace();
        }

        return coronavirusProgress;
    }

}
