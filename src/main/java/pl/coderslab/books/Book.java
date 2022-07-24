package pl.coderslab.books;

import lombok.*;
import org.springframework.context.annotation.Lazy;
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
@ToString (exclude = {"id", "publisher", "authors"})
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int rating;
    private String description;
    @ManyToOne
    private Publisher publisher;
    @ManyToMany
    private List<Author> authors;

    public Book(String title, int rating, String description) {
        this.title = title;
        this.rating = rating;
        this.description = description;
    }
}
