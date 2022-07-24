package pl.coderslab.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;

@Controller
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

    //todo: do sprawdzenia
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
        return "redirect:/person/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("people", personDao.findAll());
        return "person/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("person", new Person());
        return "person/add";
    }

    @PostMapping("/add")
    public String save(Person person) {
        personDao.create(person);
        return "redirect:/person/list";
    }

//    bez bindowania:
//    @PostMapping("/add")
//    public String save(Model model,
//                       @RequestParam String login,
//                       @RequestParam String password,
//                       @RequestParam String email) {
//        Person person = new Person();
//        person.setLogin(login);
//        person.setEmail(email);
//        person.setPassword(password);
//
//        personDao.create(person);
//        return "redirect:person/list";
//    }
}
