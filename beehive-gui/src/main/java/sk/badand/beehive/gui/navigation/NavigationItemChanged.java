/*
 * Copyright 2015 Andrej Badinka
 */
package sk.badand.beehive.gui.navigation;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TreeItem;
import javax.inject.Inject;
import sk.badand.beehive.gui.controller.Navigator;
import sk.badand.beehive.gui.dashboard.DashboardView;
import sk.badand.beehive.gui.hive.HivePresenter;
import sk.badand.beehive.gui.hive.HiveView;
import sk.badand.beehive.gui.yard.YardPresenter;
import sk.badand.beehive.gui.yard.YardView;
import sk.badand.beehive.modelfx.CommonEntity;
import sk.badand.beehive.modelfx.HiveFx;
import sk.badand.beehive.modelfx.YardFx;

/**
 *
 * @author abadinka
 */
public class NavigationItemChanged implements ChangeListener<TreeItem<CommonEntity>> {

    private static final Logger LOG = Logger.getLogger(NavigationItemChanged.class.getName());
    private final Navigator contentNavigator;

    NavigationItemChanged(Navigator contentNavigator) {
        super();
        this.contentNavigator = contentNavigator;
    }

    @Override
    public void changed(ObservableValue<? extends TreeItem<CommonEntity>> observable, TreeItem<CommonEntity> oldValue, TreeItem<CommonEntity> newValue) {
        LOG.log(Level.INFO, "changed from {0} to {1}", new Object[]{oldValue, newValue});
        try {
            LOG.log(Level.INFO, "changed from {0} to {1}", new Object[]{oldValue.getValue().type(), newValue.getValue().type()});
        } catch (Exception e) {
            LOG.log(Level.INFO, "err: {0}", e.getMessage());
        }
        if (newValue != null && newValue.getValue() != null) {
            CommonEntity commonEntity = newValue.getValue();
            switch (commonEntity.type()) {
                case YARD:
                    final YardView yardView = new YardView();
                    YardPresenter yardPresenter = (YardPresenter) yardView.getPresenter();
                    yardPresenter.setYard((YardFx) commonEntity);
                    contentNavigator.load(yardView);
                    break;
                case HIVE:
                    final HiveView hiveView = new HiveView();
                    HivePresenter hivePresenter = (HivePresenter) hiveView.getPresenter();
                    hivePresenter.setHive((HiveFx) commonEntity);
                    contentNavigator.load(hiveView);
                    break;
                default:
                    contentNavigator.load(new DashboardView());
            }
        }
    }

}
