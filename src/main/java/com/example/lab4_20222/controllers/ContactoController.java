package com.example.lab4_20222.controllers;

import com.example.lab4_20222.repositories.CuentaRepository;
import com.example.lab4_20222.repositories.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactoController {
    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    CuentaRepository cuentaRepository;

    @GetMapping(value = {"", "/lista"})
    public String listaContacto(Model model){
        model.addAttribute("listaContacto", cuentaRepository.findAll());
        return "contacto/lista";
    }


}
