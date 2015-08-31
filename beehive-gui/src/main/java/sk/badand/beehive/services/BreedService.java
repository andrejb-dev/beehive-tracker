/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.beehive.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import sk.badand.beehive.model.Breed;

/**
 *
 * @author abadinka
 */
public class BreedService {
    private static final Logger LOG = Logger.getLogger(BreedService.class.getName());
    private static BreedService instance;
    
    public static BreedService getInstance() {
        if (instance == null) {
            instance = new BreedService();
        }
        return instance;
    }

    private BreedService() {
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
