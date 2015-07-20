/*
 * Copyright 2014 Andrej Badinka
 */
package sk.abadinka.beehive.services;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sk.abadinka.beehive.model.entities.Hive;
import sk.abadinka.beehive.model.persistence.PersistenceHelper;

/**
 *
 * @author abadinka
 */
public class HiveService {
    private static final Logger LOG = Logger.getLogger(HiveService.class.getName());
    
    private Dao dao = null;

    public HiveService() {
        try {
            this.dao = DaoManager.createDao(PersistenceHelper.connectionSource, Hive.class);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    public List readAllHives() {
        return new ArrayList();
    }

    public boolean createHive(Hive newHive) {
        return true;
    }

    public Hive readHive(int hiveId) {
        return new Hive();
    }

    public Hive updateHive(Hive hive) {
        return hive;
    }

    public boolean deleteHive(int hiveId) {
        return true;
    }
    
}
