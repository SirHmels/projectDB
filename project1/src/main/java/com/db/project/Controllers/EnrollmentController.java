package com.db.project.Controllers;

import com.db.project.Models.Enrollment;
import com.db.project.Models.Student;
import com.db.project.Models.Speciality;
import com.db.project.repo.SpecialityRepository;
import com.db.project.repo.EnrollmentRepository;
import com.db.project.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SpecialityRepository specialityRepository;

    @GetMapping("/Enrollment")
    public String getEnrollmentPage(Model model) {
        Iterable<Enrollment> enrollment = enrollmentRepository.findAll();
        model.addAttribute("Enrollment", enrollment);

        Iterable<Student> student = studentRepository.findAll();
        Iterable<Speciality> speciality = specialityRepository.findAll();
        model.addAttribute("Student", student);
        model.addAttribute("Speciality", speciality);

        return "Enrollment";
    }

    @PostMapping("/Enrollment")
    public String addEnrollment(@RequestParam Long idStudent,
                                @RequestParam Long idSpeciality,
                                @RequestParam String status,
                                Model model) {

        Student Student = studentRepository.findById(idStudent).orElse(null);
        Speciality Speciality  = specialityRepository.findById(idSpeciality).orElse(null);

        if (Student != null) {
            Enrollment newEnrollment = new Enrollment();
            newEnrollment.setStudent(Student);
            newEnrollment.setSpeciality(Speciality);
            newEnrollment.setStatus(status);


            enrollmentRepository.save(newEnrollment);
        }

        return "redirect:/Enrollment";
    }

    @GetMapping("/enrollment/delete/{id}")
    public String deleteEnrollment(@PathVariable Long id) {
        enrollmentRepository.deleteById(id);
        return "redirect:/Enrollment";
    }

}