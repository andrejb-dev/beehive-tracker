/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.badand.sample.myafterburnerapp.main.note;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javax.inject.Inject;
import sk.badand.sample.myafterburnerapp.model.entity.Note;
import sk.badand.sample.myafterburnerapp.model.entity.NoteService;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class NotePresenter implements Initializable {
    private static final Logger LOG = Logger.getLogger(NotePresenter.class.getName());

    @FXML
    TextArea content;
    @FXML
    Label createdDate;
    @FXML
    Label title;

    private ObjectProperty<Note> editedNote;
    
    @Inject
    private NoteService noteService;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.editedNote = new SimpleObjectProperty<>();

        this.editedNote.addListener(this::actualizeUI);
    }

    private void actualizeUI(ObservableValue<? extends Note> observable, Note oldValue, Note newValue) {
        if (newValue != null) {
            this.content.setText(newValue.contentProperty().getValue());
            this.createdDate.setText(newValue.createdProperty().getValue().format(DateTimeFormatter.ofPattern("d MMM yyyy hh:mm")));
            this.title.setText(newValue.titleProperty().getValue());
        } else {
            clearUI();
        }
    }

    private void clearUI() {
        this.content.setText("");
        this.createdDate.setText("");
        this.title.setText("");
    }
    
    @FXML
    private void newNote() {
        final Note note = new Note("new note");
        editedNote.set(note);
        noteService.add(note);
    }
    
    @FXML
    private void save() {
        LOG.log(Level.INFO, "save");
        Note note = editedNote.getValue();
        note.titleProperty().set(title.getText());
        note.contentProperty().set(content.getText());
        note.createdProperty().set(LocalDateTime.now());
        LOG.log(Level.INFO, "notes: {0}", noteService.getNotes().size());
        noteService.update(editedNote.getValue());
        LOG.log(Level.INFO, "notes: {0}", noteService.getNotes().size());
    }
    
    @FXML
    private void delete() {
        LOG.log(Level.INFO, "delete");
        noteService.remove(editedNote.getValue());
    }    

    public ObjectProperty<Note> getEditedNote() {
        return editedNote;
    }
}
