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
import sk.badand.beehive.model.Breed;
import sk.badand.beehive.modelfx.persistence.PersistenceHelper;

/**
 *
 * @author abadinka
 */
public class BreedService {
    private static final Logger LOG = Logger.getLogger(BreedService.class.getName());
    private static BreedService instance;
    
    private Dao dao = null;

    public static BreedService getInstance() {
        if (instance == null) {
            instance = new BreedService();
        }
        return instance;
    }

    private BreedService() {
        try {
            this.dao = DaoManager.createDao(PersistenceHelper.connectionSource, Breed.class);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    public List readAllBreeds() {
        return new ArrayList();
    }

    public boolean createBreed(Breed newBreed) {
        return true;
    }

    public Breed readBreed(String name) {
        return new Breed(name);
    }

    public Breed updateBreed(Breed breed) {
        return breed;
    }

    public boolean deleteBreed(int breedId) {
        return true;
    }
    
}
