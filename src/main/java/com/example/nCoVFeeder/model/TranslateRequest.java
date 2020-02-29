package com.example.nCoVFeeder.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TranslateRequest {

    @JsonProperty("Text")
    private String text;

    @JsonProperty("Text")
    public String getText() {
        return text;
    }

    public TranslateRequest(String text){
        this.text = text;
    }

    @JsonProperty("Text")
    public void setText(String text) {
        this.text = text;
    }

}