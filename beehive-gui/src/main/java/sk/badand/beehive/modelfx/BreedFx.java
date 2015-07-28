/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.beehive.modelfx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sk.badand.beehive.model.Breed;

/**
 *
 * @author abadinka
 */
public class BreedFx {
    private Breed origin;

    private StringProperty name = new SimpleStringProperty();

    public BreedFx(Breed origin){
    	this.origin = origin;
    	this.name.setValue(origin.getName());
    }
    
    public Breed saveBreed(){
        origin = new Breed(getName().getValue());
        return origin;
    }

    /**
     * @return the name
     */
    public StringProperty getName() {
        return name;
    }
}
