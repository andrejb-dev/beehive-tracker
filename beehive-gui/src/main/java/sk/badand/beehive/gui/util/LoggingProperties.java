/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.beehive.gui.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abadinka
 */
public class LoggingProperties {

    private static final Properties properties = new Properties();
    private static int LOG_SIZE = 10485760;
    private static int LOG_COUNT = 5;
    private static String LOG_PROFILE = "PROD";
    private static final String LOG_PROPERTIES_PATH = "main/resources/logging.properties";

    static {
        try {
            InputStream is = LoggingProperties.class.getResourceAsStream(LOG_PROPERTIES_PATH);
            if (is != null) {
                properties.load(is);
                LOG_SIZE = Integer.parseInt(String.valueOf(properties.get("LOG_SIZE")));
                LOG_COUNT = Integer.parseInt(String.valueOf(properties.get("LOG_COUNT")));
                LOG_PROFILE = String.valueOf(properties.get("LOG_PROFILE"));
            }
        } catch (IOException ex) {
            System.out.println("EXCEPTION: " + ex);
        }
    }

    public static void setUp() throws IOException {
        Handler handler = new FileHandler("logs/app.log", LOG_SIZE, LOG_COUNT);   
        handler.setLevel(Level.INFO);
        Logger.getGlobal().addHandler(handler);
        
        if ("DEBUG".equalsIgnoreCase(LOG_PROFILE)) {
            Handler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.ALL);
            Logger.getGlobal().addHandler(consoleHandler);
        }
    }
}
