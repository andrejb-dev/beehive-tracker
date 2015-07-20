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
import sk.abadinka.beehive.model.entities.Breed;
import sk.abadinka.beehive.model.persistence.PersistenceHelper;

/**
 *
 * @author abadinka
 */
public class BreedService {
    private static final Logger LOG = Logger.getLogger(BreedService.class.getName());
    
    private Dao dao = null;

    public BreedService() {
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

    public Breed readBreed(int breedId) {
        return new Breed();
    }

    public Breed updateBreed(Breed breed) {
        return breed;
    }

    public boolean deleteBreed(int breedId) {
        return true;
    }
    
}
