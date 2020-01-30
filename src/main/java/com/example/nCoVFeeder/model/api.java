package com.example.nCoVFeeder.model;

public enum api {
    CORONOVIRUS_PROGRESS("http://api.tianapi.com/txapi/ncovcity/index?key=54a8d925c25e919a7a7837128651971a"),
    CORONOVIRUSRUMOR("http://api.tianapi.com/txapi/rumour/index?key=54a8d925c25e919a7a7837128651971a");

    private String url;

    api(String url){
        this.url = url;
    }

    public String url(){
        return url;
    }
}
