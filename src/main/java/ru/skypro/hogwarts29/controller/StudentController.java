package ru.skypro.hogwarts29.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.hogwarts29.model.Student;
import ru.skypro.hogwarts29.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public long add(@RequestBody Student student) {
        return studentService.add(student);
    }

    @PutMapping("/{id}/update")
    public Student update(@PathVariable("id") long id,
                          @RequestBody Student student) {
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}/remove")
    public Student deleteById(@PathVariable("id") long id) {
        return studentService.deleteById(id);
    }

    @GetMapping("/{id}/get")
    public Student findById(@PathVariable("id") long id) {
        return studentService.findById(id);
    }

    @GetMapping("/get/all")
    public Collection<Student> findAll() {
        return studentService.findAll();
    }
}
