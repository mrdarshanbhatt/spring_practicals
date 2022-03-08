package com.luxstech.dto;

public class CurrencyDto {

    private String defaultCurrencyCode;
    private String defaultCurrencyName;
    private String defaultCurrencySymbol;
    private String defaultLanguageName;

    public void setDefaultCurrencyCode(String defaultCurrencyCode) {
        this.defaultCurrencyCode = defaultCurrencyCode;
    }

    public String getDefaultCurrencyCode() {
        return defaultCurrencyCode;
    }

    public void setDefaultCurrencyName(String defaultCurrencyName) {
        this.defaultCurrencyName = defaultCurrencyName;
    }

    public String getDefaultCurrencyName() {
        return defaultCurrencyName;
    }

    public void setDefaultCurrencySymbol(String defaultCurrencySymbol) {
        this.defaultCurrencySymbol = defaultCurrencySymbol;
    }

    public String getDefaultCurrencySymbol() {
        return defaultCurrencySymbol;
    }

    public void setDefaultLanguageName(String defaultLanguageName) {
        this.defaultLanguageName = defaultLanguageName;
    }

    public String getDefaultLanguageName() {
        return defaultLanguageName;
    }
}
