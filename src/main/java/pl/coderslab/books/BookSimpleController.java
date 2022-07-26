package pl.coderslab.books;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorDao;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherDao;

import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookSimpleController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    @GetMapping("/create")
    public String createBook() {
        Publisher publisher = new Publisher("Helion");
        publisherDao.create(publisher);

        Author author1 = authorDao.findById(2L);
        Author author2 = authorDao.findById(3L);

        Book book = new Book("ksiazka z autorem", 10, "jkr");
        book.setPublisher(publisher);
        book.setAuthors(List.of(author1, author2));
        bookDao.create(book);
        return "book with publisher created";
    }

    @GetMapping("/get/{id}")
    public String bookById(@PathVariable Long id) {
        return bookDao.findById(id).toString();
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id) {
        Book byId = bookDao.findById(id);
        byId.setRating(9);
        bookDao.update(byId);
        return "book updated";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Book byId = bookDao.findById(id);
        bookDao.delete(byId);
        return "book deleted";
    }

    @GetMapping("/all")
    public String showAll() {
        bookDao.findAll()
                .forEach(b -> System.out.println(b.toString()));
        return "all";
    }

    @GetMapping("all/rating/{rating}")
    public String showAllWithRating(@PathVariable int rating) {
        bookDao.findAllByRating(rating)
                .forEach(b -> System.out.println(b.getTitle()));
        return "all-with-rating";
    }

    @GetMapping("all-with-author")
    public String showAllBooksWithAnyAuthor() {
        bookDao.findAllWithAnyAuthor()
                .forEach(b -> System.out.println(b));
        return "all-with-author";
    }

    @GetMapping("/all-with-publisher")
    public String showAllBooksWithPublisher(@RequestParam("publisher_id") long publisherId) {
        Publisher byId = publisherDao.findById(publisherId);
        bookDao.findAllWithPublisher(byId)
                .forEach(b -> System.out.println(b));
        return "all-with-publisher";
    }

    @GetMapping("/all-author")
    public String showAllBooksWithAuthor(@RequestParam("author_id") long authorId) {
        Author byId = authorDao.findById(authorId);
        bookDao.findAllWithAuthor(byId)
                .forEach(b -> System.out.println(b));
        return "all-author";
    }
}
