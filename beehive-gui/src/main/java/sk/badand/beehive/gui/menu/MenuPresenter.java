/*
 * Copyright 2015 Andrej Badinka
 */
package sk.badand.beehive.gui.menu;

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
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sk.badand.beehive.BeehiveTrackerMain;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class MenuPresenter implements Initializable {
    private static final Logger LOG = Logger.getLogger(MenuPresenter.class.getName());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    private void handleNew() {
        LOG.log(Level.INFO, "entering");
        //TODO handleNew
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
        File file = fileChooser.showOpenDialog(BeehiveTrackerMain.getMainStage());

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
        File file = fileChooser.showSaveDialog(BeehiveTrackerMain.getMainStage());

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
        //TODO remake to use FXMLVIEW
        LOG.log(Level.INFO, "entering");
        FXMLLoader loader = new FXMLLoader();
        loader.setResources(ResourceBundle.getBundle("Bundle"));
        loader.setLocation(getClass().getResource("/fxml/parts/TipsModal.fxml"));

        Stage modalStage = new Stage(StageStyle.UTILITY);
        modalStage.initModality(Modality.WINDOW_MODAL);
        modalStage.initOwner(BeehiveTrackerMain.getMainStage());
        try {
            Scene scene = new Scene((Parent) loader.load());
            scene.getStylesheets().add("/styles/LightTheme-blue.css");
            modalStage.setScene(scene);
        } catch (IOException ex) {
            LOG.log(Level.INFO, "exception: {0}", ex);
        }

        modalStage.showAndWait();
    }
}
