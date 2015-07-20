/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.badand.beehive.model;

/**
 *
 * @author abadinka
 */
public final class Address {

    private final String city;
    private final String street;
    private final String country;
    private final String gpsLocation;

    public Address(String country, String city) {
        this(country, city, null, null);
    }

    public Address(String country, String city, String street) {
        this(country, city, street, null);
    }

    public Address(String country, String city, String street, String gpsLocation) {
        this.city = city;
        this.street = street;
        this.country = country;
        this.gpsLocation = gpsLocation;
    }

    public String formated() {
        String formated
                = this.street
                + ", "
                + this.city
                + ", "
                + this.country;
        if (gpsLocation != null) {
            formated += ", "
                    + this.gpsLocation;
        }
        
        return formated;
    }
    
    public static Address getMockAddress(){
        return new Address("Slovakia", "Žiar", "Čečenská švrť", "48.155,17.22");
    }
}
