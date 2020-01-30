package com.example.nCoVFeeder.model;

public class CoronavirusResultWrapper {

    private CoronavirusProgress coronavirusProgress;
    private City city;
    private Rumor rumor;

    public CoronavirusProgress getCoronavirusProgress() {
        return coronavirusProgress;
    }

    public void setCoronavirusProgress(CoronavirusProgress coronavirusProgress) {
        this.coronavirusProgress = coronavirusProgress;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Rumor getRumor() {
        return rumor;
    }

    public void setRumor(Rumor rumor) {
        this.rumor = rumor;
    }
}
