package com.luxstexh.conterllertest;

import com.luxstech.controller.CountiesController;
import com.luxstech.dto.ResponseDto;
import com.luxstech.services.CountryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class CountryControllerTest {

    ResponseDto successResponseDto = new ResponseDto();

    ResponseDto failResponseDto = new ResponseDto();

    ResponseDto result = new ResponseDto();

    @Mock
    private CountryService countryService;

    @InjectMocks
    private CountiesController countiesController;

    ArrayList<String> countries = new ArrayList<>();

    @Before
    public void init() {

        MockitoAnnotations.initMocks(this);

        successResponseDto.setStatus(true);
        successResponseDto.setMessage("");
        successResponseDto.setData(new ArrayList<>());
        successResponseDto.setCode(200);

        failResponseDto.setStatus(false);
        failResponseDto.setMessage("Error");
        failResponseDto.setData(new ArrayList<>());
        failResponseDto.setCode(500);

        countries.add("India");
        countries.add("USA");
    }

    @Test
    public void getAllCountry() {
        Mockito.when(countryService.fetchAllCountry()).thenReturn(countries);
        result = countiesController.getAllCountry();
        Assert.assertEquals(200,result.getCode());
        Mockito.verify(countryService, Mockito.times(1)).fetchAllCountry();
    }

    // Success
    @Test
    public void getCountriesByRegionSuccess(){
        Mockito.when(countryService.fetchCountryByRegion("ame")).thenReturn(countries);
        result = countiesController.getAllCountryByRegion("ame");
        Assert.assertEquals(successResponseDto.getCode(),result.getCode());
    }

    // Fail
    @Test
    public void getCountriesByRegionFail(){
        Mockito.when(countryService.fetchCountryByRegion("")).thenReturn(new ArrayList<>());
        result = countiesController.getAllCountryByRegion("");
        Assert.assertEquals(failResponseDto.getCode(),result.getCode());
    }

    @Test
    public void getCountryCountByRegionSuccess(){
        Mockito.when(countryService.fetchCountryByRegion("ame")).thenReturn(countries);
        result = countiesController.getCountryCountByRegion("ame");
        Assert.assertEquals(successResponseDto.getCode(),result.getCode());
    }

    @Test
    public void getCountryCountByRegionFail(){
        Mockito.when(countryService.fetchCountryByRegion("")).thenReturn(new ArrayList<>());
        result = countiesController.getCountryCountByRegion("");
        Assert.assertEquals(failResponseDto.getCode(),result.getCode());
    }

}
