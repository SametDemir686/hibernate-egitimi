package embeddable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Citizen {

    @Id
    private String identificationNo;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Embedded
    private Address address;

}
