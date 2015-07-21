/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.badand.beehive.model;

import java.io.Serializable;
import java.util.HashMap;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import sk.badand.beehive.model.enums.SunExposure;
import sk.badand.math.Randomizer;
import sk.badand.text.RandomStringGenerator;

/**
 *
 * @author abadinka
 */
public final class Yard implements Serializable {

    private final StringProperty name = new SimpleStringProperty(new RandomStringGenerator().generateDesignation(5));
    private final SimpleMapProperty<String, Hive> hives;
    private final ObjectProperty<Address> address;
    private final ObjectProperty<SunExposure> sunExposure;
    private final ObjectProperty<Environment> environment;
    
    public Yard(HashMap<String, Hive> hives, Address address, SunExposure sunExposure) {
        this(hives, address, sunExposure, null);
    }

    public Yard(HashMap<String, Hive> hives, Address address, SunExposure sunExposure, Environment environment) {
        this.hives = new SimpleMapProperty<>(FXCollections.observableMap(hives));
        this.address = new SimpleObjectProperty<>(address);
        this.sunExposure = new SimpleObjectProperty<>(sunExposure);
        this.environment = new SimpleObjectProperty<>(environment);
    }

    public static Yard getMockYard() {
        HashMap<String, Hive> hiveList = new HashMap<>();
        final int hiveCount = Randomizer.nextRandomInt(5);
        for (int i = 0; i < hiveCount; i++) {
            hiveList.put("hive_" + i, Hive.getMockHive());            
        }
        return new Yard(hiveList, Address.getMockAddress(), SunExposure.SUNNY, new Environment());
    }

    public StringProperty nameProperty() {
        return name;
    }
    public SimpleMapProperty<String, Hive> hivesProperty() {
        return hives;
    }
    public ObjectProperty<Address> addressProperty() {
        return address;
    }
    public ObjectProperty<SunExposure> sunExposureProperty() {
        return sunExposure;
    }
    public ObjectProperty<Environment> environmentProperty() {
        return environment;
    }
}
