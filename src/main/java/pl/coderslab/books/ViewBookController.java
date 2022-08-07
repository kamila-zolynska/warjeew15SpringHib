package pl.coderslab.books;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/errorBook")
public class ViewBookController {

    @GetMapping("/add")
    public String addBook(Model model) {

        model.addAttribute("book", new Book());
        return "book/errorBookForm";
    }

    @PostMapping("/add")
    public String postBook(@Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book/errorBookForm";
        }
        return "redirect:/book-form/list";
    }
}
