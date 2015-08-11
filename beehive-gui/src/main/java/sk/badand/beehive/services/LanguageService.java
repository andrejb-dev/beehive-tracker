/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.beehive.services;

import java.util.ResourceBundle;

/**
 *
 * @author zavael
 */
public class LanguageService {

    private LanguageService instance;
    private ResourceBundle bundle;

    private LanguageService() {
        bundle = ResourceBundle.getBundle("Bundle");
    }

    public LanguageService getInstance() {
        if (instance == null) {
            instance = new LanguageService();
        }
        return instance;
    }

    public String getValue(String key) {
        if (key != null && bundle.containsKey(key)) {
            return bundle.getString(key);
        }
        return key != null
                ? key
                : "";
    }

}
