package spring_mvc_demo.models;

import java.util.LinkedHashMap;

public class Student {
    // properties
    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLanguage;

    // country options to choose from
    // ordered hashmap
    private LinkedHashMap<String, String> countryOptions;

    // constructor
    public Student() {
        this.countryOptions = new LinkedHashMap<>();
        countryOptions.put("US", "United States");
        countryOptions.put("AF", "Africa");
        countryOptions.put("BR", "Brazil");
        countryOptions.put("CA", "Canada");
    }

    // getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
        this.countryOptions = countryOptions;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }
}
