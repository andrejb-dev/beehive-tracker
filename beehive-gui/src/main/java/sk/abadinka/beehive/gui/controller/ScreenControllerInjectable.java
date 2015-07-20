/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.abadinka.beehive.gui.controller;

/**
 *
 * @author abadinka
 */
public interface ScreenControllerInjectable {
    
    //This method will allow the injection of the ScreenController
    public void setScreenController(ScreensController screenController);
}
