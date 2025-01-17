package com.db.project.Controllers;

import com.db.project.Models.Speciality;
import com.db.project.repo.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class SpecialityController {

    // Внедрение зависимости SpecialityRepository для работы с данными студентов
    @Autowired
    private SpecialityRepository specialityRepository;

    // Метод для отображения страницы со списком студентов
    @GetMapping("/Speciality")
    public String getSpecialityPage(Model model) {
        Iterable<Speciality> speciality = specialityRepository.findAll();
        model.addAttribute("Speciality", speciality);
        return "Speciality";
    }

    // Метод для добавления нового студента
    @PostMapping("/Speciality")
    public String addSpeciality(@RequestParam String nameOfSpeciality,
                                @RequestParam String professor,
                                @RequestParam String duration,
                                Model model) {

        // Создаем нового студента и сохраняем его в базе данных
        Speciality speciality = new Speciality(nameOfSpeciality, professor, duration);
        specialityRepository.save(speciality);
        return "redirect:/Speciality";  // Перенаправляем на страницу со списком студентов
    }

}