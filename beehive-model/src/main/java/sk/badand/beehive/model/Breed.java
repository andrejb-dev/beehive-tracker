/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.badand.beehive.model;

import java.io.Serializable;
import sk.badand.text.RandomStringGenerator;

/**
 *
 * @author abadinka
 */
public final class Breed implements Serializable{
    private final String name;

    public Breed(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " - " + this.name;
    }

    public String getName() {
        return name;
    }
    
    public Breed getMock() {
        return new Breed(new RandomStringGenerator().generateDesignation(8));
    }
    
}
