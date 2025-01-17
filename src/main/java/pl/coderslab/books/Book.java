package pl.coderslab.books;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import pl.coderslab.author.Author;
import pl.coderslab.category.Category;
import pl.coderslab.publisher.Publisher;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString (exclude = {"id", "publisher", "authors"})
//@ToString
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Length(min = 5)
    private String title;

    @Range(min = 1, max = 10)
    private Integer rating;
    @NotNull
    @Length(min = 10)
    private String description;

//    @NotNull
    @ManyToOne
    private Publisher publisher;

//    @NotEmpty
    @ManyToMany
    private List<Author> authors;

    @Min(2)
    private Integer pages;

    @ManyToOne
    private Category category;

    public Book(String title, int rating, String description) {
        this.title = title;
        this.rating = rating;
        this.description = description;
    }
}
