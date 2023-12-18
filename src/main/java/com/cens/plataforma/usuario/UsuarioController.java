package com.cens.plataforma.usuario;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cens.plataforma.rol.RolService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    private final UsuarioService usuarioService;
    private final RolService rolService;

    
    public UsuarioController(UsuarioService usuarioService, RolService rolService) {
        this.usuarioService = usuarioService;
        this.rolService = rolService;
    }

    @GetMapping
	public String UsuariosTomar(Model model){
        model.addAttribute("usuarios", usuarioService.getUsuariosNoAdmin());
        model.addAttribute("roles", rolService.getRoles());
        return "admin/usuario/ver_usuario";
	}
    
    @PostMapping("/mod")
    public String modificaUsuario(@ModelAttribute Usuario usuario, Model model){;  
        int error = 2;
        if(!usuarioService.modificarUsuario(usuario)){
            error = 1;
        }
        model.addAttribute("error", error);
        model.addAttribute("roles", rolService.getRolesNoAdmin());
        return "admin/usuario/modificar_usuario";
    }

    @PostMapping
    // public ResponseEntity<String> registroUsuario(@RequestBody Usuario usuario, Model model){;  
    //     System.out.println("Usuario chistoso: " + usuario);
    //     if(!usuarioService.addNewUsuario(usuario)){
    //         return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("Email ya ocupado lol.");
    //     }else{
    //         return ResponseEntity.ok("Usuario agregado con exito lol.");
    //     }
    // }
    public String registroUsuario(@ModelAttribute Usuario usuario, Model model){;  
        int error = 2;
        if(!usuarioService.addNewUsuario(usuario)){
            error = 1;
        }
        model.addAttribute("roles", rolService.getRolesNoAdmin());
        model.addAttribute("error", error);
        return "admin/usuario/ingresar_usuario";
    }

    @DeleteMapping(path = "{usuarioId}")
    public String eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
        return "admin/usuario/ver_usuario";
    }

    
}
