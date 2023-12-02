package com.cens.plataforma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cens.plataforma.usuario.Usuario;

@Controller
@RequestMapping("/")
public class HtmlController {
    
    @GetMapping
    public String home(){
        System.out.println("hola");
        return "home";
    }
    
    @GetMapping("ingusuario")
    public String getUsuarios(Model model){
        model.addAttribute("usuarioForma", new Usuario());
        return "ingresar_usuario";
	}
}
