package com.cens.plataforma.controladores;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;


@Controller
@RequestMapping("/")
@AllArgsConstructor
public class LoginController {
    

    @GetMapping
    public String home(Authentication usuario){
        if(usuario != null){
            String autoridad = usuario.getAuthorities().iterator().next().getAuthority();
            if(autoridad.equals("Administrador")) return "admin/home";
        }
        return "home";
    }
}
