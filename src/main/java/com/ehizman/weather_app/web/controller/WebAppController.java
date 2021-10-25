package com.ehizman.weather_app.web.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("weather_app/v1")
public class WebAppController {
    @GetMapping(value = "/{cityName}/")
    private String getWeatherForCity(@PathVariable("cityName") String city){
        WebClient client = WebClient.create("");
        WebClient.ResponseSpec responseSpec = client.get().uri("https://www.metaweather.com/api/location/search/?query="+city).retrieve();
        String responseBody = responseSpec.bodyToMono(String.class).block();
        System.out.println(responseBody);
        return responseBody;
    }
}
