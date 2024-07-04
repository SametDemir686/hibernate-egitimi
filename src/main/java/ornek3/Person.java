package ornek3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String surname;

    @ElementCollection
    @CollectionTable(name = "person_addresses")
    private List<String> addresses;
}
