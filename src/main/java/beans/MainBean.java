package beans;

import databaseTools.AbstractDAO;
import databaseTools.ShootingDataDAO;
import utils.ShootingData;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("mainBean")
@SessionScoped
public class MainBean implements Serializable {
    @Inject
    private AreaCheckBean areaCheckBean;
    @Inject
    ShootingDataDAO dao;

    public void service(String[] x, String y, String radius){
        List<ShootingData> shootingDataList = new ArrayList<>();
        for (String s : x) {
            shootingDataList.add(areaCheckBean.checkShoot(s, y, radius));
        }
        if (shootingDataList.size() == 1) dao.create(shootingDataList.get(0));
        else dao.createMany(shootingDataList);
    }

    public void service(String x, String y, String radius){
        ShootingData shootingData = areaCheckBean.checkShoot(x, y, radius);
        dao.create(shootingData);
    }
}
