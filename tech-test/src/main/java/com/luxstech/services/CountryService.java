package com.luxstech.services;

import com.luxstech.entity.Country;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


@Service
public class CountryService {

    public static final Logger LOGGER = Logger.getLogger(CountryService.class.getName());

    @Value(value = "${restcountry-thirdparty-service}")
    private String serviceUrl;

    // Fetch All Country
    public List<String> fetchAllCountry() {
        try {
            LOGGER.log(Level.INFO, "Application fetch the country list...");
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(serviceUrl + "/v3.1/all");
            HttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String JSON = EntityUtils.toString(entity);
            JSONArray countryList = (JSONArray) new JSONParser().parse(JSON);
            return parser(countryList);
        } catch (Exception e) {
            LOGGER.log(Level.INFO, "Un- Excepted error for fetching the all country");
        }
        return new ArrayList<>();
    }

    private List<String> parser(JSONArray countryList) {
        List<String> countries = new ArrayList<>();
        for (int i = 0; i < countryList.size(); i++) {
            Map<String, Object> countryDto = new HashMap<>();
            JSONObject country = (JSONObject) countryList.get(i);
            countries.add(((JSONObject) country.get(UtilityService.NAME)).get(UtilityService.COMMON).toString());
        }
        return countries;
    }

    // Fetch Country based on Region name...
    public List<String> fetchCountryByRegion(String regionName) {
        try {
            LOGGER.log(Level.INFO, "Application fetch the country list based on region...");
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(serviceUrl + "/v3.1/region/" + regionName);
            HttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String JSON = EntityUtils.toString(entity);
            JSONArray countryListByRegion = (JSONArray) new JSONParser().parse(JSON);
            return parser(countryListByRegion);
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Un- Excepted error for fetching the region based country");
        }
        return new ArrayList<>();
    }
}