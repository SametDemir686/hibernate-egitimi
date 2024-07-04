package embedded;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "\"user_\"")
public class User_ {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Embedded
    private Address address;
}
