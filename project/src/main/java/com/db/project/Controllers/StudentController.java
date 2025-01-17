package com.db.project.Controllers;

import com.db.project.Models.Student;
import com.db.project.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class StudentController {

    // Внедрение зависимости StudentRepository для работы с данными студентов
    @Autowired
    private StudentRepository studentRepository;

    // Метод для отображения страницы со списком студентов
    @GetMapping("/Student")
    public String getStudentPage(Model model) {
        Iterable<Student> student = studentRepository.findAll();
        model.addAttribute("Student", student);  // Добавляем студентов в модель для отображения на странице
        return "Student";  // Возвращаем страницу со студентами
    }

    // Метод для добавления нового студента
    @PostMapping("/Student")
    public String addStudent(@RequestParam String firstname,
                             @RequestParam String lastname,
                             @RequestParam String yearOfAdmission,
                             Model model) {

        // Создаем нового студента и сохраняем его в базе данных
        Student student = new Student(firstname, lastname, yearOfAdmission);
        studentRepository.save(student);
        return "redirect:/Student";  // Перенаправляем на страницу со списком студентов
    }




}
