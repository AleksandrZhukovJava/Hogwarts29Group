package ru.skypro.hogwarts29.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.hogwarts29.model.Faculty;
import ru.skypro.hogwarts29.service.FacultyService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.unmodifiableCollection;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final Map<Long, Faculty> repository = new HashMap<>();
    private long counter = 0;

    @Override
    public long add(Faculty faculty) {
        faculty.setId(++counter);
        repository.put(counter, faculty);
        return counter;
    }

    @Override
    public Faculty update(long id, Faculty faculty) {
        checkFacultyExist(id);

        return repository.put(id, faculty);
    }

    @Override
    public Faculty deleteById(long id) {
        checkFacultyExist(id);

        return repository.remove(id);
    }

    @Override
    public Faculty findById(long id) {
        return repository.get(id);
    }

    @Override
    public Collection<Faculty> findAll() {
        return unmodifiableCollection(repository.values());
    }

    private void checkFacultyExist(long id) {
        if (!repository.containsKey(id)) {
            throw new RuntimeException(); //todo
        }
    }
}
