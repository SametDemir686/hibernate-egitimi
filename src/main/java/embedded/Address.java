package embedded;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
public class Address {
    private String zipcode;
    private String street;
    private String city;

    public Address(String zipcode, String street, String city) {
        this.zipcode = zipcode;
        this.street = street;
        this.city = city;
    }
}
