/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.beehive.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sk.badand.beehive.model.Address;
import sk.badand.beehive.model.Yard;
import sk.badand.beehive.services.YardService;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class WelcomeController implements Initializable, ScreenControllerInjectable {
    private static final Logger LOG = Logger.getLogger(WelcomeController.class.getName());    
    
    private ScreensController screenController;
    private YardService yardService = YardService.getInstance();
    
    @FXML
    TableView yardsTable;
    @FXML
    private TableColumn<Yard, String> yardNameColumn;
    @FXML
    private TableColumn<Yard, Address> yardAddressColumn;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        yardNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        yardAddressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
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
    
    @FXML
    public void addNewYard(){
        LOG.log(Level.INFO, "yards: {0}", yardService.getYards());
        yardService.createYard(Yard.getMockYard());
    }
}
