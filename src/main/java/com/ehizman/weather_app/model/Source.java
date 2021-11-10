package com.ehizman.weather_app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Source implements Serializable {
    private String title;

    private String slug;

    private String url;

    @JsonProperty("crawl_rate")
    private Integer crawlRate;
}
