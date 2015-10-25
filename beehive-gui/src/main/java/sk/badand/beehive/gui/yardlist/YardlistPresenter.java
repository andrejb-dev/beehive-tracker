/*
 * Copyright 2015 Andrej Badinka
 */
package sk.badand.beehive.gui.yardlist;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javax.inject.Inject;
import sk.badand.beehive.gui.controller.ContentController;
import sk.badand.beehive.modelfx.YardFx;
import sk.badand.beehive.services.YardService;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class YardlistPresenter implements Initializable {

    @Inject
    private YardService yardService;

    @FXML
    private TableView<YardFx> yardsView;
    @FXML
    private TableColumn<YardFx, String> yardTableName;
    @FXML
    private TableColumn<YardFx, String> yardTableAddress;
    @FXML
    private TableColumn<YardFx, Integer> yardTableHivesCount;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        yardTableName.setCellValueFactory(data -> data.getValue().nameProperty());
        yardTableAddress.setCellValueFactory(data -> data.getValue().addressProperty().asString());
        yardTableHivesCount.setCellValueFactory(data -> data.getValue().hivesCount());
//        yardsView.setItems(yardService.getYards());
        yardsView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        initBindings();
    }

    private void initBindings() {
        yardsView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }  
    
    @FXML
    public void showYard() {
        if (yardsView.getSelectionModel().getSelectedItem() != null) {
            ContentController.showYard(yardsView.getSelectionModel().getSelectedItem());
        }
    }
    
}
