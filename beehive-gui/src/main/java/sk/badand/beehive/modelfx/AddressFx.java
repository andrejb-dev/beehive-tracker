/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.beehive.modelfx;

import javafx.beans.property.StringProperty;
import sk.badand.beehive.model.Address;

/**
 *
 * @author abadinka
 */
public class AddressFx {
    private Address origin;
    
    private StringProperty city = new SimpleStringProperty();
    private StringProperty street;
    private StringProperty country;
    private StringProperty gpsLocation;

    private AddressFx() {
    }

    public AddressFx(Address origin) {
        this.origin = origin;
        city.setValue(origin.getCity());
        ...
    }
}
