package databaseTools;

import utils.ShootingData;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

public abstract class AbstractDAO<T> implements DAO<T>{
    protected EntityManager manager;
    private EntityTransaction transaction;
    private Class<T> clazz;

    public AbstractDAO(Class<T> clazz){
        manager = Persistence.createEntityManagerFactory("shoot").createEntityManager();
        transaction = manager.getTransaction();
    }

    public T create(T entity){
        try{
            transaction.begin();
            manager.persist(entity);
            transaction.commit();
            return entity;
        } catch (RuntimeException e){
            return null;
        }
    }

    public T read(long id){
        return manager.find(clazz, id);
    }

    public boolean delete(long id){
        try{
            T object = manager.find(clazz, id);
            if (object != null){
                manager.remove(object);
                return true;
            }
            return false;
        } catch (RuntimeException e){
            return false;
        }
    }

    public boolean createMany(List<T> entities){
        try {
            transaction.begin();
            for (T i : entities) {
                manager.persist(i);
            }
            manager.flush();
            transaction.commit();
            return true;
        } catch (RuntimeException e){
            return false;
        }
    }
}
