package com.example.lab4_20222.controllers;

import com.example.lab4_20222.entity.Servicio;
import com.example.lab4_20222.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


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
    @Autowired
    ServicioRepository servicioRepository;

    @GetMapping(value = {"/lista", ""})
    public String listarServicios(Model model) {
        List<Servicio> lista = servicioRepository.findAll();
        model.addAttribute("servicioLista", lista);
        model.addAttribute("listaOpServ", opcionRepository.findAll());
        return "servicio/lista";
    }


    @GetMapping(value = "/guardarserv")
    public String crearServ(Model model){
        model.addAttribute("listaOpcion", opcionRepository.findAll());
        model.addAttribute("listaMascotas", mascotaRepository.findAll());
        model.addAttribute("listaCuenta",cuentaRepository.findAll());
        model.addAttribute("listaResponsable", responsableRepository.findAll());
        return "servicio_nuevo";
    }
}
