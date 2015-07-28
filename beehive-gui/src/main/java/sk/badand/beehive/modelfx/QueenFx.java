/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.beehive.modelfx;

import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sk.badand.beehive.model.Breed;
import sk.badand.beehive.model.Queen;

/**
 *
 * @author abadinka
 */
public class QueenFx {
    private Queen origin;
    
    private ObjectProperty<Breed> breed =  new SimpleObjectProperty<>();
    private StringProperty age = new ReadOnlyStringWrapper();
    private ObjectProperty<LocalDate> installed = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> removed = new SimpleObjectProperty<>();
    private StringProperty name = new SimpleStringProperty();

    public QueenFx(Queen origin) {
        this.origin = origin;
        breed.setValue(origin.getBreed());
        age.setValue(origin.calculateAge());
        installed.setValue(origin.getInstalled());
        name.setValue(origin.getName());
        removed.setValue(origin.getRemoved());
    }

    /**
     * @return the breed
     */
    public ObjectProperty<Breed> getBreed() {
        return breed;
    }

    /**
     * @return the age
     */
    public StringProperty getAge() {
        return age;
    }

    /**
     * @return the installed
     */
    public ObjectProperty<LocalDate> getInstalled() {
        return installed;
    }

    /**
     * @return the removed
     */
    public ObjectProperty<LocalDate> getRemoved() {
        return removed;
    }

    /**
     * @return the name
     */
    public StringProperty getName() {
        return name;
    }
    
    
}
