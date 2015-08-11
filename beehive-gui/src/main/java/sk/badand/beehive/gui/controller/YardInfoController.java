/*
 * Copyright 2015 Andrej Badinka
 */
package sk.badand.beehive.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author zavael
 */
public class YardInfoController implements Initializable, ScreenControllerInjectable {
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
    
}
