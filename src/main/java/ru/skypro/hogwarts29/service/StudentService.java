package ru.skypro.hogwarts29.service;

import ru.skypro.hogwarts29.model.Student;

import java.util.Collection;

public interface StudentService {
    long add(Student faculty);

    Student update(long id, Student faculty);

    Student deleteById(long id);

    Student findById(long id);

    Collection<Student> findAll();
}
