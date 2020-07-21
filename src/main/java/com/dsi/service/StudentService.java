package com.dsi.service;

import com.dsi.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by A.A.MAMUN on 7/19/2020.
 */
@Service
public interface StudentService {

    List<Student> fetchStudent();

    void addStudent(Student student);

    void deleteStudentById(int sid);

    void deleteStudent(Student student);

    Student getStudentById(int sid);

}
