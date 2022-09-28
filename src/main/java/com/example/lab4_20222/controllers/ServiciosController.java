package com.example.lab4_20222.controllers;

import com.example.lab4_20222.repositories.CuentaRepository;
import com.example.lab4_20222.repositories.MascotaRepository;
import com.example.lab4_20222.repositories.OpcionRepository;
import com.example.lab4_20222.repositories.ResponsableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/servicio")
public class ServiciosController {
    @Autowired
    OpcionRepository opcionRepository;
    @Autowired
    MascotaRepository mascotaRepository;
    @Autowired
    CuentaRepository cuentaRepository;
    @Autowired
    ResponsableRepository responsableRepository;

    @GetMapping(value = "/guardarserv")
    public String crearServ(Model model){
        model.addAttribute("listaOpcion", opcionRepository.findAll());
        model.addAttribute("listaMascotas", mascotaRepository.findAll());
        model.addAttribute("listaCuenta",cuentaRepository.findAll());
        model.addAttribute("listaResponsable", responsableRepository.findAll());
        return "servicio_nuevo";
    }
}
