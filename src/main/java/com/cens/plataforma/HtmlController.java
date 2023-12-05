package com.cens.plataforma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cens.plataforma.empresa.Empresa;
import com.cens.plataforma.rol.RolService;
import com.cens.plataforma.usuario.Usuario;
import com.cens.plataforma.usuario.UsuarioService;

@Controller
@RequestMapping("/")
public class HtmlController {
    private final RolService rolService;
    private final UsuarioService usuarioService;
    
    public HtmlController(RolService rolService, UsuarioService usuarioService) {
        this.rolService = rolService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String home(){
        System.out.println("hola");
        return "home";
    }
    
    @GetMapping("ingusuario")
    public String getUsuarios(Model model){
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolService.getRolesB());
        return "usuario/ingresar_usuario";
	}

    @GetMapping("ingempresa")
    public String ingEmpresa(Model model){
        model.addAttribute("empresa", new Empresa());
        return "empresa/ingresar_empresa";
    }
    @GetMapping(path = "modusuario/{usuarioId}")
    public String modificarUsuario(@PathVariable("usuarioId") Long usuarioId, Model model){
        model.addAttribute("usuario", usuarioService.getUsuarioById(usuarioId));
        model.addAttribute("roles", rolService.getRolesB());
        return "usuario/modificar_usuario";
    }
}
