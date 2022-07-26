package pl.coderslab.books;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.AuthorDao;
import pl.coderslab.publisher.PublisherDao;

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
    @ResponseBody
    public String addBook(@ModelAttribute Book book) {
        bookDao.create(book);
        return "OK";
    }
}
