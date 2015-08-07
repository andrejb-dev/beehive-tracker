/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.beehive.services;

import com.j256.ormlite.dao.Dao;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sk.badand.beehive.model.Address;
import sk.badand.beehive.model.Hive;
import sk.badand.beehive.model.Yard;
import sk.badand.beehive.model.enums.SunExposure;
import sk.badand.beehive.modelfx.YardFx;

/**
 *
 * @author abadinka
 */
public class YardService {

    private static final Logger LOG = Logger.getLogger(YardService.class.getName());

    private ObservableList<YardFx> yards = FXCollections.observableArrayList();
    private Dao dao = null;
    private static YardService instance;

    public static YardService getInstance() {
        if (instance == null) {
            instance = new YardService();
        }
        return instance;
    }

    YardService() {
//        try {
//            this.dao = DaoManager.createDao(PersistenceHelper.connectionSource, Yard.class);
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, null, ex);
//        }
//        yards = new ObservableListWrapper<>(dao.queryForAll());
        yards.add(new YardFx(Yard.getMockYard()));
        yards.add(new YardFx(Yard.getMockYard()));
        yards.add(new YardFx(Yard.getMockYard()));
        yards.add(new YardFx(Yard.getMockYard()));
    }

    public List readAllYards() {
        return getYards();
    }

    public boolean createYard(Yard newYard) {
        if (!yards.contains(newYard)) {
            getYards().add(new YardFx(newYard));
            return true;
        }
        return false;
    }

    public Yard readYard(String yardName) {
        return Yard.getMockYard();
    }

    public Yard updateYard(Yard yard) {
        if (getYards().contains(yard)) {
            getYards().set(getYards().indexOf(yard), new YardFx(yard));
            return yard;
        }
        return null;
    }

    public boolean deleteYard(Yard yard) {
        return getYards().remove(yard);
    }

    public ObservableList<YardFx> getYards() {
        return yards;
    }
}
