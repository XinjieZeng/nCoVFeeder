package com.example.nCoVFeeder.client;

import com.example.nCoVFeeder.model.*;
import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class TranslatorClient {

    @Value("${azure.secret}")
    private String subscriptionKey;
    private static String endpoint = api.TRANSLATOR_TEXT.url();
    private static String AUTHORIZATION_HEADER_NAME = "Ocp-Apim-Subscription-Key";
    String url = endpoint + "/translate?api-version=3.0&from=zh-Han&to=en";
    private static final Logger log = LoggerFactory.getLogger(TranslatorClient.class);

    public List<TranslateResponse> translateProgress(List<TranslateRequest> translateTexts)  {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(AUTHORIZATION_HEADER_NAME, subscriptionKey);
        HttpEntity<List<TranslateRequest>> request = new HttpEntity<>(translateTexts, httpHeaders);
        return restTemplate.exchange(url, HttpMethod.POST, request, new ParameterizedTypeReference<List<TranslateResponse>>() {}).getBody();
    }

    public Rumor translateRumor(Rumor rumor){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Rumor> request = new HttpEntity<>(rumor);
        Rumor res = restTemplate.postForObject(url, request, Rumor.class);
        log.info(res.toString());
        return res;
    }
}
