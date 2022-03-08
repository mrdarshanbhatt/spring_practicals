package com.luxstech.controller;

import com.luxstech.dto.ResponseDto;
import com.luxstech.services.CountryService;
import io.swagger.annotations.*;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"Country"}, description = "This API Group is Used for Fetch the Country list...")
@RestController
@RequestMapping(value = "/country")
public class CountiesController {

    @Autowired
    private CountryService countryService;

    @ApiOperation(nickname = "Get All Country", notes = "Get All Country from https://restcountries.com", value = "/all")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success | OK"),
            @ApiResponse(code = 404, message = "Resource Not Found"),
            @ApiResponse(code = 403, message = "Please login first..."),
            @ApiResponse(code = 400, message = "Bad Request...")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "admin",
                    required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "password", value = "admin",
                    required = true, dataType = "string", paramType = "header")})
    @GetMapping(value = "/all")
    public ResponseDto getAllCountry() {
        List<String> countryList = countryService.fetchAllCountry();
        if (!countryList.isEmpty()) {
            return new ResponseDto(HttpStatus.SC_OK, true, "fetched all country successfully", countryList);
        } else {
            return new ResponseDto(HttpStatus.SC_INTERNAL_SERVER_ERROR, false, "Country list not available in our system");
        }
    }


    @ApiOperation(nickname = "Get Country By Region", notes = "Get All Country from https://restcountries.com based on Region...", value = "/countryByRegion")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success | OK"),
            @ApiResponse(code = 404, message = "Resource Not Found"),
            @ApiResponse(code = 403, message = "Please login first..."),
            @ApiResponse(code = 400, message = "Bad Request...")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "admin",
                    required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "password", value = "admin",
                    required = true, dataType = "string", paramType = "header")})
    @PostMapping(value = "/countryByRegion")
    public ResponseDto getAllCountry(@RequestParam String regionName) {
        List<String> countryList = countryService.fetchCountryByRegion(regionName);
        if (!countryList.isEmpty()) {
            return new ResponseDto(HttpStatus.SC_OK, true, "Below listed country are belong from " + regionName, countryList);
        } else {
            return new ResponseDto(HttpStatus.SC_INTERNAL_SERVER_ERROR, false, "Country list not available for region: " + regionName);
        }
    }


    @ApiOperation(nickname = "Get Country Count By Region", notes = "Get Country Count by Region from https://restcountries.com based on Region...", value = "/countryCountByRegion")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success | OK"),
            @ApiResponse(code = 404, message = "Resource Not Found"),
            @ApiResponse(code = 403, message = "Please login first..."),
            @ApiResponse(code = 400, message = "Bad Request...")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "admin",
                    required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "password", value = "admin",
                    required = true, dataType = "string", paramType = "header")})
    @GetMapping(value = "/getCountryCountByRegion/{regionName}")
    public ResponseDto getCountryCountByRegion(@PathVariable String regionName) {
        List<String> countryList = countryService.fetchCountryByRegion(regionName);
        if (!countryList.isEmpty()) {
            return new ResponseDto(HttpStatus.SC_OK, true, "Country Count for Country Code: " + regionName, countryList.size());
        } else {
            return new ResponseDto(HttpStatus.SC_INTERNAL_SERVER_ERROR, false, "Country list not available for region: " + regionName);
        }
    }
}
