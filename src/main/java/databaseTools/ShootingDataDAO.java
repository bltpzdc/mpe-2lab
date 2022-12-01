package databaseTools;

import utils.ShootingData;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class ShootingDataDAO extends AbstractDAO<ShootingData> implements Serializable {
    public ShootingDataDAO() {
        super(ShootingData.class);
    }

    @Override
    public List<ShootingData> getAll(){
        Query query = manager.createQuery("select s from ShootingData s", ShootingData.class);
        return (List<ShootingData>) query.getResultList();
    }

    @Override
    public boolean clear(){
        manager.getTransaction().begin();
        manager.createQuery("delete FROM ShootingData s").executeUpdate();
        manager.getTransaction().commit();
        return true;
    }
}
