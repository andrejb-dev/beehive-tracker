/*
 * Copyright 2015 Andrej Badinka
 */
package sk.badand.beehive.gui.navigation;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javax.inject.Inject;
import sk.badand.beehive.gui.controller.Navigator;
import sk.badand.beehive.modelfx.CommonEntity;
import sk.badand.beehive.modelfx.EntityType;
import sk.badand.beehive.modelfx.YardFx;
import sk.badand.beehive.services.YardService;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class NavigationPresenter implements Initializable {

    private static final Logger LOG = Logger.getLogger(NavigationPresenter.class.getName());

    @Inject
    private YardService yardService;    
    @Inject
    Navigator contentNavigator;

    @FXML
    TreeView<CommonEntity> navigationTree;

//    private final Image rootIcon = new Image("");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTree(rb.getString("rootNodeText"));
        initTreeItems();
    }

    private void initTree(String caption) {
        navigationTree.getSelectionModel().selectedItemProperty().addListener(new NavigationItemChanged(contentNavigator));
        CommonEntity root = new CommonEntity() {
            
            @Override
            public StringProperty nameProperty() {
                return new SimpleStringProperty(caption);
            }

            @Override
            public EntityType type() {
                return EntityType.NONE;
            }
        };
        navigationTree.setRoot(new TreeItem<>(root));
        navigationTree.getRoot().setExpanded(true);
    }

    private void initTreeItems() {
        yardService.getYards().stream().forEach(yard -> {
            fillItem(navigationTree.getRoot(), yard);
        });
    }

    private void fillItem(TreeItem<CommonEntity> parent, CommonEntity item) {
        TreeItem<CommonEntity> treeItem = new TreeItem<>(item);
        switch (item.type()) {
            case YARD:
                YardFx yard = (YardFx) item;
                if (!yard.hivesProperty().isEmpty()) {
                    yard.hivesProperty().stream().forEach((subItem) -> fillItem(treeItem, subItem));
                }
                break;
            case HIVE:
//                HiveFx yard = (HiveFx) item;
//                if (!yard.hivesProperty().isEmpty()) {
//                    yard.hivesProperty().stream().forEach((subItem) -> fillItem(treeItem, subItem));
//                }
                break;
            default:
                throw new AssertionError();
        }
        parent.getChildren().add(treeItem);
    }
    
}
