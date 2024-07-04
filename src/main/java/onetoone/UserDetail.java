package onetoone;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class UserDetail {
    @Id
    @GeneratedValue
    private Long id;

    private String email;
    private String address;
    private String number;

    @OneToOne
    private User user;

    public UserDetail(String email, String address, String number) {
        this.email = email;
        this.address = address;
        this.number = number;
    }
}
