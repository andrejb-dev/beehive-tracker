/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.beehive.services;

import java.util.List;
import java.util.logging.Logger;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import sk.badand.beehive.model.Yard;
import sk.badand.beehive.modelfx.CommonEntity;
import sk.badand.beehive.modelfx.YardFx;

/**
 *
 * @author abadinka
 */
public class YardService {

    private static final Logger LOG = Logger.getLogger(YardService.class.getName());

    private ListProperty<CommonEntity> yards = new SimpleListProperty<>(FXCollections.observableArrayList());

    public YardService() {
        yards.add(new YardFx(Yard.getMockYard()));
        yards.add(new YardFx(Yard.getMockYard()));
        yards.add(new YardFx(Yard.getMockYard()));
        yards.add(new YardFx(Yard.getMockYard()));
    }

    public boolean createYard(Yard newYard) {
        final YardFx yardFx = new YardFx(newYard);
        if (!yards.contains(yardFx)) {
            getYards().add(yardFx);
            return true;
        }
        return false;
    }

    public YardFx updateYard(YardFx yard) {
        if (getYards().contains(yard)) {
            getYards().set(getYards().indexOf(yard), yard);
            return yard;
        }
        return null;
    }

    public boolean deleteYard(YardFx yard) {
        return getYards().remove(yard);
    }

    public ListProperty<CommonEntity> getYards() {
        return yards;
    }
}
