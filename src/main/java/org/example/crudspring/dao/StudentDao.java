package org.example.crudspring.dao;

import org.example.crudspring.model.Student;
import java.util.List;


public interface StudentDao {

    void save(Student student);

    List<Student> findAll();

    Student findById(int id);

    void update(Student student);

    void delete(int id);
}
