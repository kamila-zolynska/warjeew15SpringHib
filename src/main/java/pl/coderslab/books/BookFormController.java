package pl.coderslab.books;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import pl.coderslab.author.AuthorDao;
import pl.coderslab.publisher.PublisherDao;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book-form")
public class BookFormController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    @GetMapping("/add")
    public String addBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("publishers", publisherDao.findAll());
        model.addAttribute("authors", authorDao.findAll());
        return "book/form/add";
    }

    @PostMapping("/add")
    public RedirectView addBook(@ModelAttribute Book book) {
        bookDao.create(book);
        return new RedirectView("/book-form/list");
    }

    @GetMapping("/list")
    public String showAll(Model model) {
        List<Book> books = bookDao.findAll();
        model.addAttribute("books", books);
        return "book/form/list";
    }
}
