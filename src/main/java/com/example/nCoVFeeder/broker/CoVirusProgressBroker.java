package com.example.nCoVFeeder.broker;

import com.example.nCoVFeeder.client.CoVirusClient;
import com.example.nCoVFeeder.model.*;

public class CoVirusProgressBroker {

    public CoronavirusResultWrapper sendRequest(CoronaVirusRequestWrapper request){
        CoVirusClient client = new CoVirusClient();
        CoronavirusResultWrapper wrapper = new CoronavirusResultWrapper();
        CoronavirusProgress coronavirusProgress = client.requestProgress();
        wrapper.setCoronavirusProgress(coronavirusProgress);


        if(!request.getCity().equals("")){
            City city = getCityconoraVirusProgress(coronavirusProgress, request.getCity());
            wrapper.setCity(city);
            wrapper.setCoronavirusProgress(null);
        }
        if(!request.getRumor().equals("")){
            Rumor rumor = client.requestRumor();
            wrapper.setRumor(rumor);
        }

        return wrapper;
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
}
