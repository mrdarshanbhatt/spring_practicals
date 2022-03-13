package com.luxstexh.conterllertest;

import com.luxstech.controller.FavouriteCountryController;
import com.luxstech.dto.CurrencyDto;
import com.luxstech.dto.FavouriteCountryDto;
import com.luxstech.dto.ResponseDto;
import com.luxstech.repository.CountryRepository;
import com.luxstech.repository.CurrencyRepository;
import com.luxstech.services.FavouriteCountryService;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class FavouriteCountryControllerTest {

    ResponseDto successResponseDto = new ResponseDto();

    ResponseDto failResponseDto = new ResponseDto();

    ResponseDto result = new ResponseDto();

    FavouriteCountryDto favouriteCountryDto = new FavouriteCountryDto();

    @InjectMocks
    private FavouriteCountryController favouriteCountryController;

    @Mock
    private FavouriteCountryService favouriteCountryService;

    @Mock
    private CurrencyRepository currencyRepository;

    @Mock
    private CountryRepository countryRepository;

    @Before
    public void init() {

        MockitoAnnotations.initMocks(this);

        // Favouriate Country DTO
        favouriteCountryDto.setCountryCode("IND");
        favouriteCountryDto.setCountryName("India");
        favouriteCountryDto.setCountryRegion("Asia");
        favouriteCountryDto.setCuntryCapital("New Delhi");

        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setDefaultCurrencyCode("R");
        currencyDto.setDefaultCurrencyName("Rupee");
        currencyDto.setDefaultCurrencySymbol("RU");
        currencyDto.setDefaultLanguageName("Hindi");

        // Currency DTO
        favouriteCountryDto.setCurrencyDto(currencyDto);

        successResponseDto.setStatus(true);
        successResponseDto.setMessage("");
        successResponseDto.setData(new ArrayList<>());
        successResponseDto.setCode(200);

        failResponseDto.setStatus(false);
        failResponseDto.setMessage("Error");
        failResponseDto.setData(new ArrayList<>());
        failResponseDto.setCode(500);
    }

    // Add Country Success
    @Test
    public void addCountrySuccess() {
        Mockito.when(favouriteCountryService.addCountry(favouriteCountryDto)).thenReturn(successResponseDto);
        result = favouriteCountryController.addFavouriteCountry(favouriteCountryDto);
        Assert.assertEquals(successResponseDto.getCode(), result.getCode());
    }

   /* @Test
    public void addCountryFail() {
        Mockito.when(favouriteCountryService.addCountry(new FavouriteCountryDto())).thenReturn(failResponseDto);
        result = favouriteCountryController.addFavouriteCountry(new FavouriteCountryDto());
        Assert.assertEquals(failResponseDto.getCode(), result.getCode());
    }*/

    @Test
    public void updateCountrySuccess() {
        Mockito.when(favouriteCountryService.updateCountry(favouriteCountryDto)).thenReturn(successResponseDto);
        result = favouriteCountryController.updateFavouriteCountry(favouriteCountryDto);
        Assert.assertEquals(HttpStatus.SC_OK, result.getCode());
    }

    @Test
    public void deleteCountrySuccess() {
        Mockito.when(favouriteCountryService.deleteCountry("IND")).thenReturn(successResponseDto);
        result = favouriteCountryController.deleteFavouriteCountry("IND");
        Assert.assertEquals(HttpStatus.SC_OK, result.getCode());
    }

    @Test
    public void getCountry() {
        Mockito.when(favouriteCountryService.getCountry("IND")).thenReturn(successResponseDto);
        result = favouriteCountryController.getFavouriteCountry("IND");
        Assert.assertEquals(HttpStatus.SC_OK, result.getCode());
    }

}
