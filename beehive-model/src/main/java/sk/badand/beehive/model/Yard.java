/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.badand.beehive.model;

import java.io.Serializable;
import java.util.HashMap;
import sk.badand.beehive.model.enums.SunExposure;
import sk.badand.math.Randomizer;

/**
 *
 * @author abadinka
 */
public final class Yard implements Serializable {

    //TODO need id for yard
    private final HashMap<String, Hive> hives;
    private final Address address;
    private final SunExposure sunExposure;
    private final Environment environment;
    
    public Yard(HashMap<String, Hive> hives, Address address, SunExposure sunExposure) {
        this(hives, address, sunExposure, null);
    }

    public Yard(HashMap<String, Hive> hives, Address address, SunExposure sunExposure, Environment environment) {
        this.hives = hives;
        this.address = address;
        this.sunExposure = sunExposure;
        this.environment = environment;
    }

    public static Yard getMockYard() {
        HashMap<String, Hive> hiveList = new HashMap<>();
        final int hiveCount = Randomizer.nextRandomInt(5);
        for (int i = 0; i < hiveCount; i++) {
            hiveList.put("hive_" + i, Hive.getMockHive());            
        }
        return new Yard(hiveList, Address.getMockAddress(), SunExposure.SUNNY, new Environment());
    }
}
