package ornek2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String title;

    @Transient
    private String content;

    @CreationTimestamp
    private LocalDateTime creationTs;

    @UpdateTimestamp
    private LocalDateTime updateTs;
}
