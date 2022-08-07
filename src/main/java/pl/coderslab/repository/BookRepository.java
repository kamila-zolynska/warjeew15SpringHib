package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.author.Author;
import pl.coderslab.books.Book;
import pl.coderslab.publisher.Publisher;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Set<Book> findByCategoryName(String categoryName);

    List<Book> findByTitle(String title);

    List<Book> findByCategoryId(Long categoryId);

    List<Book> findByAuthorsContaining(Author author);

    List<Book> findByPublisher(Publisher publisher);

    List<Book> findByRatingBetween(int from, int to);

    List<Book> findFirstByCategoryNameOrderByTitle(String categoryName);

    @Query("Select b from Book b where b.title = ?1")
    List<Book> findByTitleQuery(String title);

    @Query("Select b from Book b where b.category.name = ?1")
    List<Book> findByCategoryNameQuery(String name);

    @Query("Select b from Book b where b.rating between ?1 and ?2")
    List<Book> findByRatingBetweenQuery(int from, int to);

    @Query("Select b from Book b where b.publisher.id = ?1")
    List<Book> findByPublisherIdQuery(Long id);

    @Query("Select b from Book b where b.category.name = ?1 order by b.title")
    Book findFirstByCategoryOrderedByTitleQuery(String name);

    @Query("select b from Book b join fetch b.authors a where b.title = ?1 and b.description = ?2 and b.publisher.name = ?3 " +
            "and a.firstName = ?4 and a.lastName = ?5")
    List<Book> findByTitleDescriptionPublisherAndAuthor(String title, String description, String publisherName,
                                                        String authorFirstName, String authorLastName);
}
