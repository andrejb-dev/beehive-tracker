/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.beehive.modelfx;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.SortedMap;
import java.util.TreeMap;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sk.badand.beehive.model.Harvest;
import sk.badand.beehive.model.Hive;
import sk.badand.beehive.model.Inspection;
import sk.badand.beehive.model.Queen;
import sk.badand.beehive.model.State;
import sk.badand.beehive.model.enums.Strength;

/**
 *
 * @author abadinka
 */
public class HiveFx extends CommonEntity {

    private Hive origin;

    private final StringProperty name = new SimpleStringProperty();
    private final ObjectProperty<State> state = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> created = new SimpleObjectProperty<>();
    private final ObjectProperty<Strength> strength = new SimpleObjectProperty<>();
    private final StringProperty notes = new SimpleStringProperty();
    private final ObjectProperty<Queen> queen = new SimpleObjectProperty<>();
    private final SortedMap<LocalDateTime, Inspection> inspections = new TreeMap<>();
    private final SortedMap<LocalDateTime, Harvest> harvests = new TreeMap<>();
    private final ObjectProperty<TodoFx> todo = new SimpleObjectProperty<>();

    public HiveFx(Hive origin) {
        this.origin = origin;
        this.name.setValue(origin.getName());
        this.state.setValue(origin.getState());
    }

    public Hive saveHive() {
        origin = new Hive(name.getValue(), state.getValue(), strength.getValue(), notes.getValue(), queen.getValue());
        return origin;
    }

    @Override
    public StringProperty nameProperty() {
        return name;
    }

    public ObjectProperty<State> stateProperty() {
        return state;
    }

    public ObjectProperty<LocalDate> createdProperty() {
        return created;
    }

    public ObjectProperty<Strength> strengthProperty() {
        return strength;
    }

    public StringProperty notesProperty() {
        return notes;
    }

    public ObjectProperty<Queen> queenProperty() {
        return queen;
    }

    public ObjectProperty<TodoFx> todoProperty() {
        return todo;
    }

    @Override
    public EntityType type() {
        return EntityType.HIVE;
    }
}
