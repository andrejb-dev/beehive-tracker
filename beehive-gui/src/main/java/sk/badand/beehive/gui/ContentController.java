/*
 * Copyright 2015 Andrej Badinka
 */
package sk.badand.beehive.gui;

import javafx.scene.layout.Pane;
import sk.badand.beehive.gui.hive.HivePresenter;
import sk.badand.beehive.gui.hive.HiveView;
import sk.badand.beehive.gui.yard.YardPresenter;
import sk.badand.beehive.gui.yard.YardView;
import sk.badand.beehive.gui.yardlist.YardlistView;
import sk.badand.beehive.modelfx.HiveFx;
import sk.badand.beehive.modelfx.YardFx;

/**
 *
 * @author abadinka
 */
public final class ContentController {
    
    private static Pane contentPane;

    private ContentController() {
    }
    
    public static void init(Pane rootPane) {
        contentPane = rootPane;
    }
    
    public static void showYards(){
        contentPane.getChildren().clear();
        contentPane.getChildren().add((new YardlistView()).getView());
    }

    public static void showHive(YardFx parent, HiveFx hive) {
        contentPane.getChildren().clear();
        final HiveView hivesView = new HiveView();
        HivePresenter presenter = ((HivePresenter)hivesView.getPresenter());
        presenter.setHive(hive);
        presenter.setParent(parent);
        contentPane.getChildren().add(hivesView.getView());
    }

    public static void showYard(YardFx selectedItem) {
        contentPane.getChildren().clear();
        final YardView yardView = new YardView();
        YardPresenter presenter = (YardPresenter)yardView.getPresenter();
        presenter.setYard(selectedItem);
        contentPane.getChildren().add(yardView.getView());
    }
}
