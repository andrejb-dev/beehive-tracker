/*
 * Copyright 2015 Andrej Badinka
 */
package sk.badand.beehive.gui.tips;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import sk.badand.math.Randomizer;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class TipsPresenter implements Initializable {

    @FXML
    private TextArea tipContentArea;

    private ResourceBundle resourceBundle = ResourceBundle.getBundle("Tips");
    private Set<String> tipKeys = resourceBundle.keySet();
    private String lastShowedTipKey = "tip.theme1";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO    
        tipContentArea.setText(resourceBundle.getString(lastShowedTipKey));
    }

    @FXML
    private void showNextTip() {
        while (true) {
            int nextTip = Randomizer.nextRandomInt(tipKeys.size());
            int current = 0;
            for (String tipKey : tipKeys) {
                if (current == nextTip) {
                    if (!lastShowedTipKey.equals(tipKey)) {
                        lastShowedTipKey = tipKey;
                        tipContentArea.setText(resourceBundle.getString(lastShowedTipKey));
                        return;
                    } else if (nextTip < tipKeys.size()) {
                        nextTip += 1;
                    }
                }
                current += 1;
            }
        }
    }
}
