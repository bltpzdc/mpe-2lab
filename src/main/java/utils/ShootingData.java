package utils;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@NoArgsConstructor
@Table(name = "shooting_data")
public class ShootingData {

    @Getter @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Getter @Setter @Column(name = "x")
    private double x;
    @Getter @Setter @Column(name = "y")
    private double y;
    @Getter @Setter @Column(name = "radius")
    private double radius;
    @Getter @Setter @Column(name = "hit")
    private boolean hit;
    @Getter @Setter @Column(name = "executeTime")
    private long executeTime;
    @Getter @Setter @Column(name = "date")
    private ZonedDateTime date;

    public String getStringDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return formatter.format(date);
    }

    public String toString(){
        return "ShootingData={"+
                "x: "+ x +
                ", y: "+ y +
                ", radius: "+ radius +
                ", hit:"+ hit +
                ", executeTime:"+ executeTime +
                ", date: "+ date +"}";
    }

}
