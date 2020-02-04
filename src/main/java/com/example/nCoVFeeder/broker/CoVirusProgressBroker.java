package com.example.nCoVFeeder.broker;

import com.example.nCoVFeeder.caching.ProgressRepository;
import com.example.nCoVFeeder.client.CoVirusClient;
import com.example.nCoVFeeder.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoVirusProgressBroker {

    @Autowired
    private ProgressRepository progressRepository;

    public CoronavirusResultWrapper sendRequest(CoronaVirusRequestWrapper request){

        CoronavirusResultWrapper wrapper = new CoronavirusResultWrapper();

        if(!request.getCity().equals("")){

            if(progressRepository.getCoronavirusProgress().isPresent()){
                City city = getCityconoraVirusProgress(progressRepository.getCoronavirusProgress().get(), request.getCity());
                wrapper.setCity(city);
                wrapper.setCoronavirusProgress(null);
            }
        }

        if(!request.getRumor().equals("")){
            if(progressRepository.getRumor().isPresent()){
                Rumor rumor = progressRepository.getRumor().get();
                wrapper.setRumor(rumor);
            }
        }

        return wrapper;
    }

    private City getCityconoraVirusProgress(CoronavirusProgress coronavirusProgress, String arg){
        List<Newslist> newsLists = coronavirusProgress.getNewslist();

        for (Newslist newslist : newsLists) {
            List<City> cityList = newslist.getCities();

            for (City city : cityList) {
                if (city.getCityName().equals(arg)) {
                    return city;
                }
            }

        }

        return null;
    }
}
