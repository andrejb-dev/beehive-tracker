/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.badand.sample.myafterburnerapp.main.notelist;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javax.inject.Inject;
import sk.badand.sample.myafterburnerapp.model.entity.Note;
import sk.badand.sample.myafterburnerapp.model.entity.NoteService;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class NotelistPresenter implements Initializable {
    private static final Logger LOG = Logger.getLogger(NotelistPresenter.class.getName());
    
    @FXML
    private TableView<Note> noteTable;
    
    @Inject
    NoteService noteService;
    private ObjectProperty<Note> selectedNote;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.selectedNote = new SimpleObjectProperty<>();
        prepareTable();
    }    

    private void prepareTable() {
        noteTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);        
        noteTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        noteTable.getColumns().addAll(createTitleColumn(), createContentColumn(), createCreatedColumn());
        noteTable.setItems(noteService.getNotes());
        noteTable.getSelectionModel().selectedItemProperty().addListener((a,b,c) -> {
            selectedNote.setValue(c);
        });
    }

    public ObjectProperty<Note> getSelectedNote() {
        return selectedNote;
    }
    
    private TableColumn createTitleColumn() {
        TableColumn<Note, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(data -> data.getValue().titleProperty());
        return titleColumn;
    }   
    
    private TableColumn createContentColumn() {
        TableColumn<Note, String> contentColumn = new TableColumn<>("Content");
        contentColumn.setCellValueFactory(data -> data.getValue().contentProperty());
        return contentColumn;
    }  
    
    private TableColumn createCreatedColumn() {
        TableColumn<Note, LocalDateTime> createdColumn = new TableColumn<>("Created");
        createdColumn.setCellValueFactory(data -> data.getValue().createdProperty());
        return createdColumn;
    }
    
}
