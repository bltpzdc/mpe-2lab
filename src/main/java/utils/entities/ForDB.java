package utils.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "lab3_table")
public class ForDB {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double x;
    private double y;
    private double r;

}
