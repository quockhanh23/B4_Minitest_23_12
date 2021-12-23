package controller;

import model.Classes;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.ClassesServiceImpl;
import service.StudentServiceImpl;

import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private ClassesServiceImpl classesService;

    @ModelAttribute("classes")
    public Iterable<Classes> categories() {
        return classesService.findAll();
    }

    @GetMapping("")
    public String showList(Model model, String search) {
        Iterable<Student> students;
        if (search == null) {
            students = studentService.findAll();
        } else {
            students = studentService.findByNameContaining(search);
        }
        model.addAttribute("list", students);
        return "/list";
    }

    @GetMapping("/sort")
    public String showSort1(Model model, String search) {
        Iterable<Student> students;
        if (search == null) {
            students = studentService.findAllByOrderByScoreDesc();

        } else {
            students = studentService.findByNameContaining(search);
        }
        model.addAttribute("list", students);
        return "/list";
    }

    @GetMapping("/sort2")
    public String showSort2(Model model, String search) {
        Iterable<Student> students;
        if (search == null) {
            students = studentService.findAllByOrderByScoreAsc();
        } else {
            students = studentService.findByNameContaining(search);
        }
        model.addAttribute("list", students);
        return "/list";
    }

    @GetMapping("/edit-student/{id}")
    public String showEdit(@PathVariable Long id, Model model) {
        Optional<Student> student = studentService.findById(id);
        Student student1 = student.get();
        model.addAttribute("edit", student1);
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(Student student) {
        studentService.save(student);
        return "redirect:/student";
    }
}
