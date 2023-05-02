package beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.ShootingData;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AreaCheckTest {
    @Test
    void checkMissedTriangleShoot() {
        AreaCheckBean areaCheckBean = new AreaCheckBean();
        ShootingData shoot = areaCheckBean.checkShoot("1", "1", "1");
        assertFalse(shoot.isHit());
    }

    @Test
    public void checkTriangleShoot() {
        AreaCheckBean areaCheckBean = new AreaCheckBean();
        ShootingData shoot = areaCheckBean.checkShoot("1", "1", "4");
        assertTrue(shoot.isHit());
    }

    @Test
    public void checkMissedCircleShoot() {
        AreaCheckBean areaCheckBean = new AreaCheckBean();
        ShootingData shoot = areaCheckBean.checkShoot("2", "-2", "2");
        assertFalse(shoot.isHit());
    }

    @Test
    public void checkCircleShoot() {
        AreaCheckBean areaCheckBean = new AreaCheckBean();
        ShootingData shoot = areaCheckBean.checkShoot("1", "-2", "3");
        assertTrue(shoot.isHit());
    }

    @Test
    public void checkMissedRectangleShoot() {
        AreaCheckBean areaCheckBean = new AreaCheckBean();
        ShootingData shoot = areaCheckBean.checkShoot("-1", "-3", "2");
        assertFalse(shoot.isHit());
    }

    @Test
    public void checkRectangleShoot() {
        AreaCheckBean areaCheckBean = new AreaCheckBean();
        ShootingData shoot = areaCheckBean.checkShoot("-2", "-2", "4");
        assertTrue(shoot.isHit());
    }

    @Test
    public void checkEmptyAreaShoot() {
        AreaCheckBean areaCheckBean = new AreaCheckBean();
        ShootingData shoot = areaCheckBean.checkShoot("-1", "2", "4");
        assertFalse(shoot.isHit());
    }

    @Test
    public void check0Shoot() {
        AreaCheckBean areaCheckBean = new AreaCheckBean();
        ShootingData shoot = areaCheckBean.checkShoot("0", "0", "2");
        assertTrue(shoot.isHit());
    }

    @Test
    public void checkInvalidParamsShoot() {
        AreaCheckBean areaCheckBean = new AreaCheckBean();
        Assertions.assertThrows(NumberFormatException.class, () -> areaCheckBean.checkShoot("hacker", "aboba", ""));
    }
}
