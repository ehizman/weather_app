package com.ehizman.weather_app.web.controller;

import com.ehizman.weather_app.model.LocationDetails;
import com.ehizman.weather_app.model.WeatherAndCityDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@RestController
@RequestMapping("weather_app/v1")
public class WebAppController {
    @GetMapping(value = "/{city}")
    private ResponseEntity<LocationDetails> getWeatherForCity(@PathVariable("city") String city) {
        WebClient client = WebClient.create();
        WebClient.ResponseSpec responseSpec = client.get().uri("https://www.metaweather.com/api/location/search/?query=" + city).retrieve();
        LocationDetails cityDetails = responseSpec.bodyToFlux(LocationDetails.class).blockFirst();

        if (cityDetails != null) {
            Integer woeid = cityDetails.getWoeid();
            System.out.println(woeid);
            log.info("woeid --> {}", woeid);
            getConsolidatedWeatherForCity(woeid);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "weather/{woeid}", consumes = "application/json")
    public ResponseEntity<WeatherAndCityDetails> getConsolidatedWeatherForCity(@PathVariable("woeid") Integer woeid) {
        WebClient client = WebClient.builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        WebClient.ResponseSpec responseSpec = client.get().uri("https://www.metaweather.com/api/location/" + woeid+"/").retrieve();
        log.info("response spec --> {}", responseSpec);
         WeatherAndCityDetails weatherAndLocationDetails = responseSpec.bodyToMono(WeatherAndCityDetails.class).block();
        log.info("response --> {}", weatherAndLocationDetails);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
