package ru.skypro.hogwarts29.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.hogwarts29.model.Student;
import ru.skypro.hogwarts29.service.StudentService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.unmodifiableCollection;

@Service
public class StudentServiceImpl implements StudentService {
    private final Map<Long, Student> repository = new HashMap<>();
    private long counter = 0;

    @Override
    public long add(Student student) {
        student.setId(++counter);
        repository.put(counter, student);
        return counter;
    }

    @Override
    public Student update(long id, Student student) {
        checkStudentExist(id);

        return repository.put(id, student);
    }

    @Override
    public Student deleteById(long id) {
        checkStudentExist(id);

        return repository.remove(id);
    }

    @Override
    public Student findById(long id) {
        return repository.get(id);
    }

    @Override
    public Collection<Student> findAll() {
        return unmodifiableCollection(repository.values());
    }

    private void checkStudentExist(long id) {
        if (!repository.containsKey(id)) {
            throw new RuntimeException(); //todo
        }
    }
}
