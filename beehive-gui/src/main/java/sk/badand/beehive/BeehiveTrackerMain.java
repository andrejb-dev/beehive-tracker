/*
 * Copyright 2015 Andrej Badinka
 */
package sk.badand.beehive;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import sk.badand.beehive.gui.GuiView;
import sk.badand.beehive.util.LoggingProperties;

/**
 *
 * @author abadinka
 */
public class BeehiveTrackerMain extends Application {
    private static final Logger LOG;
    
    private static Stage mainStage;
    
    static {
        LoggingProperties.setUp();
        LOG = Logger.getLogger(BeehiveTrackerMain.class.getName());
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        mainStage = stage;
        GuiView guiView = new GuiView();
        
        Scene scene = new Scene(guiView.getView(), 1024, 768);
        stage.initStyle(StageStyle.UNIFIED);
        stage.setTitle("Beehive Tracker");
        scene.getStylesheets().add("/styles/LightTheme-blue.css");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        initEventHandlers(guiView.getView(), stage);
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LOG.log(Level.INFO, "starting");
        launch(args);
    }

    public static Stage getMainStage() {
        return mainStage;
    }
    
    private void initEventHandlers(Parent root, final Stage stageRef) {
//        root.setOnMousePressed((MouseEvent me) -> {
//            dragAnchorX = me.getScreenX() - stageRef.getX();
//            dragAnchorY = me.getScreenY() - stageRef.getY();
//        });
//        
//        root.setOnMouseDragged((MouseEvent me) -> {
//            stageRef.setX(me.getScreenX() - dragAnchorX);
//            stageRef.setY(me.getScreenY() - dragAnchorY);
//        });
        stageRef.setOnCloseRequest((WindowEvent ev) -> {
            Alert closingConfirm = new Alert(Alert.AlertType.CONFIRMATION);
            closingConfirm.setTitle("Alert");
            closingConfirm.setContentText("Close?");
            Optional<ButtonType> result = closingConfirm.showAndWait();
            if (result.get() != ButtonType.OK) {
                ev.consume();
            }
        });

    }
}
