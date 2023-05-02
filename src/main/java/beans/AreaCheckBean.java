package beans;

import utils.ShootingData;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.swing.text.DateFormatter;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Named("areaCheck")
@SessionScoped
public class AreaCheckBean implements Serializable {
    public ShootingData checkShoot(String rawX, String rawY, String rawRadius){
        long startTime = System.nanoTime();
        boolean wasHit;
        double x = Double.parseDouble(rawX);
        double y = Double.parseDouble(rawY);
        double radius = Double.parseDouble(rawRadius);
        if (x >= 0 && y >= 0){
            if (y <= -2*x+radius) wasHit = true;
            else wasHit = false;
        }
        else if (x >= 0 && y <= 0){
            if (x * x + y*y <= radius*radius) wasHit = true;
            else wasHit = false;
        }
        else if (x <= 0 && y <= 0){
            if (x >= -(radius) && y >= -(radius)/2) wasHit = true;
            else wasHit = false;
        }
        else wasHit = false;

        ShootingData shootingData = new ShootingData();
        shootingData.setX(x);
        shootingData.setY(y);
        shootingData.setRadius(radius);
        shootingData.setHit(wasHit);
        shootingData.setDate(ZonedDateTime.now(ZoneId.of("UTC")));
        shootingData.setExecuteTime((System.nanoTime()-startTime)/1000);

        return shootingData;
    }
}
