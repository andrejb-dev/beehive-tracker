/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.beehive.modelfx;

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
}
