package org.example.crudspring.service;

import org.example.crudspring.dao.StudentDao;
import org.example.crudspring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public void addStudent(Student student) {
        studentDao.save(student);
    }
    @Override
    public Student getStudentById(int id) {
        return studentDao.findById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.update(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentDao.delete(id);
    }
    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }
}
