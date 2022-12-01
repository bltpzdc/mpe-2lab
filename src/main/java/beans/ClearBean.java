package beans;

import databaseTools.ShootingDataDAO;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("clearBean")
@SessionScoped
public class ClearBean implements Serializable {
    @Inject
    private ShootingDataDAO dao;
    public void clear(){
        dao.clear();
    }
}
