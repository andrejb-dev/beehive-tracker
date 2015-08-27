/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.badand.sample.myafterburnerapp.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author abadinka
 */
public class Note {
    
    private StringProperty title;
    private StringProperty content;
    private ObjectProperty<LocalDateTime> created;

    public Note() {
        this.title = new SimpleStringProperty();
        this.content = new SimpleStringProperty();
        this.created = new SimpleObjectProperty<>(LocalDateTime.now());
        this.content.set("");
    }

    public Note(String title) {
        this();
        this.title.set(title);
    }

    public StringProperty titleProperty() {
        return this.title;
    }

    public StringProperty contentProperty() {
        return this.content;
    }

    public ObjectProperty<LocalDateTime> createdProperty() {
        return created;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Note)) {
            return false;
        }
        return this.title.getValue().equals(((Note)obj).titleProperty().getValue());
    }

    @Override
    public String toString() {
        return "[" + title.getValue() + "," + created.getValue() + "," + content.getValue() + "]";
    }
}
