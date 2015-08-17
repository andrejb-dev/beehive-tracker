/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.badand.beehive.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sk.badand.beehive.gui.controller.enums.SCREEN;
import sk.badand.beehive.modelfx.YardFx;
import sk.badand.beehive.services.YardService;

/**
 * FXML Controller class
 *
 * @author abadinka <andrej.badinka@interway.sk>
 */
public class YardListController implements Initializable, ScreenControllerInjectable {
    private static final Logger LOG = Logger.getLogger(YardListController.class.getName());
    

    private ScreensController screensController;
    private YardService yardService = YardService.getInstance();

    @FXML
    private TableView<YardFx> yardsView;
    @FXML
    private TableColumn<YardFx, String> yardName;
    @FXML
    private TableColumn<YardFx, Integer> hivesCount;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        yardName.setCellValueFactory(data -> data.getValue().nameProperty());
        hivesCount.setCellValueFactory(data -> data.getValue().hivesCount());
        yardsView.setItems(yardService.getYards());
        yardsView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @Override
    public void setScreenController(ScreensController screenController) {
        this.screensController = screenController;
    }

    @FXML
    private void showYard(){
        LOG.log(Level.INFO, "entering");
        yardService.setYardForOverview(yardsView.getSelectionModel().getSelectedItem());
        screensController.setScreen(SCREEN.YardOverview);
    } 
}
