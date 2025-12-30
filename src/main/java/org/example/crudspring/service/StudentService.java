package org.example.crudspring.service;

import org.example.crudspring.model.Student;
import java.util.List;


public interface StudentService {

    void addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int id);

    void updateStudent(Student student);

    void deleteStudent(int id);
}

