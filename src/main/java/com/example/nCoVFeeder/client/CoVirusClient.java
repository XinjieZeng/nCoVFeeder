package com.example.nCoVFeeder.client;
import com.example.nCoVFeeder.model.CoronavirusProgress;
import com.example.nCoVFeeder.model.Rumor;
import com.example.nCoVFeeder.model.api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;


@Component
public class CoVirusClient {

    @Value("${ncovirus.secret}")
    private String subspcriptionKey;

    private RestTemplate restTemplate = new RestTemplate();
    private String conovirusProgressUrl = api.CORONOVIRUS_PROGRESS.url() + "?key=" + "54a8d925c25e919a7a7837128651971a";
    private String rumorUrl = api.CORONOVIRUSRUMOR.url() + "?key=" + "54a8d925c25e919a7a7837128651971a";

    public CoronavirusProgress requestProgress(){
        try {
            return restTemplate.getForObject(conovirusProgressUrl, CoronavirusProgress.class);
        } catch (RestClientException e) {
            throw new RuntimeException();
        }
    }

    public Rumor requestRumor(){
        try{
            return restTemplate.getForObject(rumorUrl,Rumor.class);
        }
        catch (RestClientException e){
            throw new RuntimeException();
        }
    }

//@PostConstruct
//    public void postConstruct() {
//        conovirusProgressUrl = api.CORONOVIRUS_PROGRESS.url() + "?key=" + subspcriptionKey;
//        rumorUrl = api.CORONOVIRUSRUMOR.url() + "?key=" + subspcriptionKey;
//    }

}
