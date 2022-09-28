package com.example.lab4_20222.controllers;

import com.example.lab4_20222.entity.Cuenta;
import com.example.lab4_20222.repositories.CuentaRepository;
import com.example.lab4_20222.repositories.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ContactoController {
    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    CuentaRepository cuentaRepository;

    @GetMapping(value = {"", "/lista"})
    public String listaContacto(Model model) {
        model.addAttribute("listaContacto", cuentaRepository.findAll());
        return "contacto/lista";
    }




    @GetMapping("/new")
    public String newContactoForm(Model model) {

        return "contacto/newForm";
    }


    @GetMapping("/editar")
    public String editContacto(@ModelAttribute("contacto") Cuenta contacto,
                                 @RequestParam("id") int id,
                                 Model model) {
        Optional<Cuenta> optcontacto = cuentaRepository.findById(id);

        if (optcontacto.isPresent()) {
            contacto = optcontacto.get();
            model.addAttribute("contacto", contacto);
            model.addAttribute("listaCuenta", cuentaRepository.findAll());
            return "/contacto/editar";
        } else {
            return "redirect:/contacto/lista";
        }
    }
    @PostMapping("/save")
    public String saveContacto(Cuenta contacto, RedirectAttributes attr, Model model) {

        if (contacto.getId() == 0) {
            attr.addFlashAttribute("msg", "Contacto creado exitosamente");
        } else {
            attr.addFlashAttribute("msg", "Contacto actualizado exitosamente");
        }

        if (contacto.getId() != null) {
            cuentaRepository.save(contacto);
            return "redirect:/mascota/lista";
        } else {
            model.addAttribute("errProd", "Error al guardar contacto");
            model.addAttribute("listaCuenta", cuentaRepository.findAll());
            if (contacto.getId() != 0) {
                model.addAttribute("contacto", contacto);
                return "contacto/editar";
            } else {
                return "contacto/newForm";
            }
        }

    }




}
