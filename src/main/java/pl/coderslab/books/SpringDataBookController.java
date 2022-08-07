package pl.coderslab.books;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/spring-data/book")
@Controller
public class SpringDataBookController {

    private final BookRepository bookRepository;

    @Transactional
    @GetMapping
    public String getBookByCategory(@RequestParam(value = "category-name", required = false)
                                    Optional<String> categoryName) {


        return categoryName
                .map(bookRepository::findByCategoryName)
                .map(s -> s.toString())
                .orElse("Brak");
    }

    @GetMapping("/query")
    @ResponseBody
    public String testQuery(@RequestParam("title") String title) {
        return bookRepository.findByTitleQuery(title).toString();
    }

    @GetMapping("/big-query")
    @ResponseBody
    public String testBigQuery() {

        return bookRepository.findByTitleDescriptionPublisherAndAuthor(
                "aaaa", "wewewe", "Helion", "Adam", "Mickiewicz"
                ).toString();
    }
}
