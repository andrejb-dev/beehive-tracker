/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author abadinka <andrej.badinka@interway.sk>
 */
public class HiveOverviewController implements Initializable, ScreenControllerInjectable {
    private ScreensController screensController;
    
    @FXML
    private MenuController menuController;
    @FXML
    private HiveInfoController hiveInfoController;

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
        this.hiveInfoController.setScreenController(screenController);
    }
    
    @FXML
    private void showYard() {
        screensController.setScreen(SCREEN.YardOverview);
    }
    
}
