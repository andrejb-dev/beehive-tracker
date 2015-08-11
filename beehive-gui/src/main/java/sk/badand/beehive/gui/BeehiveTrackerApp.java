package sk.badand.beehive.gui;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import sk.badand.beehive.gui.controller.ScreensController;
import sk.badand.beehive.gui.controller.enums.SCREEN;
import sk.badand.beehive.gui.util.LoggingProperties;

public class BeehiveTrackerApp extends Application {

    static ScreensController screenController;
    private static final SCREEN startScreen = SCREEN.RootLayout;
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
        scene.getStylesheets().add("/styles/LightTheme-blue.css");
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("Beehive Tracker");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        final Stage stageRef = stage;
        initEventHandlers(root, stageRef);

        screenController.setPrimaryStage(stage);
    }

    private void initEventHandlers(Group root, final Stage stageRef) {
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

    /**
     * The main() method is ignored in correctly deployed JavaFX application. main() serves only as fallback in case the application can not
     * be launched through deployment artifacts, e.g., in IDEs with limited FX support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
