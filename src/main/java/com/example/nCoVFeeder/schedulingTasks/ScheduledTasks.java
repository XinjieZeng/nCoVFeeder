package com.example.nCoVFeeder.schedulingTasks;

import com.example.nCoVFeeder.broker.CoVirusProgressBroker;
import com.example.nCoVFeeder.caching.ProgressRepository;
import com.example.nCoVFeeder.client.CoVirusClient;
import com.example.nCoVFeeder.model.CoronaVirusRequestWrapper;
import com.example.nCoVFeeder.model.CoronavirusResultWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

   @Autowired
   private ProgressRepository progressRepository;

   private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

   @Scheduled(fixedRate = 3600000)
    public void reportCurrentTime(){
       CoVirusClient client = new CoVirusClient();
       CoronavirusResultWrapper result = new CoronavirusResultWrapper();

       result.setCoronavirusProgress(client.requestProgress());
       result.setRumor(client.requestRumor());
       progressRepository.updateCoronavirus(result);

       log.info("The progress of coronavirus is {}", result.getCoronavirusProgress());
       log.info("The rumor of coronavirus is {}", result.getRumor());
       progressRepository.updateCoronavirus(result);

       log.info("in the cache: The progress of conorovirus is: {}", progressRepository.getCoronavirusProgress());
       log.info("in the cache: The progress of conorovirus is: {}", progressRepository.getCoronavirusProgress());

   }


}
