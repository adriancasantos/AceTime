package com.adriancasantos.acetime.data.model;

public class Torneo {

    private int id;
    private String name;
    private String city;
    private String country;
    private String surface;
    private String code;
    private String start_date;
    private String end_date;
    private int season;
    private String country_code;

    public Torneo(int id, String name, String city, String country, String surface, String code,
            String start_date, String end_date, int season, String country_code) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.surface = surface;
        this.code = code;
        this.start_date = start_date;
        this.end_date = end_date;
        this.season = season;
        this.country_code = country_code;
    }

    // Getters and setters for all attributes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }
}
