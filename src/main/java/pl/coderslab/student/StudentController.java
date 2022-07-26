package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    //jest to slabe rozwiazanie pod tym wzgledem, ze ModelAttribute laduje sie
    // przed wywolaniem kazdego controllera

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return List.of("rower", "taniec", "joga");
    }

    @ModelAttribute("genders")
    public List<String> genders() {
        return List.of(Gender.MALE.name(), Gender.FEMALE.name());
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return List.of("Polska", "Czechy", "Francja", "USA");
    }

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return List.of("java", "sql", "hibernate", "postman", "docker");
    }

    @GetMapping("/add")
    public String add(Model model) {
        Student student = new Student();
        student.setFirstName("kama");
        student.setLastName("zet");
        model.addAttribute("student", student);
        return "student/add";
    }

    @PostMapping("/add")
    public String save(Student student, Model model) {
        model.addAttribute("student", student);
        return "student/save";
    }

    @GetMapping("/add-student-dto")
    public String addStudentDto(Model model) {
        StudentDto studentDto = new StudentDto();
        model.addAttribute("studentDto", studentDto);
        return "student/add-student-dto";
    }

    @PostMapping("/add-student-dto")
    @ResponseBody
    public String addAndShowStudentDto(@ModelAttribute StudentDto studentDto) {
        return studentDto.toString();
    }
}
