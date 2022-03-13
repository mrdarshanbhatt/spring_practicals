package com.luxstech.services;

import com.luxstech.dto.CurrencyDto;
import com.luxstech.dto.FavouriteCountryDto;
import com.luxstech.dto.ResponseDto;
import com.luxstech.entity.Country;
import com.luxstech.entity.Currency;
import com.luxstech.repository.CountryRepository;
import com.luxstech.repository.CurrencyRepository;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class FavouriteCountryService {

    private static final Logger LOGGER = Logger.getLogger(FavouriteCountryService.class.getName());

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    // Add Favouriate Country
    public ResponseDto addCountry(FavouriteCountryDto favouriteCountryDto) {
        try {
            if (countryRepository.existsByCountryCode(favouriteCountryDto.getCountryCode())) {
                return new ResponseDto(HttpStatus.SC_BAD_REQUEST, false, "Country Already Exists");
            }
            if (currencyRepository.existsByCode(favouriteCountryDto.getCurrencyDto().getDefaultCurrencyCode())) {
                return new ResponseDto(HttpStatus.SC_BAD_REQUEST, false, "You entered currency is already assign to other country");
            }
            LOGGER.log(Level.INFO, "Application is try to add your country...");
            persistCountryData(favouriteCountryDto, true);
            LOGGER.log(Level.INFO, "Country Added ...");

            CurrencyDto currencyDto = favouriteCountryDto.getCurrencyDto();
            persisteCurrencyData(currencyDto, favouriteCountryDto.getCountryCode(), true);
            LOGGER.log(Level.INFO, "Currency Added...");

            return new ResponseDto(HttpStatus.SC_OK, true, "Your Country added Successfully...", favouriteCountryDto);
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Unknown error Occurred during create the Your Country");
            return new ResponseDto(HttpStatus.SC_INTERNAL_SERVER_ERROR, false, "Internal Server Error");
        }
    }


    public ResponseDto updateCountry(FavouriteCountryDto favouriteCountryDto) {
        try {
            LOGGER.log(Level.INFO, "Application is try to Update your country...");
            boolean status = persistCountryData(favouriteCountryDto, false);
            if (!status) {
                return new ResponseDto(HttpStatus.SC_BAD_REQUEST, false, "Country Not found for Country Code: " + favouriteCountryDto.getCountryCode());
            }
            LOGGER.log(Level.INFO, "Country Updated ...");

            CurrencyDto currencyDto = favouriteCountryDto.getCurrencyDto();
            persisteCurrencyData(currencyDto, favouriteCountryDto.getCountryCode(), false);
            LOGGER.log(Level.INFO, "Currency Updated...");
            return new ResponseDto(HttpStatus.SC_OK, true, "Currency Data updated successfully...");
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Unknown error Occurred during update Your Country currency");
        }
        return new ResponseDto();
    }

    // Below method used for Create and Update the Data
    // True = Create Record
    // False = Update Record
    private boolean persistCountryData(FavouriteCountryDto favouriteCountryDto, boolean operation) {
        Country country = null;
        if (operation) {
            country = new Country();
        } else {
            country = countryRepository.findByCountryCode(favouriteCountryDto.getCountryCode());
            if (country == null) {
                return false;
            }
        }
        country.setCountryCode(favouriteCountryDto.getCountryCode());
        country.setCountryName(favouriteCountryDto.getCountryName());
        country.setCountryRegion(favouriteCountryDto.getCountryRegion());
        countryRepository.save(country);
        return true;
    }

    // Below method used for Create and Update the Data
    // True = Create Record
    // False = Update Record
    private boolean persisteCurrencyData(CurrencyDto currency, String countryCode, boolean operation) {
        Currency currencyNew = null;
        if (operation) {
            currencyNew = new Currency();
        } else {
            currencyNew = currencyRepository.findByCode(currency.getDefaultCurrencyCode());
            if (currencyNew == null) {
                return false;
            }
        }

        currencyNew.setCode(currency.getDefaultCurrencyCode());
        currencyNew.setLanguageName(currency.getDefaultLanguageName());
        currencyNew.setName(currency.getDefaultCurrencyName());
        currencyNew.setSymbol(currency.getDefaultCurrencySymbol());

        // Currency is Relation with Country (One to One)
        currencyNew.setCountryCode(countryCode);
        currencyRepository.save(currencyNew);
        return true;
    }

    public ResponseDto deleteCountry(String countryCode) {
        try {
            if (countryCode != null && !countryCode.isEmpty() && countryRepository.findByCountryCode(countryCode) != null) {
                countryRepository.deleteByCountryCode(countryCode);
                currencyRepository.deleteByCountryCode(countryCode);
                return new ResponseDto(HttpStatus.SC_OK, true, "Your Country has been deleted...", countryCode);
            } else {
                return new ResponseDto(HttpStatus.SC_BAD_REQUEST, false, "Your Country Code: " + countryCode + "Not valid",
                        null);
            }
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Unknown error Occurred during Delete Your Country & currency");
        }
        return null;
    }

    public ResponseDto getCountry(String countryCode) {
        try {
            if (countryCode != null && !countryCode.isEmpty() && countryRepository.existsByCountryCode(countryCode)) {
                return new ResponseDto(HttpStatus.SC_OK, true, "Fethc the Country and Currency for Country Code: " + countryCode,
                        countryRepository.findByCountryCode(countryCode));
            } else {
                return new ResponseDto(HttpStatus.SC_BAD_REQUEST, false, "Your Country not found for country: " + countryCode,
                        null);
            }
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Unknown error Occurred during Fetch The Country & currency");
        }
        return new ResponseDto();
    }

    public ResponseDto getAllCountry() {
        try {
            return new ResponseDto(HttpStatus.SC_OK, true, "Fetch All Country and Currency", countryRepository.findAll());
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Unknown error Occurred during Fetch Country & currency");
        }
        return new ResponseDto();
    }
}
