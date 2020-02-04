package com.example.nCoVFeeder.client;
import com.example.nCoVFeeder.model.CoronavirusProgress;
import com.example.nCoVFeeder.model.Rumor;
import com.example.nCoVFeeder.model.api;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


@Component
public class CoVirusClient {
    private RestTemplate restTemplate = new RestTemplate();
    private final String CONOVIRUS_PROGRESS_URI = api.CORONOVIRUS_PROGRESS.url();
    private final String CONOVIRUS_RUMOR_URI = api.CORONOVIRUSRUMOR.url();

    public CoronavirusProgress requestProgress(){
        try {
            return restTemplate.getForObject(CONOVIRUS_PROGRESS_URI, CoronavirusProgress.class);
        } catch (RestClientException e) {
            throw new RuntimeException();
        }
    }

    public Rumor requestRumor(){
        try{
            return restTemplate.getForObject(CONOVIRUS_RUMOR_URI,Rumor.class);
        }
        catch (RestClientException e){
            throw new RuntimeException();
        }
    }

}
