package com.example.nCoVFeeder.model;

public enum api {
    CORONOVIRUS_PROGRESS("http://api.tianapi.com/txapi/ncovcity/index"),
    CORONOVIRUSRUMOR("http://api.tianapi.com/txapi/rumour/index"),
    TRANSLATOR_TEXT("https://api.cognitive.microsofttranslator.com");

    private String url;

    api(String url){
        this.url = url;
    }

    public String url(){
        return url;
    }
}
