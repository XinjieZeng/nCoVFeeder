package com.example.nCoVFeeder.broker;

import com.example.nCoVFeeder.caching.ProgressRepository;
import com.example.nCoVFeeder.client.TranslatorClient;
import com.example.nCoVFeeder.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class CoVirusProgressBroker {

    @Autowired
    private ProgressRepository progressRepository;

    @Autowired
    private TranslatorClient translatorClient;

    public CoronavirusResultWrapper sendRequest(CoronaVirusRequestWrapper request){

        CoronavirusResultWrapper wrapper = new CoronavirusResultWrapper();

        Locale locale = request.getAcceptLanguage();

        wrapper.setCoronavirusProgress(progressRepository.getCoronavirusProgress(Locale.SIMPLIFIED_CHINESE).get());

        if(!progressRepository.getCoronavirusProgress(locale).isPresent()){

            List<Map<String, Integer>> translateMap = prepareTranslateMap(progressRepository.getCoronavirusProgress(Locale.SIMPLIFIED_CHINESE).get());

            CoronavirusProgress translated = new CoronavirusProgress();
            translated.setNewslist(new ArrayList<>(wrapper.getCoronavirusProgress().getNewslist()));

            for(int provinceIndex = 0; provinceIndex < translateMap.size(); provinceIndex++) {
                Map<String, Integer> textIdMap = translateMap.get(provinceIndex);

                List<TranslateRequest> raw = prepareTranslateRequest(translateMap.get(provinceIndex));

                List<TranslateResponse> responses = translatorClient.translateProgress(raw);
                Map<Integer, String> translatedMap = responses.stream()
                        .flatMap(t -> t.getTranslations().stream())
                        .map(this::parseTranslateText)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

                Newslist originNewslist = wrapper.getCoronavirusProgress().getNewslist().get(provinceIndex);

                Integer provinceId = textIdMap.get(originNewslist.getProvinceName());
                String translatedProvince = translatedMap.get(provinceId);
                translated.getNewslist().get(provinceIndex).setProvinceName(translatedProvince);

                Integer provinceShortId = textIdMap.get(originNewslist.getProvinceShortName());
                String translatedProvinceShort = translatedMap.get(provinceShortId);
                translated.getNewslist().get(provinceIndex).setProvinceShortName(translatedProvinceShort);

                translated.getNewslist().get(provinceIndex).getCities()
                        .forEach(city -> {
                            String cityName = city.getCityName();
                            Integer cityId = textIdMap.get(cityName);
                            String translatedCity = translatedMap.get(cityId);
                            city.setCityName(translatedCity);
                        });
            }

//            Rumor rumor = translatorClient.translateRumor(progressRepository.getRumor(Locale.SIMPLIFIED_CHINESE).get());
//            wrapper.setRumor(rumor);
            wrapper.setCoronavirusProgress(translated);
            progressRepository.updateCoronavirus(locale,wrapper);
        }


        if(!request.getCity().equals("")){
            City city = getCityconoraVirusProgress(progressRepository.getCoronavirusProgress(locale).get(), request.getCity());
            wrapper.setCity(city);
            wrapper.setCoronavirusProgress(null);
        }

        if(!request.getRumor().equals("")){
            wrapper.setRumor(progressRepository.getRumor(locale).get());
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

    private List<Map<String, Integer>> prepareTranslateMap(CoronavirusProgress progress) {

        return progress.getNewslist()
                .stream()
                .map(newslist -> {
                    final AtomicInteger incrementor = new AtomicInteger(0);
                    Map<String, Integer> translateTextMap = new LinkedHashMap<>();

                    translateTextMap.put(newslist.getProvinceName(), incrementor.getAndIncrement());
                    translateTextMap.put(newslist.getProvinceShortName(), incrementor.getAndIncrement());
                    newslist.getCities()
                            .forEach(city -> translateTextMap.put(city.getCityName(), incrementor.getAndIncrement()));

                    return translateTextMap;

                }).collect(Collectors.toList());
    }

    private List<TranslateRequest> prepareTranslateRequest(Map<String, Integer> idTranslateMap) {
            return idTranslateMap.entrySet()
                    .stream()
                    .map(entry -> new TranslateRequest(entry.getValue()+ "-" + entry.getKey()))
                    .collect(Collectors.toList());
    }

//    private CoronavirusProgress createTranslatedCoronavirusProgress(Map<String, Integer> rawTextIdMap, CoronavirusProgress origin, List<TranslateResponse> translateResponses) {
//        CoronavirusProgress translatedCoronavirusProgress = new CoronavirusProgress();
//        translatedCoronavirusProgress.setNewslist(new ArrayList<>(origin.getNewslist()));
//
//        Map<Integer, String> translateMap = translateResponses.stream()
//                .flatMap(t -> t.getTranslations().stream())
//                .map(this::parseTranslateText)
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//
//        translatedCoronavirusProgress.getNewslist()
//                .forEach(newslist -> {
//                    Integer key = rawTextIdMap.get(newslist.getProvinceName());
//                    String translatedProvinceName = translateMap.get(key);
//                    newslist.setProvinceName(translatedProvinceName);
//
//                    key = rawTextIdMap.get(newslist.getProvinceShortName());
//                    String translatedProvinceShortName = translateMap.get(key);
//                    newslist.setProvinceShortName(translatedProvinceShortName);
//
//                    newslist.getCities().forEach(city ->{
//                        Integer cityKey = rawTextIdMap.get(city.getCityName());
//                        String translatedCityName = translateMap.get(cityKey);
//                        city.setCityName(translatedCityName);
//
//                    });
//                });
//
//        return translatedCoronavirusProgress;
//    }

    private Map.Entry<Integer, String> parseTranslateText(TranslateResponse.Text text) {
        String[] raws = text.getText().split("-");
        Integer key = Integer.parseInt(raws[0]);
        String value = raws[1];
        return new AbstractMap.SimpleEntry<>(key, value);
    }
}
