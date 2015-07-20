/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.beehive.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import sk.badand.beehive.services.YardService;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class WelcomeController implements Initializable, ScreenControllerInjectable {
    
    private ScreensController screenController;
    @Autowired private YardService yardService;
    
    @FXML
    TableView yardsTable;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        yardsTable.setItems(yardService.getYards());
    }    

    @Override
    public void setScreenController(ScreensController screenController) {
        this.screenController = screenController;
    }
    
    @FXML
    public void closeApp(){
        Platform.exit();
    }
}
