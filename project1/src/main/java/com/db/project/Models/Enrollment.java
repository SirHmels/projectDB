package com.db.project.Models;

import jakarta.persistence.*;


@Entity
@Table(name = "Enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idStudent", referencedColumnName = "idStudent")
    private Student Student;

    @ManyToOne
    @JoinColumn(name = "idSpeciality", referencedColumnName = "idSpeciality")
    private Speciality Speciality;

    @Column(name = "status")
    private String status;


    public Enrollment() {
    }

    public Enrollment(Student idStudent,
                      Speciality idSpeciality,
                      String status) {
        this.Student = idStudent;
        this.Speciality = idSpeciality;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return Student;
    }

    public void setStudent(Student student) {
        Student = student;
    }

    public Speciality getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(Speciality speciality) {
        Speciality = speciality;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}