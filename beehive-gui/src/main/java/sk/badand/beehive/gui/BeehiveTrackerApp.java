package sk.badand.beehive.gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sk.badand.beehive.gui.controller.ScreensController;
import sk.badand.beehive.gui.util.LoggingProperties;


public class BeehiveTrackerApp extends Application {
    
    static ScreensController screenController;
    private static final ScreensController.SCREENS startScreen = ScreensController.SCREENS.RootLayout;
    double dragAnchorX;
    double dragAnchorY;
    
    static {
        try {
            LoggingProperties.setUp();
            Logger.getLogger(BeehiveTrackerApp.class.getName()).log(Level.INFO, "Log set up successfuly.");
        } catch (IOException ex) {
            System.out.println("_EXCEPTION: " + ex);
        }
        
        screenController = new ScreensController("/fxml/");
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        screenController.setScreen(startScreen);
                
        Group root = new Group();
        root.getChildren().addAll(screenController);
        
        Scene scene = new Scene(root, 1024, 768);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
        final Stage stageRef = stage;        
        initEventHandlers(root, stageRef);
        
        screenController.setPrimaryStage(stage);
    }

    private void initEventHandlers(Group root, final Stage stageRef) {
        root.setOnMousePressed((MouseEvent me) -> {
            dragAnchorX = me.getScreenX() - stageRef.getX();
            dragAnchorY = me.getScreenY() - stageRef.getY();
        });
        
        root.setOnMouseDragged((MouseEvent me) -> {
            stageRef.setX(me.getScreenX() - dragAnchorX);
            stageRef.setY(me.getScreenY() - dragAnchorY);
        });
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
        launch(args);
    }

}
