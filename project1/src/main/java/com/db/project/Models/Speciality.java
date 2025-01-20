package com.db.project.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Speciality")
public class  Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSpeciality")
    private Integer idSpeciality;

    @Column(name = "nameOfSpeciality", length = 30)
    private String nameOfSpeciality;

    @Column(name = "professor", length = 30)
    private String professor;

    @Column(name = "duration", length = 30)
    private String duration;

    public Speciality() {
    }

    public Speciality(String nameOfSpeciality, String professor, String duration) {
        this.nameOfSpeciality = nameOfSpeciality;
        this.professor = professor;
        this.duration = duration;
    }

    public Integer getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(Integer idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public String getNameOfSpeciality() {
        return nameOfSpeciality;
    }

    public void setNameOfSpeciality(String nameOfSpeciality) {
        this.nameOfSpeciality = nameOfSpeciality;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}

