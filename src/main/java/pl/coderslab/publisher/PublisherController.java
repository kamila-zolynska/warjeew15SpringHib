package pl.coderslab.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherDao publisherDao;

    @GetMapping("/create")
    public String createAuthor() {
        Publisher publisher = new Publisher();
        publisher.setName("publisher");
        publisherDao.create(publisher);
        return "publisher created";
    }

    @GetMapping("/get/{id}")
    public String publisherById(@PathVariable Long id) {
        return publisherDao.findById(id).toString();
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id) {
        Publisher byId = publisherDao.findById(id);
        byId.setName("publisher 102");
        publisherDao.update(byId);
        return "publisher updated";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Publisher byId = publisherDao.findById(id);
        publisherDao.delete(byId);
        return "publisher deleted";
    }
}
