/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.beehive.services;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sk.badand.beehive.model.Hive;
import sk.badand.beehive.modelfx.persistence.PersistenceHelper;

/**
 *
 * @author abadinka
 */
public class HiveService {
    private static final Logger LOG = Logger.getLogger(HiveService.class.getName());
    private static HiveService instance;
    
    private Dao dao = null;

    public static HiveService getInstance() {
        if (instance == null) {
            instance = new HiveService();
        }
        return instance;
    }

    private HiveService() {
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

    public Hive readHive(String name) {
        return new Hive(name);
    }

    public Hive updateHive(Hive hive) {
        return hive;
    }

    public boolean deleteHive(int hiveId) {
        return true;
    }
    
}
