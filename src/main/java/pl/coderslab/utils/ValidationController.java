package pl.coderslab.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.author.Author;
import pl.coderslab.books.Book;
import pl.coderslab.publisher.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/validate")
public class ValidationController {

    private final Validator validator;

    @ResponseBody
    @GetMapping
    public String validate() {
        Book book = new Book();
        Set<ConstraintViolation<Book>> validationResult = validator.validate(book);

        if (!validationResult.isEmpty()) {
            validationResult.forEach(violation ->
                    System.out.println(violation.getPropertyPath() + ", " + violation.getMessage()));
        }
        return validationResult.stream()
                .map(v -> v.getPropertyPath() + ": " + v.getMessage())
                .collect(Collectors.joining("; "));
    }

    @GetMapping("/info")
    public String validateInfo(Model model) {
        Book book = Book.builder()
                .title("aa")
                .rating(11)
                .description("Fajna")
                .publisher(new Publisher())
                .authors(List.of(new Author()))
                .pages(1)
                .build();

        Set<ConstraintViolation<Book>> validationResult = validator.validate(book);

        model.addAttribute("validator", validationResult);

        return "book/validate";
    }
}
