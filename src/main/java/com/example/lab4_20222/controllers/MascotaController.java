package com.example.lab4_20222.controllers;

import com.example.lab4_20222.repositories.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    MascotaRepository mascotaRepository;

    @GetMapping(value = {"", "/lista"})
    public String listaMascota(Model model) {
        model.addAttribute("listaMascota", mascotaRepository.findAll());

        return "mascotas/lista_mascotas";
    }

}
