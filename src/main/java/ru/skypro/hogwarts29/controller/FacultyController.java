package ru.skypro.hogwarts29.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.hogwarts29.model.Faculty;
import ru.skypro.hogwarts29.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping("/add")
    public long add(@RequestBody Faculty faculty) {
        return facultyService.add(faculty);
    }

    @PutMapping("/{id}/update")
    public Faculty update(@PathVariable("id") long id,
                          @RequestBody Faculty faculty) {
        return facultyService.update(id, faculty);
    }

    @DeleteMapping("/{id}/remove")
    public Faculty deleteById(@PathVariable("id") long id) {
        return facultyService.deleteById(id);
    }

    @GetMapping("/{id}/get")
    public Faculty findById(@PathVariable("id") long id) {
        return facultyService.findById(id);
    }

    @GetMapping("/get/all")
    public Collection<Faculty> findAll() {
        return facultyService.findAll();
    }
}
