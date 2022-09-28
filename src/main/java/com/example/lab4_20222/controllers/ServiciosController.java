package com.example.lab4_20222.controllers;

import com.example.lab4_20222.entity.Servicio;
import com.example.lab4_20222.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @Autowired
    OpcionServicioRepository opcionServicioRepository;

    @GetMapping(value = {"/lista", ""})
    public String listarServicios(Model model) {
        List<Servicio> lista = servicioRepository.findAll();
        model.addAttribute("servicioLista", lista);
        model.addAttribute("listaOpServ", opcionServicioRepository.findAll());
        return "servicio/lista";
    }


    @GetMapping(value = "/crearserv")
    public String crearServ(Model model){
        model.addAttribute("listaOpcion", opcionRepository.findAll());
        model.addAttribute("listaMascotas", mascotaRepository.findAll());
        model.addAttribute("listaCuenta",cuentaRepository.findAll());
        model.addAttribute("listaResponsable", responsableRepository.findAll());
        return "/servicio/nuevo";
    }

    @PostMapping(value = "/guardarserv")
    public String guardarServ(Servicio servicio){
        servicioRepository.save(servicio);
        return "redirect:/servicio/lista";
    }

    @GetMapping(value = "/editar")
    public String editarServ(Model model, @RequestParam("id") String id){
        model.addAttribute("listaOpcion", opcionRepository.findAll());
        model.addAttribute("listaMascotas", mascotaRepository.findAll());
        model.addAttribute("listaCuenta",cuentaRepository.findAll());
        model.addAttribute("listaResponsable", responsableRepository.findAll());
        return "/servicio/editar";
    }



}
