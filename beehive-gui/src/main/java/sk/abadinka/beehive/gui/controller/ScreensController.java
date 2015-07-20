/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.abadinka.beehive.gui.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author abadinka
 */
public class ScreensController extends StackPane {

    private static final Logger LOG = Logger.getLogger(ScreensController.class.getName());

    private final HashMap<String, Node> screens = new HashMap<>();
    private static String SCREENS_FOLDER_PATH;
    private static String BUNDLE_FILE_PATH = "Bundle";

    public ScreensController() {
        this("/");
    }

    public ScreensController(String screenFolderName) {
        SCREENS_FOLDER_PATH = screenFolderName;

//        System.out.println("path: " + BeehiveTracker.class.getResource("view/Welcome.fxml"));
//        System.out.println("path: " + getClass().getResource("../BeehiveTracker.class"));
//        System.out.println("path: " + getClass().getClassLoader().getResource("beehive/tracker/screenManager/SCREENS.class"));
        for (SCREENS screen : SCREENS.values()) {
            if (loadScreen(screen.toString())) {
                LOG.log(Level.FINE, "{0} loaded succesfuly.", screen.name());
            } else {
                LOG.log(Level.FINE, "{0} NOT loaded succesfuly.", screen.name());
            }
        }
    }

    //Add the screen to the collection
    public void addScreen(String name, Node screen) {
        screens.put(name, screen);
    }

    //Returns the Node with the appropriate name
    public Node getScreen(String name) {
        return screens.get(name);
    }

    //Loads the fxml file, add the screen to the screens collection and
    //finally injects the screenPane to the controller.
    private boolean loadScreen(String name) {
        System.out.println("loadScreen " + SCREENS_FOLDER_PATH + name);
        try {
            FXMLLoader myLoader = new FXMLLoader(ScreensController.class.getResource(SCREENS_FOLDER_PATH + name));
            myLoader.setResources(ResourceBundle.getBundle(BUNDLE_FILE_PATH));
            Parent loadScreen = (Parent) myLoader.load();
            ScreenControllerInjectable myScreenControler = ((ScreenControllerInjectable) myLoader.getController());
            myScreenControler.setScreenController(this);
            addScreen(name, loadScreen);
            return true;
        } catch (IOException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            return false;
        }
    }

    //This method tries to displayed the screen with a predefined name.
    //First it makes sure the screen has been already loaded.  Then if there is more than
    //one screen the new screen is been added second, and then the current screen is removed.
    // If there isn't any screen being displayed, the new screen is just added to the root.
    public boolean setScreen(final SCREENS screen) {
        System.out.println("setScreen " + screen);
        Node screenNode = getScreen(screen.toString());
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
            System.out.println("screen hasn't been loaded!!! \n");
            return false;
        }
    }

    public static enum SCREENS {

        Welcome("Welcome.fxml");
//        Club("Club.fxml"),
//        Transfers("Transfers.fxml"),
//        Competitions("Competitions.fxml"),
//        TopMenu("TopMenu.fxml"),
//        StartPage("StartScreen.fxml"),
//        MatchPreview("MatchPreview.fxml"),
//        SquadTactic("SquadTactic.fxml"),
//        Match("Match.fxml"),
//        MatchResult("MatchResult.fxml");

        private final String screenName;

        private SCREENS(final String screenName) {
            this.screenName = screenName;
        }

        @Override
        public String toString() {
            return screenName;
        }
    }
}
