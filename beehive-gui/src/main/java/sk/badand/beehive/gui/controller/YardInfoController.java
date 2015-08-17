/*
 * Copyright 2015 Andrej Badinka
 */
package sk.badand.beehive.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import sk.badand.beehive.modelfx.YardFx;
import sk.badand.beehive.services.YardService;

/**
 * FXML Controller class
 *
 * @author zavael
 */
public class YardInfoController implements Initializable, ScreenControllerInjectable {
    private ScreensController screensController;
    private YardFx yardFx;
    
    @FXML
    private Label yardName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        yardFx = YardService.getInstance().getYardForOverview();
        if (yardFx != null) {
            yardName.setText(yardFx.nameProperty().getValue());
        }
    }    

    @Override
    public void setScreenController(ScreensController screenController) {
        this.screensController = screenController;
    }
    
}
