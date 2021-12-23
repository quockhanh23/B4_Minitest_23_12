package service;

import model.Student;

public interface StudentService extends GeneralService<Student> {
    Iterable<Student> findAllByOrderByScoreDesc();
    Iterable<Student> findAllByOrderByScoreAsc();
    Iterable<Student> findByNameContaining(String name);
    Iterable<Student> findByName(String name);
}
