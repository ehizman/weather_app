package com.ehizman.weather_app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class WeatherAndCityDetails implements Serializable {
    @JsonProperty("consolidated_weather")
    private List<Weather> consolidatedWeather;

    @JsonProperty("time")
    private LocalDateTime time;

    @JsonProperty("sun_rise")
    private LocalDateTime sunRise;

    @JsonProperty("sun_set")
    private LocalDateTime sunSet;

    @JsonProperty("timezone_name")
    private String timeZoneName;

    private LocationDetails parent;

    private List<Source> sources;

    private String title;

    @JsonProperty("locationType")
    private String location_type;

    private Integer woeid;

    //    @JsonProperty("latt_long")
    private String lattLong;

    //    @JsonProperty("timezone")
    private String timezone;
}
