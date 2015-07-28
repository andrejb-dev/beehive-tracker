/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.beehive.modelfx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sk.badand.beehive.model.Address;

/**
 *
 * @author abadinka
 */
public class AddressFx {
    private Address origin;
    
    private StringProperty formated = new SimpleStringProperty();
    private StringProperty city = new SimpleStringProperty();
    private StringProperty street = new SimpleStringProperty();
    private StringProperty country = new SimpleStringProperty();
    private StringProperty gpsLocation = new SimpleStringProperty();

    private AddressFx() {
    }

    public AddressFx(Address origin) {
        this.origin = origin;
        this.formated.setValue(origin.formated());
        this.city.setValue(origin.getCity());
        this.street.setValue(origin.getStreet());
        this.country.setValue(origin.getCountry());
        this.gpsLocation.setValue(origin.getGpsLocation());
    }
    
    public Address saveAddress(){
        this.origin = new Address(country.getValue(), city.getValue(), street.getValue(), gpsLocation.getValue());
        return origin;
    }
}
