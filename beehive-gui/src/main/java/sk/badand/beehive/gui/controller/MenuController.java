/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.badand.beehive.gui.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class MenuController implements Initializable, ScreenControllerInjectable {

    private static final Logger LOG = Logger.getLogger(MenuController.class.getName());

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

    /**
     * Creates an empty address book.
     */
    @FXML
    private void handleNew() {
        //TODO handleNew
//        mainApp.getPersonData().clear();
//        mainApp.setPersonFilePath(null);
    }

    /**
     * Opens a FileChooser to let the user select an address book to load.
     */
    @FXML
    private void handleOpen() {
        LOG.log(Level.INFO, "entering");
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showOpenDialog(screenController.getPrimaryStage());

        if (file != null) {
            //TODO load data
//            mainApp.loadPersonDataFromFile(file);
        }
    }

    /**
     * Saves the file to the person file that is currently open. If there is no open file, the "save as" dialog is shown.
     */
    @FXML
    private void handleSave() {
        LOG.log(Level.INFO, "entering");
//        File personFile = mainApp.getPersonFilePath();
//        if (personFile != null) {
//            mainApp.savePersonDataToFile(personFile);
//        } else {
//            handleSaveAs();
//        }
    }

    /**
     * Opens a FileChooser to let the user select a file to save to.
     */
    @FXML
    private void handleSaveAs() {
        LOG.log(Level.INFO, "entering");
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(screenController.getPrimaryStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            //TODO save file
//            mainApp.savePersonDataToFile(file);
        }
    }

    /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
        LOG.log(Level.INFO, "entering");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Beehive tracker");
        alert.setHeaderText("About");
        alert.setContentText("Author: Andrej Badinka\nWebsite: http://beehive-tracker.io");

        alert.showAndWait();
    }

    @FXML
    private void handleTips() {
        LOG.log(Level.INFO, "entering");
        FXMLLoader loader = new FXMLLoader();
        loader.setResources(ResourceBundle.getBundle("Bundle"));
        loader.setLocation(getClass().getResource("/fxml/parts/TipsModal.fxml"));

        Stage modalStage = new Stage(StageStyle.UTILITY);
        modalStage.initModality(Modality.WINDOW_MODAL);
        modalStage.initOwner(screenController.getPrimaryStage());
        try {
            Scene scene = new Scene((Parent) loader.load());
            scene.getStylesheets().add("/styles/LightTheme-blue.css");
            modalStage.setScene(scene);
        } catch (IOException ex) {
            LOG.log(Level.INFO, "exception: {0}", ex);
        }

        modalStage.showAndWait();
    }

    /**
     * Closes the application.
     */
//    @FXML
//    private void handleExit() {
//        System.exit(0);
//    }
}
