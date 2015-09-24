/*
 * Copyright 2015 Andrej Badinka
 */
package sk.badand.beehive.gui.hive;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sk.badand.beehive.gui.ContentController;
import sk.badand.beehive.modelfx.HiveFx;
import sk.badand.beehive.modelfx.YardFx;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class HivePresenter implements Initializable {
    private ObjectProperty<HiveFx> hive = new SimpleObjectProperty<>();
    @FXML
    private TextField hiveName;
    @FXML
    private TextField hiveState;
    @FXML
    private TextField hiveCreated;
    @FXML
    private TextArea hiveNotes;
    @FXML
    Button btnEdit;
    @FXML
    Button btnRemove;
    @FXML
    Button btnDone;
    private YardFx parent;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hive.addListener((ov, oldV, newV) -> {
            if (newV != null) {
                
            }
        });
    }

    public void setHive(HiveFx hiveFx) {
        hive.set(hiveFx);
    }
    
    public void setParent(YardFx yard) {
        parent = yard;
    }    
    
    public void showYard(){
        ContentController.showYard(parent);
    }    
}
