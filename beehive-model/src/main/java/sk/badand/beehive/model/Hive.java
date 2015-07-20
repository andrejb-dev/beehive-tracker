/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.badand.beehive.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;
import sk.badand.beehive.model.enums.Strength;

/**
 *
 * @author abadinka
 */
public class Hive implements Serializable {

    private final String name;
    private final State state;
    private final Date created;
    private final Strength strength;
    private final String notes;
    private final Queen queen;
    private final SortedMap<Date, Inspection> inspections = new TreeMap<>();
    private final SortedMap<Date, Harvest> harvests = new TreeMap<>();
    private final Todo todo = Todo.EMPTY;

    public Hive(String name, Strength strength, String notes) {
        this(name, State.ACTIVE, strength, notes, Queen.NO_QUEEN);
    }

    public Hive(String name, Strength strength, String notes, Queen queen) {
        this(name, State.ACTIVE, strength, notes, queen);
    }

    public Hive(String name, State state, Strength strength, String notes, Queen queen) {
        this.name = name;
        this.state = state;
        this.created = Calendar.getInstance().getTime();
        this.strength = strength;
        this.notes = notes;
        this.queen = queen;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    public Date getCreated() {
        return created;
    }

    public Strength getStrength() {
        return strength;
    }

    public String getNotes() {
        return notes;
    }

    public Queen getQueen() {
        return queen;
    }

    public SortedMap<Date, Inspection> getInspections() {
        return inspections;
    }

    public SortedMap<Date, Harvest> getHarvests() {
        return harvests;
    }

    public Todo getTodo() {
        return todo;
    }
}
