/*
 * Copyright 2015 Andrej Badinka
 */
package sk.badand.beehive.gui.controller.enums;

/**
 *
 * @author zavael
 */
public enum SCREEN {

    RootLayout("RootLayout.fxml"),
    TopMenu("parts/Menu.fxml"),
    YardList("parts/YardList.fxml"),
    YardOverview("YardOverview.fxml"),
    HiveList("parts/HiveList.fxml"),
    HiveOverview("HiveOverview.fxml");

    private final String screenName;

    private SCREEN(final String screenName) {
        this.screenName = screenName;
    }

    @Override
    public String toString() {
        return screenName;
    }
}
