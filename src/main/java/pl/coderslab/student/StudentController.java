package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    //jest to slabe rozwiazanie pod tym wzgledem, ze ModelAttribute laduje sie
    // przed wywolaniem kazdego controllera
    @ModelAttribute("hobbies")
    public Collection<String> skills() {
        return List.of("rower", "taniec", "joga");
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
        studentDto.setProgrammingSkills(List.of("java", "hibernate", "sql"));
        model.addAttribute("studentDto", studentDto);
        return "student/add-student-dto";
    }
}
