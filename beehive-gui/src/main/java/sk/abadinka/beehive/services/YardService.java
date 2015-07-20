/*
 * Copyright 2014 Andrej Badinka
 */
package sk.abadinka.beehive.services;

import com.j256.ormlite.dao.Dao;
import java.util.List;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sk.abadinka.beehive.model.entities.Yard;

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
        yards.add(new Yard(1, "first"));
        yards.add(new Yard(2, "second"));
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

    public Yard readYard(int yardId) {
        for (Yard yard : getYards()) {
            if (yard.getId() == yardId) {
                return yard;
            }
        }
        return null;
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
