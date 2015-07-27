/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.beehive.modelfx;

/**
 *
 * @author abadinka
 */
public class HiveFx {
	private Hive origin;

	private final StringProperty name = new SimpleStringProperty();
    private final ObjectProperty<State> state = new SimpleObjectProperty<>();
    private final ObjectProperty<Date> created = new SimpleObjectProperty<>();
    private final ObjectProperty<Strength> strength = new SimpleObjectProperty<>();
    private final StringProperty notes = new SimpleStringProperty();
    private final ObjectProperty<Queen> queen = new SimpleObjectProperty<>();
    private final SortedMap<Date, Inspection> inspections = new TreeMap<>();
    private final SortedMap<Date, Harvest> harvests = new TreeMap<>();
    private final ObjectProperty<Todo> todo = Todo.EMPTY;
    
    public HiveFx(Hive origin){
    	this.origin = origin;
    }
}
