package com.cens.plataforma.usuario;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PreAuthorize("hasAuthority('Administrador')")
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
    public String registroUsuario(@ModelAttribute Usuario usuario, Model model){;  
        int error = 2;
        if(!usuarioService.addNewUsuario(usuario)){
            error = 1;
        }
        model.addAttribute("roles", rolService.getRolesNoAdmin());
        model.addAttribute("error", error);
        return "admin/usuario/ingresar_usuario";
    }

    // @DeleteMapping()
    // public String eliminarUsuario(){
    //     System.out.println("el pepe");
    //     //usuarioService.eliminarUsuario(usuarioId);
    //     return "admin/usuario/ver_usuario";
    // }

    @GetMapping(path = "/del/{usuarioId}")
    @PreAuthorize("hasAnyAuthority('Administrador')")
    public String eliminarUsuario(@PathVariable("usuarioId") Long usuarioId, Model model){
        model.addAttribute("usuarios", usuarioService.getUsuariosNoAdmin());
        model.addAttribute("roles", rolService.getRoles());
        usuarioService.eliminarUsuario(usuarioId);
        return "admin/usuario/ver_usuario";
    }
}