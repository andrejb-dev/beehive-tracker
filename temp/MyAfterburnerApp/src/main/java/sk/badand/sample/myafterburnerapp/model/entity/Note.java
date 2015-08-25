/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.badand.sample.myafterburnerapp.model.entity;

import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author abadinka <andrej.badinka@interway.sk>
 */
public class Note {
    
    private StringProperty title;
    private StringProperty content;
    private ObjectProperty<LocalDate> created;

    public Note() {
        this.title = new SimpleStringProperty();
        this.content = new SimpleStringProperty();
        this.created = new SimpleObjectProperty<>(LocalDate.now());
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

    public ObjectProperty<LocalDate> createdProperty() {
        return created;
    }
}
