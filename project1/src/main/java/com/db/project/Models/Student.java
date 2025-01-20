package com.db.project.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Student")
public class Student {

    // Идентификатор студента (Primary Key).
    // Значение генерируется автоматически.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idStudent")
    private Integer idStudent;

    @NotBlank(message = "Имя не может быть пустым")
    @Column(name = "firstname",nullable = false, length = 30)
    private String firstname;

    @NotBlank(message = "Фамилия не может быть пустой")
    @Column(name = "lastname",nullable = false, length = 30)
    private String lastname;

    @NotNull(message = "Год поступления не может быть пустым")
    @Column(name = "yearOfAdmission",nullable = false, length = 30)
    private String yearOfAdmission;



    // Конструкторы

    // Конструктор без параметров для создания пустого объекта.
    public Student() {
    }

    public Student(String firstname, String lastname, String yearOfAdmission) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.yearOfAdmission = yearOfAdmission;
    }


    // Геттеры и сеттеры


    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getYearOfAdmission() {
        return yearOfAdmission;
    }

    public void setYearOfAdmission(String yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission;
    }
}

