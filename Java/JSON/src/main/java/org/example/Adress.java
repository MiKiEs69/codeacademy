package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Adress {

    @JsonProperty("namųAdresas")
    private String homeAdress;
    private Country country;
    private String postCode;

    public Adress() {
    }

    public Adress(String homeAdress, Country country, String postCode) {
        this.homeAdress = homeAdress;
        this.country = country;
        this.postCode = postCode;
    }

    public void setHomeAdress(String homeAdress) {
        this.homeAdress = homeAdress;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getHomeAdress() {
        return homeAdress;
    }

    public Country getCountry() {
        return country;
    }

    public String getPostCode() {
        return postCode;
    }

    @Override
    public String toString() {
        return "{homeAdress='" + homeAdress + '\'' +
                ", country=" + country +
                ", postCode='" + postCode + '\'' +
                '}';
    }

    public enum Country {
        LIETUVA,
        LATVIJA,
        ESTIJA
    }
}
