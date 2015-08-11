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
public class YardOverviewController implements Initializable, ScreenControllerInjectable {
    private ScreensController screensController;
    
    @FXML
    private MenuController menuController;
    @FXML
    private YardInfoController yardInfoController;
    @FXML
    private HiveListController hiveListController;

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
        menuController.setScreenController(screenController);
        hiveListController.setScreenController(screenController);
        yardInfoController.setScreenController(screenController);
    }
    
    @FXML
    private void showRoot() {
        screensController.setScreen(SCREEN.RootLayout);
    }
    
}
