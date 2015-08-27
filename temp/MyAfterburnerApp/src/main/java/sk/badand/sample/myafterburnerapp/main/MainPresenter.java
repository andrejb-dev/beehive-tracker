/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.badand.sample.myafterburnerapp.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import sk.badand.sample.myafterburnerapp.main.note.NotePresenter;
import sk.badand.sample.myafterburnerapp.main.note.NoteView;
import sk.badand.sample.myafterburnerapp.main.notelist.NotelistPresenter;
import sk.badand.sample.myafterburnerapp.main.notelist.NotelistView;
import sk.badand.sample.myafterburnerapp.model.entity.Note;

/**
 *
 * @author abadinka
 */
public class MainPresenter implements Initializable {

    @FXML
    Pane notelist;
    @FXML
    Pane note;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NoteView noteView = new NoteView();
        NotelistView notelistView = new NotelistView();

        layout(notelistView, noteView);
        initBinding(notelistView, noteView);

        notelist.getChildren().add(notelistView.getView());
        note.getChildren().add(noteView.getView());
    }

    private void layout(NotelistView notelistView, NoteView noteView) {
        AnchorPane.setTopAnchor(noteView.getView(), 0.0);
        AnchorPane.setTopAnchor(notelistView.getView(), 0.0);
        AnchorPane.setBottomAnchor(noteView.getView(), 0.0);
        AnchorPane.setBottomAnchor(notelistView.getView(), 0.0);
        AnchorPane.setLeftAnchor(noteView.getView(), 0.0);
        AnchorPane.setLeftAnchor(notelistView.getView(), 0.0);
        AnchorPane.setRightAnchor(noteView.getView(), 0.0);
        AnchorPane.setRightAnchor(notelistView.getView(), 0.0);
    }

    private void initBinding(NotelistView notelistView, NoteView noteView) {
        NotePresenter notePresenter = (NotePresenter) noteView.getPresenter();
        NotelistPresenter notelistPresenter = (NotelistPresenter) notelistView.getPresenter();

        notelistPresenter.getSelectedNote().addListener((a, b, c) -> {
            notePresenter.getEditedNote().setValue(c);
        });
//        notelistPresenter.getNoteTable().getSelectionModel().selectedItemProperty().addListener((a,b,c) -> {
//            notePresenter.getEditedNote().setValue(c);
//        });
    }

}
