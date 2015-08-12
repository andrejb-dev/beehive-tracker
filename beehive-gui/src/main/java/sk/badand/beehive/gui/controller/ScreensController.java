/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.badand.beehive.gui.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import sk.badand.beehive.gui.BeehiveTrackerApp;
import sk.badand.beehive.gui.controller.enums.SCREEN;

/**
 *
 * @author abadinka
 */
public class ScreensController extends StackPane {

    private static final Logger LOG = Logger.getLogger(ScreensController.class.getName());

    private final HashMap<String, Node> screens = new HashMap<>();
    private static String SCREENS_FOLDER_PATH;
    private static String BUNDLE_FILE_PATH = "Bundle";
    private Stage primaryStage;

    public ScreensController() {
        this("/");
    }

    public ScreensController(String screenFolderName) {
        SCREENS_FOLDER_PATH = screenFolderName;

//        System.out.println("path: " + BeehiveTracker.class.getResource("view/Welcome.fxml"));
//        System.out.println("path: " + getClass().getResource("../BeehiveTracker.class"));
//        System.out.println("path: " + getClass().getClassLoader().getResource("beehive/tracker/screenManager/SCREENS.class"));
        LOG.log(Level.INFO, "loading..");
        for (SCREEN screen : SCREEN.values()) {
            if (loadScreen(screen)) {
                LOG.log(Level.FINE, "{0} loaded succesfuly.", screen.name());
            } else {
                LOG.log(Level.FINE, "{0} NOT loaded succesfuly.", screen.name());
            }
        }
        
        initLayout();
    }

    //Add the screen to the collection
    public void addScreen(SCREEN screen, Node screenNode) {
        screens.put(screen.toString(), screenNode);
    }

    //Returns the Node with the appropriate name
    public Node getScreen(SCREEN screen) {
        return screens.get(screen.toString());
    }

    //Loads the fxml file, adds the screen to the screens collection and
    //finally injects the screenPane to the controller.
    private boolean loadScreen(SCREEN screen) {
        LOG.log(Level.INFO, "loadScreen {0}", SCREENS_FOLDER_PATH + screen.toString());
        try {
            FXMLLoader myLoader = new FXMLLoader(ScreensController.class.getResource(SCREENS_FOLDER_PATH + screen.toString()));
            myLoader.setResources(ResourceBundle.getBundle(BUNDLE_FILE_PATH));
            Parent loadScreen = (Parent) myLoader.load();
            ScreenControllerInjectable myScreenControler = ((ScreenControllerInjectable) myLoader.getController());
            addScreen(screen, loadScreen);
            myScreenControler.setScreenController(this);
            return true;
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "exception {0}", e);
            return false;
        }
    }

    //This method tries to displayed the screen with a predefined name.
    //First it makes sure the screen has been already loaded.  Then if there is more than
    //one screen the new screen is been added second, and then the current screen is removed.
    // If there isn't any screen being displayed, the new screen is just added to the root.
    public boolean setScreen(final SCREEN screen) {
        LOG.log(Level.FINE, "setScreen {0}", screen);
        Node screenNode = getScreen(screen);
        if (screenNode != null) {   //screen loaded
            final DoubleProperty opacity = opacityProperty();

            if (!getChildren().isEmpty()) {    //if there is more than one screen
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(200), new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent t) {
                                getChildren().remove(0);                    //remove the displayed screen
                                getChildren().add(0, screenNode);     //add the screen
                                Timeline fadeIn = new Timeline(
                                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                        new KeyFrame(new Duration(300), new KeyValue(opacity, 1.0)));
                                fadeIn.play();
                            }
                        }, new KeyValue(opacity, 0.0)));
                fade.play();

            } else {
                setOpacity(0.0);
                getChildren().add(screenNode);       //no one else been displayed, then just show
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
        } else {
            LOG.log(Level.WARNING, "screen hasn't been loaded!!!");
            return false;
        }
    }

    /**
     * @return the primaryStage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * @param primaryStage the primaryStage to set
     */
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private void initLayout() {
        this.setPadding(new Insets(0, DEFAULT_PADDING, DEFAULT_PADDING, DEFAULT_PADDING));
        this.setPrefHeight(768);
        this.setPrefWidth(1024);
    }
    private static final int DEFAULT_PADDING = 20;

}
