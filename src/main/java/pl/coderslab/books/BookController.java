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
public class BookController {

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
        byId.setRacing(9);
        bookDao.update(byId);
        return "book updated";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Book byId = bookDao.findById(id);
        bookDao.delete(byId);
        return "book deleted";
    }
}
