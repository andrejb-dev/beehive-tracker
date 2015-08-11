/*
 * Copyright 2015 Andrej Badinka
 */
package sk.badand.beehive.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author zavael
 */
public class RootLayoutController implements Initializable, ScreenControllerInjectable{
    private ScreensController controller;
    
    @FXML
    private MenuController menuController;
    @FXML
    private YardListController yardListController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    @Override
    public void setScreenController(ScreensController screenController) {
        this.controller = screenController;
        menuController.setScreenController(screenController);
        yardListController.setScreenController(screenController);
    }
    
}
