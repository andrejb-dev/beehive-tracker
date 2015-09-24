/*
 * Copyright 2015 Andrej Badinka
 */
package sk.badand.beehive.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import sk.badand.beehive.gui.menu.MenuView;
import sk.badand.beehive.gui.yardlist.YardlistView;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class GuiPresenter implements Initializable {

    @FXML
    Pane menu;
    @FXML
    Pane content;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        content.getChildren().add((new YardlistView()).getView());
        menu.getChildren().add((new MenuView()).getView());
        ContentController.init(content);
    }
}
