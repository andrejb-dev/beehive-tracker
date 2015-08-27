/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.badand.sample.myafterburnerapp.model.entity;

import java.time.LocalDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author abadinka <andrej.badinka@interway.sk>
 */
public class NoteService {
    
    private static final ObservableList<Note> notes = FXCollections.observableArrayList();
    
    static {        
        for (int i = 0; i < 3; i++) {
            final Note testNote = new Note("test " + i);
            testNote.contentProperty().setValue("Content of note " + i);
            testNote.createdProperty().setValue(LocalDateTime.now());
            notes.add(testNote);
        }
    }

    public ObservableList<Note> getNotes() {
        return notes;
    }
    
    public void add(Note note) {
        notes.add(note);
    }
    
    public void remove(Note note) {
        notes.remove(note);
    }
    
    public void update(Note note) {
        if (notes.contains(note)) {
            notes.set(notes.indexOf(note), note);
        }
    }
    
}
