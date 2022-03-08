package com.luxstech.dto;

// This Dto used for Same Structure Data from the FE side...
public class FavouriteCountryDto {

    private String countryCode;
    private String countryName;
    private String cuntryCapital;
    private String countryRegion;
    private CurrencyDto currencyDto;

    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }

    public String getCountryCode() { return countryCode; }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCuntryCapital(String cuntryCapital) {
        this.cuntryCapital = cuntryCapital;
    }

    public String getCuntryCapital() {
        return cuntryCapital;
    }

    public CurrencyDto getCurrencyDto() { return currencyDto; }

    public void setCurrencyDto(CurrencyDto currencyDto) {
        this.currencyDto = currencyDto;
    }
}
