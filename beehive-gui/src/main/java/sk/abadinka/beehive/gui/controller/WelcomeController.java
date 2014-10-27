/*
 * Copyright 2014 Andrej Badinka
 */
package sk.abadinka.beehive.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class WelcomeController implements Initializable, ScreenControllerInjectable {
    
    private ScreensController screenController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setScreenController(ScreensController screenController) {
        this.screenController = screenController;
    }
    
}
