package com.example.lab4_20222.controllers;

import com.example.lab4_20222.entity.Mascota;
import com.example.lab4_20222.repositories.MascotaRepository;
import com.example.lab4_20222.repositories.RazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.Scanner;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    MascotaRepository mascotaRepository;
    @Autowired
    RazaRepository razaRepository;
    @GetMapping(value = {"", "/lista"})
    public String listaMascota(Model model) {
        model.addAttribute("listaMascota", mascotaRepository.findAll());

        return "mascotas/lista_mascotas";
    }

    @GetMapping("/new")
    public String nuevoMascotaForm(@ModelAttribute("mascota") Mascota mascota, Model model) {
        model.addAttribute("listaMascota", mascotaRepository.findAll());
        model.addAttribute("listaRaza", razaRepository.findAll());

        return "mascota/form";
    }

    @GetMapping("/editar")
    public String editarMascota(@ModelAttribute("mascota") Mascota mascota,
                                @RequestParam("id") int id,
                                Model model) {
        Optional<Mascota> optionalMascota = mascotaRepository.findById(id);
        System.out.println(id);
        if (optionalMascota.isPresent()) {
            mascota = optionalMascota.get();
            model.addAttribute("mascota", mascota);
            model.addAttribute("listaMascota", mascotaRepository.findAll());
            model.addAttribute("listaRaza", razaRepository.findAll());
            return "/mascota/editar";
        } else {
            return "redirect:/mascota/lista";
        }
    }

}
