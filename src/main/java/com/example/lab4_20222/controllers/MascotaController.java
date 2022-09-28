package com.example.lab4_20222.controllers;

import com.example.lab4_20222.entity.Mascota;
import com.example.lab4_20222.repositories.MascotaRepository;
import com.example.lab4_20222.repositories.RazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

        return "mascota/lista";
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


    @PostMapping("/save")
    public String guardarMascota(Mascota mascota, RedirectAttributes attr, Model model) {

        if (mascota.getIdmascota() == 0) {
            attr.addFlashAttribute("msg", "Mascota creada exitosamente");
        } else {
            attr.addFlashAttribute("msg", "Mascota actualizada exitosamente");
        }
        if (mascota.getRaza_especie() != null) {
            mascotaRepository.save(mascota);
            return "redirect:/mascota/lista";
        } else {
            model.addAttribute("errProd", "Error al crear producto");
            model.addAttribute("listaMascota", mascotaRepository.findAll());
            model.addAttribute("listaRaza", razaRepository.findAll());
            if (mascota.getIdmascota() != 0) {
                model.addAttribute("mascota", mascota);
                return "mascota/editar";
            } else {
                return "mascota/form";
            }
        }

    }

    @GetMapping("/delete")
    public String borrarMascota(Model model,
                                @RequestParam("id") int id,
                                RedirectAttributes attr) {

        Optional<Mascota> optMascota = mascotaRepository.findById(id);

        if (optMascota.isPresent()) {
            mascotaRepository.deleteById(id);
            attr.addFlashAttribute("msg","Mascota borrado exitosamente");
        }
        return "redirect:/mascota/lista";
    }



}
