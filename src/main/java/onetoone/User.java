package onetoone;

import embedded.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private UserDetail userDetail;

    public User(String name, UserDetail userDetail) {
        this.name = name;
        this.userDetail = userDetail;
    }
}
