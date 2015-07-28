/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.beehive.modelfx;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.SortedMap;
import java.util.TreeMap;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sk.badand.beehive.model.Harvest;
import sk.badand.beehive.model.Hive;
import sk.badand.beehive.model.Inspection;
import sk.badand.beehive.model.Queen;
import sk.badand.beehive.model.State;
import sk.badand.beehive.model.Todo;
import sk.badand.beehive.model.enums.Strength;

/**
 *
 * @author abadinka
 */
public class HiveFx {

    private Hive origin;

    private final StringProperty name = new SimpleStringProperty();
    private final ObjectProperty<State> state = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> created = new SimpleObjectProperty<>();
    private final ObjectProperty<Strength> strength = new SimpleObjectProperty<>();
    private final StringProperty notes = new SimpleStringProperty();
    private final ObjectProperty<Queen> queen = new SimpleObjectProperty<>();
    private final SortedMap<LocalDateTime, Inspection> inspections = new TreeMap<>();
    private final SortedMap<LocalDateTime, Harvest> harvests = new TreeMap<>();
    private final ObjectProperty<Todo> todo = new SimpleObjectProperty<>(Todo.EMPTY);

    public HiveFx(Hive origin) {
        this.origin = origin;
    }
    
    public Hive saveHive(){
        origin = new Hive(name.getValue(), state.getValue(), strength.getValue(), notes.getValue(), queen.getValue());
        return origin;
    }

    /**
     * @return the name
     */
    public StringProperty getName() {
        return name;
    }

    /**
     * @return the state
     */
    public ObjectProperty<State> getState() {
        return state;
    }

    /**
     * @return the created
     */
    public ObjectProperty<LocalDate> getCreated() {
        return created;
    }

    /**
     * @return the strength
     */
    public ObjectProperty<Strength> getStrength() {
        return strength;
    }

    /**
     * @return the notes
     */
    public StringProperty getNotes() {
        return notes;
    }

    /**
     * @return the queen
     */
    public ObjectProperty<Queen> getQueen() {
        return queen;
    }

    /**
     * @return the inspections
     */
    public SortedMap<LocalDateTime, Inspection> getInspections() {
        return inspections;
    }

    /**
     * @return the harvests
     */
    public SortedMap<LocalDateTime, Harvest> getHarvests() {
        return harvests;
    }

    /**
     * @return the todo
     */
    public ObjectProperty<Todo> getTodo() {
        return todo;
    }
}
