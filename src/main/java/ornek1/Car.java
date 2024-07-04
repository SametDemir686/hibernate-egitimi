package ornek1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
// @Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "type")
    private String tip;
    private String model;
    private String color;

    public Car(String tip, String model, String color) {
        this.tip = tip;
        this.model = model;
        this.color = color;
    }
}
