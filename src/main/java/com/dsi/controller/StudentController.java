package com.dsi.controller;

import com.dsi.entity.Student;
import com.dsi.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


/**
 * Created by A.A.MAMUN on 7/19/2020.
 */
@Controller
public class StudentController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @GetMapping({"/", "display"})
    public String displayAll(Model model){
        model.addAttribute("students", studentService.fetchStudent());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("student", new Student());
        return "add_student";
    }

    @PostMapping("/add_student")
    public String addStudent(@Valid Student student, Errors errors){
        if(errors.hasErrors()){
            LOGGER.error("TOTAL Error : "+errors.getErrorCount());
            for(ObjectError error : errors.getAllErrors()){
                LOGGER.error("ERR -> obj_name :"+error.getObjectName()+", mgs : "+error.getDefaultMessage());
            }
            return "add_student";
        }

        LOGGER.info("STUDENT : "+student.toString());

        studentService.addStudent(student);
        return "redirect:/display";
    }

    @RequestMapping("/edit")
    public String editStudent(@RequestParam int sid, Model model){
        model.addAttribute("student", studentService.getStudentById(sid));
        return "add_student";
    }

    @RequestMapping("/delete")
    public String deleteStudent(@RequestParam int sid){
        studentService.deleteStudentById(sid);
        return "redirect:/display";
    }
}
