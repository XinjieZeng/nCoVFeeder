package com.example.nCoVFeeder.caching;

import com.example.nCoVFeeder.model.CoronavirusProgress;
import com.example.nCoVFeeder.model.CoronavirusResultWrapper;
import com.example.nCoVFeeder.model.Rumor;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class ProgressRepository {
    private AtomicReference<CoronavirusProgress> coronavirusProgress = new AtomicReference<>();
    private AtomicReference<Rumor> rumorAtomicReference = new AtomicReference<>();

    public Optional<CoronavirusProgress> getCoronavirusProgress() {
        return Optional.ofNullable(coronavirusProgress).map(AtomicReference::get);
    }

    public void updateCoronavirus(CoronavirusResultWrapper wrapper) {
        this.coronavirusProgress.set(wrapper.getCoronavirusProgress());
        this.rumorAtomicReference.set(wrapper.getRumor());
    }

    public Optional<Rumor> getRumor(){
        return Optional.ofNullable(rumorAtomicReference).map(AtomicReference::get);
    }
}
