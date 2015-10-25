/*
 * Copyright 2015 Andrej Badinka
 */
package sk.badand.beehive.gui.controller;

import com.airhacks.afterburner.views.FXMLView;
import javafx.scene.layout.Pane;

/**
 *
 * @author abadinka
 */
public class Navigator {
    
    private static Pane contentPane;
    
    public void init(Pane content) {
        contentPane = content;
    }    
    
    public void load(FXMLView view) {
        contentPane.getChildren().clear();
        contentPane.getChildren().add(view.getView());
    }    
}
