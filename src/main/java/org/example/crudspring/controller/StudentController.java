package org.example.crudspring.controller;

import org.example.crudspring.model.Student;
import org.example.crudspring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Show Add Student Form
    @GetMapping("/addStudent")
    public String showAddStudentForm() {
        return "add-student";
    }

    // Save Student
    @PostMapping("/saveStudent")
    public String saveStudent(@RequestParam("name") String name,
                              @RequestParam("email") String email,
                              @RequestParam("course") String course) {

        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setCourse(course);

        studentService.addStudent(student);

        return "redirect:/students";
    }

    // List Students
    @GetMapping("/students")
    public String listStudents(Model model) {

        model.addAttribute("students",
                studentService.getAllStudents());

        return "list-students";
    }
    @GetMapping("/editStudent")
    public String editStudent(@RequestParam("id") int id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit-student";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(Student student) {
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("id") int id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

}
