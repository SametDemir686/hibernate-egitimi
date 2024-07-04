package ornek3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Map;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "product_codes", joinColumns = @JoinColumn(name = "product_id"))
    @MapKeyColumn(name = "product_name")
    @Column(name = "product_code")
    private Map<String, String> productCodes;
}
