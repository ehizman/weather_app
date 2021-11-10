package com.ehizman.weather_app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Weather implements Serializable {
    private Integer id;

    @JsonProperty("weather_state_name")
    private String weatherStateName;

    @JsonProperty("weather_state_abbr")
    private String weatherStateAbbr;

    @JsonProperty("wind_direction_compass")
    private String windDirectionCompass;

    @JsonProperty("created")
    private LocalDateTime createdAt;

    @JsonProperty("applicable_date")
    private LocalDate applicableDate;

    @JsonProperty("min_temp")
    private Double minTemp;

    @JsonProperty("max_temp")
    private Double maxTemp;

    @JsonProperty("the_temp")
    private Double theTemp;

    @JsonProperty("wind_speed")
    private Double windSpeed;

    @JsonProperty("wind_direction")
    private Double windDirection;

    @JsonProperty("air_pressure")
    private Double airPressure;

    @JsonProperty("humidity")
    private Integer humidity;

    @JsonProperty("visibility")
    private Double visibility;

    @JsonProperty("predictability")
    private Integer predictability;

}
