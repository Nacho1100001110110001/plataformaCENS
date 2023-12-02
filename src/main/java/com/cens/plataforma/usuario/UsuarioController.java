package com.cens.plataforma.usuario;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    private final UsuarioService usuarioService;

    
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
	public String UsuariosTomar(Model model){
        model.addAttribute("usuarios", usuarioService.getUsuarios());
        return "ver_usuario";
	}

    @PostMapping
    public String registroUsuario(@ModelAttribute Usuario usuario){;  
        usuarioService.addNewUsuario(usuario);
        return "/home";
    }

    @DeleteMapping(path = "{usuarioId}")
    public String eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
        return "ver_usuario";
    }
}
