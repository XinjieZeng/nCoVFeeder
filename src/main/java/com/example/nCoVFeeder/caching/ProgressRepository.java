package com.example.nCoVFeeder.caching;

import com.example.nCoVFeeder.client.TranslatorClient;
import com.example.nCoVFeeder.model.CoronavirusProgress;
import com.example.nCoVFeeder.model.CoronavirusResultWrapper;
import com.example.nCoVFeeder.model.Rumor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

@Component
public class ProgressRepository {

    private Map<Locale, CoronavirusProgress> coronavirusProgressMap = new HashMap<>();
    private Map<Locale, Rumor> rumorMap = new HashMap<>();

    public Optional<CoronavirusProgress> getCoronavirusProgress(Locale locale) {
        return Optional.ofNullable(coronavirusProgressMap.get(locale));
    }

    public void updateCoronavirus(Locale locale, CoronavirusResultWrapper wrapper) {
        coronavirusProgressMap.put(locale, wrapper.getCoronavirusProgress());
        rumorMap.put(locale, wrapper.getRumor());
    }


    public Optional<Rumor> getRumor(Locale locale){
        return Optional.ofNullable(rumorMap.get(locale));
    }
}
