/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.badand.sample.myafterburnerapp.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import sk.badand.sample.myafterburnerapp.main.note.NoteView;
import sk.badand.sample.myafterburnerapp.main.notelist.NotelistView;

/**
 *
 * @author abadinka <andrej.badinka@interway.sk>
 */
public class MainPresenter implements Initializable {

    @FXML
    Pane notelist;
    @FXML
    Pane note;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NoteView noteView = new NoteView();
        note.getChildren().add(noteView.getView());
        
        NotelistView notelistView = new NotelistView();
        notelist.getChildren().add(notelistView.getView());
    }
    
}
