package com.example.nCoVFeeder.model;

import java.util.Locale;

public class CoronaVirusRequestWrapper {
    private String city;
    private String rumor;
    private Locale acceptLanguage;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRumor() {
        return rumor;
    }

    public Locale getAcceptLanguage() {
        return acceptLanguage;
    }

    public void setAcceptLanguage(Locale acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
    }

    public void setRumor(String rumor) {
        this.rumor = rumor;
    }
}
