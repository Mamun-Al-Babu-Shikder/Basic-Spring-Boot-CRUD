package com.dsi.entity;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Created by A.A.MAMUN on 7/19/2020.
 */
@Entity
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "")
    private int sid;
    @NotEmpty(message = "Please enter name")
    private String name;
    @NotEmpty(message = "Enter full address")
    private String address;
    private String department;
    @Digits(integer = 2, fraction = 2)
    @DecimalMax(value = "4.0")
    @DecimalMin(value = "0.0")
    private float cgpa;

    public Student() {
    }

    public Student(String name, String address, String department, float cgpa) {
        this.name = name;
        this.address = address;
        this.department = department;
        this.cgpa = cgpa;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", department='" + department + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }
}
