/*
 * Copyright 2015 Andrej Badinka
 */
package sk.badand.beehive.gui.yard;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.inject.Inject;
import sk.badand.beehive.gui.ContentController;
import sk.badand.beehive.model.enums.Strength;
import sk.badand.beehive.modelfx.HiveFx;
import sk.badand.beehive.modelfx.YardFx;
import sk.badand.beehive.services.YardService;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class YardPresenter implements Initializable {

    private static final Logger LOG = Logger.getLogger(YardPresenter.class.getName());

    ObjectProperty<YardFx> yard = new SimpleObjectProperty<>();
    BooleanProperty editMode = new SimpleBooleanProperty(Boolean.FALSE);
    @Inject
    YardService yardService;

    @FXML
    TextField yardName;
    @FXML
    TextField yardAddress;
    @FXML
    TextField yardDescription;
    @FXML
    Button btnEdit;
    @FXML
    Button btnRemove;
    @FXML
    Button btnDone;
    @FXML
    TableView<HiveFx> hivesView;
    @FXML
    private TableColumn<HiveFx, String> hiveTableName;
    @FXML
    private TableColumn<HiveFx, LocalDate> hiveTableCreated;
    @FXML
    private TableColumn<HiveFx, Strength> hiveTableStrenght;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hiveTableName.setCellValueFactory(data -> data.getValue().nameProperty());
        hiveTableCreated.setCellValueFactory(data -> data.getValue().createdProperty());
        hiveTableStrenght.setCellValueFactory(data -> data.getValue().strengthProperty());
        yard.addListener((ov, oldV, newV) -> {
            if (newV != null) {
                yardName.textProperty().bindBidirectional(newV.nameProperty());
                yardAddress.textProperty().bindBidirectional(newV.addressProperty().getValue().formatedProperty());
                yardDescription.textProperty().bindBidirectional(newV.descriptionProperty());

                hivesView.setItems(newV.hivesProperty());
                LOG.log(Level.FINE, "hives prop {0}", newV.hivesProperty());
            }
        });

        hivesView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        hivesView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        yardName.editableProperty().bind(editMode);
        yardAddress.editableProperty().bind(editMode);
        yardDescription.editableProperty().bind(editMode);

        btnRemove.disableProperty().bind(editMode);
        btnEdit.visibleProperty().bind(editMode.not());
        btnEdit.managedProperty().bind(editMode.not());
        btnDone.visibleProperty().bind(editMode);
        btnDone.managedProperty().bind(editMode);
    }

    @FXML
    public void editYard() {
        editMode.setValue(Boolean.TRUE);
    }

    @FXML
    public void doneEditing() {
        editMode.setValue(Boolean.FALSE);
    }

    @FXML
    public void deleteYard() {
        ContentController.showYards();
    }

    @FXML
    public void showHive() {
        LOG.log(Level.FINE, "selected hive {0}", hivesView.getSelectionModel().getSelectedItem());
        ContentController.showHive(yard.get(), hivesView.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void showYards() {
        ContentController.showYards();
    }

    public void setYard(YardFx yardFx) {
        yard.set(yardFx);
    }
}
