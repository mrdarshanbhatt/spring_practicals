package com.luxstech.controller;


import com.luxstech.dto.FavouriteCountryDto;
import com.luxstech.dto.ResponseDto;
import com.luxstech.services.FavouriteCountryService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/favouriteCountry")
@Api(tags = {"FavouriteCountry"}, description = "This API Group is Used for CRUD Operation on your Favourite Country...")
public class FavouriteCountryController {

    @Autowired
    private FavouriteCountryService favouriteCountryService;

    // Display home Page all Functionality are show
    @ApiOperation(nickname = "Add Favourite Country", notes = "API used for Add the Favourite Country", value = "/add")
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
    @PostMapping(value = "/add")
    public ResponseDto addFavouriteCountry(@RequestBody FavouriteCountryDto favouriteCountryDto) {
        return favouriteCountryService.addCountry(favouriteCountryDto);
    }

    @ApiOperation(nickname = "Update Favourite Country", notes = "API used for Update the Favourite Country", value = "/update")
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
    @PutMapping(value = "/update")
    public ResponseDto updateFavouriteCountry(@RequestBody FavouriteCountryDto favouriteCountryDto) {
        return favouriteCountryService.updateCountry(favouriteCountryDto);
    }

    @ApiOperation(nickname = "Fetch Favourite Country", notes = "API used for Fetch the Favourite Country", value = "/get")
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
    @GetMapping(value = "/get")
    public ResponseDto getFavouriteCountry(@RequestParam String countryCode) {
        return favouriteCountryService.getCountry(countryCode);
    }


    @ApiOperation(nickname = "Delete Favourite Country", notes = "API used for Delete the Favourite Country", value = "/delete")
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
    @DeleteMapping(value = "/delete")
    public ResponseDto deleteFavouriteCountry(@RequestParam String countryCode) {
        return favouriteCountryService.deleteCountry(countryCode);
    }


    @ApiOperation(nickname = "Get All Favourite Country", notes = "API used for Get ALL the Favourite Country", value = "/getAllFavouriteCountry")
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
    @GetMapping(value = "/getAllFavouriteCountry")
    public ResponseDto getAllCountry() {
        return favouriteCountryService.getAllCountry();
    }
}
