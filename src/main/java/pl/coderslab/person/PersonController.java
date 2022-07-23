package pl.coderslab.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.author.Author;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonDao personDao;

    @GetMapping("/create")
    public String createPerson() {
        PersonDetails personDetails = new PersonDetails(
                "ala", "alkowska", "1", "Ulica", "Miasto"
        );
        Person person = new Person("osoba", "pierwsza", "osoba@pl", personDetails);
        personDao.create(person);
        return "person created";
    }

    @GetMapping("/get/{id}")
    public String personById(@PathVariable Long id) {
        return personDao.findById(id).toString();
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id) {
        Person byId = personDao.findById(id);
        byId.setEmail("zmiana@pl");
        byId.getPersonDetails().setCity("Wroclaw");
        personDao.update(byId);
        return "person updated";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Person byId = personDao.findById(id);
        personDao.delete(byId);
        return "person deleted";
    }
}
