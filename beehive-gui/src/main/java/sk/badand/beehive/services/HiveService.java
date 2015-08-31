/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.beehive.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import sk.badand.beehive.model.Hive;

/**
 *
 * @author abadinka
 */
public class HiveService {
    private static final Logger LOG = Logger.getLogger(HiveService.class.getName());
    private static HiveService instance;

    public static HiveService getInstance() {
        if (instance == null) {
            instance = new HiveService();
        }
        return instance;
    }

    private HiveService() {
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
