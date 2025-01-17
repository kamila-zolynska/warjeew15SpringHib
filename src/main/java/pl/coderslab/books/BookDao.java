package pl.coderslab.books;

import org.springframework.stereotype.Repository;
import pl.coderslab.author.Author;
import pl.coderslab.publisher.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Book book) {
        entityManager.persist(book);
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }

    public List<Book> findAll() {
        return entityManager.createQuery("select b from Book b")
                .getResultList();
    }

    public List<Book> findAllByRating(int rating) {
        return entityManager.createQuery("select b from Book b where b.rating = :score")
                .setParameter("score", rating)
                .getResultList();
    }

    public List<Book> findAllWithAnyAuthor() {
        return entityManager.createQuery("select distinct b from Book b join b.authors")
                .getResultList();
    }

    public List<Book> findAllWithPublisher(Publisher publisher) {
        return entityManager
                .createQuery("select b from Book b where b.publisher = :publ")
                .setParameter("publ", publisher)
                .getResultList();
    }

    public List<Book> findAllWithAuthor(Author author) {
        return entityManager
                .createQuery("select b from Book b where :author member of b.authors")
                .setParameter("author", author)
                .getResultList();
    }
}
