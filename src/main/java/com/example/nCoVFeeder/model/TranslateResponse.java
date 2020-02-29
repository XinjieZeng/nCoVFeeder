package com.example.nCoVFeeder.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class TranslateResponse {
    private List<Text> translations;

    public List<Text> getTranslations() {
        return translations;
    }

    public void setTranslations(List<Text> translations) {
        this.translations = translations;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Text {
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
