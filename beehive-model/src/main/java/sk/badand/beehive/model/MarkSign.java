/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.badand.beehive.model;

import sk.badand.beehive.model.enums.Color;
import java.io.Serializable;

/**
 *
 * @author abadinka
 */
public final class MarkSign implements Serializable {

    private final Color markingColor;

    private MarkSign() {
        this.markingColor = Color.NONE;
    }

    public MarkSign(Color markingColor) {
        this.markingColor = markingColor;
    }

    public static MarkSign unmarked() {
        return new MarkSign();
    }

    public boolean isMarked() {
        return markingColor != Color.NONE;
    }

    public Color getMarkingColor() {
        return markingColor;
    }
}
