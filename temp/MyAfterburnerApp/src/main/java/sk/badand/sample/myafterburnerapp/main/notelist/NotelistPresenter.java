/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.badand.sample.myafterburnerapp.main.notelist;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import sk.badand.sample.myafterburnerapp.model.entity.Note;

/**
 * FXML Controller class
 *
 * @author abadinka <andrej.badinka@interway.sk>
 */
public class NotelistPresenter implements Initializable {
    
    @FXML
    private TableView<Note> noteTable;
    
    private ObservableList<Note> notes;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.notes = FXCollections.observableArrayList();
        prepareTable();
    }    

    private void prepareTable() {
        noteTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        noteTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        noteTable.setItems(notes);
    }
    
}
