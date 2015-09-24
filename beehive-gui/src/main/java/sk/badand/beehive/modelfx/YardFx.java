/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.beehive.modelfx;

import java.util.Map;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import sk.badand.beehive.model.Hive;
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
    private ListProperty<HiveFx> hives = new SimpleListProperty<>(FXCollections.observableArrayList());
    private ListProperty<NoteFx> notes = new SimpleListProperty<>(FXCollections.observableArrayList());
    private ObjectProperty<SunExposure> sunExposure = new SimpleObjectProperty<>();
    private StringProperty name = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();

    public YardFx(Yard origin) {
        this.origin = origin;
        address.setValue(new AddressFx(origin.getAddress()));
        environment.setValue(new EnvironmentFx(origin.getEnvironment()));
        sunExposure.setValue(origin.getSunExposure());
        for (Map.Entry<String, Hive> hive : origin.getHives().entrySet()) {
            hives.add(new HiveFx(hive.getValue()));
        }
        notes.add(new NoteFx());
        name.setValue(origin.getName());
        description.setValue(origin.getName() + " descripion");
    }

    public ObjectProperty<AddressFx> addressProperty() {
        return address;
    }

    public ListProperty<HiveFx> hivesProperty() {
        return hives;
    }

    public ReadOnlyObjectWrapper hivesCount() {
        return new ReadOnlyObjectWrapper(hives.size());
    }

    public StringProperty nameProperty() {
        return name;
    }

    public ObjectProperty<EnvironmentFx> environmentProperty() {
        return environment;
    }

    public ObjectProperty<SunExposure> sunExposureProperty() {
        return sunExposure;
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public ListProperty<NoteFx> notesProperty() {
        return notes;
    }
}
