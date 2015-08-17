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

    public Breed getBreed() {
        return breed.getValue();
    }

    public void setBreed(Breed breed) {
        this.breed.setValue(breed);
    }
    
    public ObjectProperty<Breed> breedProperty(){
        return breed;
    }

    public String getAge() {
        return age.getValueSafe(); //calculate from installed
    }

    public StringProperty ageProperty() {
        return age;
    }

    public LocalDate getInstalled() {
        return installed.getValue();
    }

    public ObjectProperty<LocalDate> installedProperty() {
        return installed;
    }

    public void setInstalled(LocalDate installed) {
        this.installed.setValue(installed);
    }

    public ObjectProperty<LocalDate> removedProperty() {
        return removed;
    }

    public LocalDate getRemoved() {
        return removed.getValue();
    }

    public void setRemoved(LocalDate removed) {
        this.removed.setValue(removed);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getName() {
        return name.getValueSafe();
    }

    public void setName(String name) {
        this.name.setValue(name);
    }
    
    
}
