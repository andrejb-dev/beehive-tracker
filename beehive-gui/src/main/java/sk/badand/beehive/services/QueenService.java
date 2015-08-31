/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.beehive.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import sk.badand.beehive.model.Breed;
import sk.badand.beehive.model.Queen;

/**
 *
 * @author abadinka
 */
public class QueenService {

    private static final Logger LOG = Logger.getLogger(QueenService.class.getName());
    private static QueenService instance;


    public static QueenService getInstance() {
        if (instance == null) {
            instance = new QueenService();
        }
        return instance;
    }

    private QueenService() {
    }

    public List readAllQueens() {
        return new ArrayList();
    }

    public boolean createQueen(Queen newQueen) {
        return true;
    }

    public Queen readQueen(Breed breed) {
        return new Queen(breed);
    }

    public Queen updateQueen(Queen queen) {
        return queen;
    }

    public boolean deleteQueen(int queenId) {
        return true;
    }

}
