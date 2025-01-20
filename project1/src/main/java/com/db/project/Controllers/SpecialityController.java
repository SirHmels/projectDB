package com.db.project.Controllers;

import com.db.project.Models.Speciality;
import com.db.project.repo.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class SpecialityController {

    @Autowired
    private SpecialityRepository specialityRepository;

    @GetMapping("/Speciality")
    public String getSpecialityPage(Model model) {
        Iterable<Speciality> speciality = specialityRepository.findAll();
        model.addAttribute("Speciality", speciality);
        return "Speciality";
    }

    @PostMapping("/Speciality")
    public String addSpeciality(@RequestParam String nameOfSpeciality,
                                @RequestParam String professor,
                                @RequestParam String duration,
                                Model model) {

        Speciality speciality = new Speciality(nameOfSpeciality, professor, duration);
        specialityRepository.save(speciality);
        return "redirect:/Speciality";
    }

    @GetMapping("/Speciality/delete/{id}")
    public String deleteSpeciality(@PathVariable long id) {
        specialityRepository.deleteById(id);
        return "redirect:/Speciality";
    }

}