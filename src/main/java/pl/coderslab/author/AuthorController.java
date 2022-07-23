package pl.coderslab.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {

    private final AuthorDao authorDao;

    @GetMapping("/create")
    public String createAuthor() {
        Author author = Author.builder()
                .firstName("Ala")
                .lastName("Lala")
                .build();
        authorDao.create(author);
        return "author created";
    }

    @GetMapping("/get/{id}")
    public String bookById(@PathVariable Long id) {
        return authorDao.findById(id).toString();
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id) {
        Author byId = authorDao.findById(id);
        byId.setLastName("tralallala");
        authorDao.update(byId);
        return "author updated";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Author byId = authorDao.findById(id);
        authorDao.delete(byId);
        return "author deleted";
    }
}
