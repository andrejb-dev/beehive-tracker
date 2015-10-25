/*
 * Copyright 2015 Andrej Badinka
 */
package sk.badand.beehive.modelfx;

import javafx.beans.property.StringProperty;

/**
 *
 * @author abadinka
 */
public abstract class CommonEntity {

    public abstract StringProperty nameProperty();
    public abstract EntityType type();

    @Override
    public String toString() {
        return nameProperty().getValue();
    }
}
