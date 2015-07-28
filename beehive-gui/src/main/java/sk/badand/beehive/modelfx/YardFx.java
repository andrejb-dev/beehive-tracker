/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.beehive.modelfx;

import javafx.beans.property.ListProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sk.badand.beehive.model.Yard;
import sk.badand.beehive.model.enums.SunExposure;

/**
 *
 * @author abadinka
 */
public class YardFx {
    private Yard origin;
    
    private ObjectProperty<AddressFx> address = new SimpleObjectProperty<>();
    private ObjectProperty<EnvironmentFx> environment = new SimpleObjectProperty<>();
    private ListProperty<HiveFx> hives = new SimpleListProperty<>();
    private ObjectProperty<SunExposure> sunExposure = new SimpleObjectProperty<>();
    private StringProperty name = new SimpleStringProperty();

    public YardFx(Yard origin) {
        this.origin = origin;
        address.setValue(new AddressFx(origin.getAddress()));
        environment.setValue(new EnvironmentFx(origin.getEnvironment()));
        sunExposure.setValue(origin.getSunExposure());
//        hives = new SimpleListProperty<>
        name.setValue(origin.getName());
    }
    
    
}
