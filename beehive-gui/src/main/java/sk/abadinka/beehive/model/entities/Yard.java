/*
 * Copyright 2014 Andrej Badinka
 */
package sk.abadinka.beehive.model.entities;

/**
 *
 * @author abadinka
 */
public class Yard {
    private int id;
    private String name;

    public Yard() {
    }

    public Yard(int i, String first) {
        this.id = i;
        this.name = first;
        
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    
}
