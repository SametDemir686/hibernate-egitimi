package manytomany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "authorSet", fetch = FetchType.LAZY)
    private Set<Book> books = new HashSet<>();

    public Author(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        books.add(book);
        book.getAuthorSet().add(this);
    }
}
