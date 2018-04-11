package com.example.demo.networkproject.test;

/**
 * Created by akshaydashore on 11/4/18
 */

public class TemperatureData {

    private String location;

    private String celsius;

    private String url;

    public TemperatureData(String location, String celsius, String url) {
        this.location = location;
        this.celsius = celsius;
        this.url = url;
    }

    public String getCelsius() {
        return celsius;
    }

    public String getLocation() {
        return location;
    }

    public String getUrl() {
        return url;
    }


    public void setLocation(String location) {
        this.location = location;
    }

    public void setCelsius(String celsius) {
        this.celsius = celsius;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}