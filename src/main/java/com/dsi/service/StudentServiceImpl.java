package com.dsi.service;

import com.dsi.entity.Student;
import com.dsi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by A.A.MAMUN on 7/19/2020.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> fetchStudent() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(int sid) {
        studentRepository.deleteById(sid);
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public Student getStudentById(int sid) {
        return studentRepository.findById(sid).get();
    }
}
