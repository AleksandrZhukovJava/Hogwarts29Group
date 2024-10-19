package ru.skypro.hogwarts29.service;

import ru.skypro.hogwarts29.model.Faculty;

import java.util.Collection;

public interface FacultyService {
    long add(Faculty faculty);

    Faculty update(long id, Faculty faculty);

    Faculty deleteById(long id);

    Faculty findById(long id);

    Collection<Faculty> findAll();
}
