package pl.coderslab.books;

import lombok.*;
import pl.coderslab.author.Author;
import pl.coderslab.publisher.Publisher;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString (exclude = {"id"})
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int racing;
    private String description;
    @ManyToOne
    private Publisher publisher;
    @ManyToMany
    private List<Author> authors;

    public Book(String title, int racing, String description) {
        this.title = title;
        this.racing = racing;
        this.description = description;
    }
}
