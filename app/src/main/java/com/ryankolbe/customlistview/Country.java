package com.ryankolbe.customlistview;

public class Country {

    private int imageDrawable;
    private String countryName;

    public Country(int imageDrawable, String countryName) {
        this.imageDrawable = imageDrawable;
        this.countryName = countryName;
    }

    public int getImageDrawable() {
        return imageDrawable;
    }

    public String getCountryName() {
        return countryName;
    }
}