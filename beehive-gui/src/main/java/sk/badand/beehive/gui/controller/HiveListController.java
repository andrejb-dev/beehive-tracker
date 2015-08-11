/*
 * Copyright 2015 Andrej Badinka
 */
package sk.badand.beehive.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sk.badand.beehive.gui.controller.enums.SCREEN;

/**
 * FXML Controller class
 *
 * @author zavael
 */
public class HiveListController implements Initializable, ScreenControllerInjectable {
    private ScreensController screensController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setScreenController(ScreensController screenController) {
        this.screensController = screenController;
    }
    
    @FXML
    private void showHive() {
        screensController.setScreen(SCREEN.HiveOverview);
    }
    
}
