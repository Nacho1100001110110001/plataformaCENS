package com.cens.plataforma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cens.plataforma.empresa.Empresa;
import com.cens.plataforma.empresa.EmpresaService;
import com.cens.plataforma.rol.RolService;
import com.cens.plataforma.usuario.Usuario;
import com.cens.plataforma.usuario.UsuarioService;

@Controller
@RequestMapping("/")
public class HtmlController {
    private final RolService rolService;
    private final UsuarioService usuarioService;
    private final EmpresaService empresaService;
    
    public HtmlController(RolService rolService, UsuarioService usuarioService, EmpresaService empresaService) {
        this.rolService = rolService;
        this.usuarioService = usuarioService;
        this.empresaService = empresaService;
    }

    @GetMapping
    public String home(){
        return "home";
    }
    
    @GetMapping("ingresar-usuario")
    public String getUsuarios(Model model){
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolService.getRolesNoAdmin());
        return "admin/usuario/ingresar_usuario";
	}

    @GetMapping("ingresar-empresa")
    public String ingEmpresa(Model model){
        model.addAttribute("empresa", new Empresa());
        return "admin/empresa/ingresar_empresa";
    }

    @GetMapping(path = "modificar-usuario/{usuarioId}")
    public String modificarUsuario(@PathVariable("usuarioId") Long usuarioId, Model model){
        model.addAttribute("usuario", usuarioService.getUsuarioById(usuarioId));
        model.addAttribute("roles", rolService.getRolesNoAdmin());
        return "admin/usuario/modificar_usuario";
    }

    @GetMapping(path = "modificar-empresa/{empresaId}")
    public String modificarEmpresa(@PathVariable("empresaId") Long empresaId, Model model){
        model.addAttribute("empresa", empresaService.getEmpresaById(empresaId));
        return "admin/empresa/modificar_empresa";
    }
}
