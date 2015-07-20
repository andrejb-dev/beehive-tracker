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

/**
 *
 * @author abadinka
 */
public class YardService {

    private static final Logger LOG = Logger.getLogger(YardService.class.getName());

    private ObservableList<Yard> yards;
    private Dao dao = null;

    public YardService() {
//        try {
//            this.dao = DaoManager.createDao(PersistenceHelper.connectionSource, Yard.class);
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, null, ex);
//        }
//        yards = new ObservableListWrapper<>(dao.queryForAll());
        yards = FXCollections.observableArrayList();
        final HashMap<String, Hive> hives = new HashMap<String, Hive>();
        hives.put("test1", Hive.getMockHive());
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(YardService.class.getName()).log(Level.SEVERE, null, ex);
        }
        hives.put("test2", Hive.getMockHive());
        yards.add(new Yard(hives, Address.getMockAddress(), SunExposure.SUNNY));
        yards.add(new Yard(new HashMap<String, Hive>(hives), Address.getMockAddress(), SunExposure.SUNNY));
    }

    public List readAllYards() {
        return getYards();
    }

    public boolean createYard(Yard newYard) {
        if (!yards.contains(newYard)) {
            getYards().add(newYard);
            return true;
        }
        return false;
    }

    public Yard readYard(String yardName) {
        return Yard.getMockYard();
    }

    public Yard updateYard(Yard yard) {
        if (getYards().contains(yard)) {
            getYards().set(getYards().indexOf(yard), yard);
            return yard;
        }
        return null;
    }

    public boolean deleteYard(Yard yard) {
        return getYards().remove(yard);
    }

    public ObservableList<Yard> getYards() {
        return yards;
    }
}
