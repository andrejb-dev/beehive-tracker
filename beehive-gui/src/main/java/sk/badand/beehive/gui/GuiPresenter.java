/*
 * Copyright 2015 Andrej Badinka
 */
package sk.badand.beehive.gui;

import sk.badand.beehive.gui.controller.ContentController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javax.inject.Inject;
import sk.badand.beehive.gui.controller.Navigator;
import sk.badand.beehive.gui.dashboard.DashboardView;
import sk.badand.beehive.gui.menu.MenuView;
import sk.badand.beehive.gui.navigation.NavigationView;
import sk.badand.beehive.gui.yardlist.YardlistView;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class GuiPresenter implements Initializable {
    
    @Inject
    Navigator contentNavigator;

    @FXML
    Pane menu;
    @FXML
    Pane navigation;
    @FXML
    Pane content;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        menu.getChildren().add((new MenuView()).getView());
        navigation.getChildren().add(new NavigationView().getView());
        
        contentNavigator.init(content);
        contentNavigator.load(new DashboardView());
    }
}
