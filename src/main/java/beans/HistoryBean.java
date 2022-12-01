package beans;

import databaseTools.ShootingDataDAO;
import lombok.Getter;
import lombok.Setter;
import utils.ShootingData;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Named("historyBean")
@SessionScoped
public class HistoryBean implements Serializable {
    private List<ShootingData> shoots;
    @Inject
    private ShootingDataDAO dao;
    @Getter @Setter
    private String offset = "";

    public List<ShootingData> getShoots() {
        shoots = dao.getAll();
        String pattern = "UTC" + offset;
        for (ShootingData i : shoots){
            i.setDate(i.getDate().withZoneSameInstant(ZoneId.of(pattern)));
        }
        shoots.sort((o1, o2) -> (int) (o2.getId() - o1.getId()));
        return shoots;
    }
}
