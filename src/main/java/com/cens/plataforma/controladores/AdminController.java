package com.cens.plataforma.controladores;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cens.plataforma.empresa.Empresa;
import com.cens.plataforma.empresa.EmpresaService;
import com.cens.plataforma.logica_proceso.proceso_usuario_empresa.ProcesoUsuarioEmpresa;
import com.cens.plataforma.logica_proceso.proceso_usuario_empresa.ProcesoUsuarioEmpresaService;
import com.cens.plataforma.logica_proceso.tipo_proceso.TipoProceso;
import com.cens.plataforma.logica_proceso.tipo_proceso.TipoProcesoService;
import com.cens.plataforma.rol.RolService;
import com.cens.plataforma.usuario.Usuario;
import com.cens.plataforma.usuario.UsuarioService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyAuthority('Administrador')")
@AllArgsConstructor
public class AdminController {
    
    private final UsuarioService usuarioService;
    private final RolService rolService;
    private final EmpresaService empresaService;
    private final TipoProcesoService tipoProcesoService;
    private final ProcesoUsuarioEmpresaService procesoUsuarioEmpresaService;

    @GetMapping("ingresar-usuario")
    public String ingUsuarios(Model model){
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolService.getRolesNoAdmin());
        return "admin/usuario/ingresar_usuario";
	}

    @GetMapping("ingresar-empresa")
    public String ingEmpresa(Model model){
        Empresa empresa = new Empresa();
        List<ProcesoUsuarioEmpresa> pues = new ArrayList<ProcesoUsuarioEmpresa>();
        for(TipoProceso p: tipoProcesoService.getTipoProceso()){
			ProcesoUsuarioEmpresa pue = new ProcesoUsuarioEmpresa();
			pue.setTipoProceso(p);
			pues.add(pue);
		}
        empresa.setPUE(pues);
        model.addAttribute("empresa", empresa);
        List<Usuario> usuarios = usuarioService.getUsuarioByRol(rolService.getRolById(3L));
        model.addAttribute("usuarios", usuarios);
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

    @GetMapping("usuario")
	public String UsuariosTomar(Model model){
        model.addAttribute("usuarios", usuarioService.getUsuariosNoAdmin());
        model.addAttribute("roles", rolService.getRoles());
        return "admin/usuario/ver_usuario";
	}
    
    @PostMapping("usuario/mod")
    public String modificaUsuario(@ModelAttribute Usuario usuario, Model model){;  
        int error = 2;
        if(!usuarioService.modificarUsuario(usuario)){
            error = 1;
        }
        model.addAttribute("error", error);
        model.addAttribute("roles", rolService.getRolesNoAdmin());
        return "admin/usuario/modificar_usuario";
    }

    @PostMapping("usuario")
    public String registroUsuario(@ModelAttribute Usuario usuario, Model model){;  
        int error = 2;
        if(!usuarioService.addNewUsuario(usuario)){
            error = 1;
        }
        model.addAttribute("roles", rolService.getRolesNoAdmin());
        model.addAttribute("error", error);
        return "admin/usuario/ingresar_usuario";
    }

    @GetMapping(path = "usuario/del/{usuarioId}")
    public String eliminarUsuario(@PathVariable("usuarioId") Long usuarioId, Model model){
        model.addAttribute("usuarios", usuarioService.getUsuariosNoAdmin());
        model.addAttribute("roles", rolService.getRoles());
        usuarioService.eliminarUsuario(usuarioId);
        return "admin/usuario/ver_usuario";
    }

    @GetMapping("empresa")
    public String empresaTomar(Model model){
        model.addAttribute("empresas", empresaService.getEmpresas());
        return "admin/empresa/ver_empresa";
    }
    @PostMapping("empresa/mod")
    public String modificaEmpresa(@ModelAttribute Empresa empresa, Model model){;  
        int error = 2;
        if(!empresaService.modificarEmpresa(empresa)){
            error = 1;
        }
        model.addAttribute("error", error);
        return "admin/empresa/modificar_empresa";
    }
    @PostMapping("empresa")
    public String registroEmpresa(@ModelAttribute Empresa empresa, Model model){;
        int errors= 2;
        if(!empresaService.addNewEmpresa(empresa)){
            errors=1;
        }
        System.out.println("ELPEPEPEPEPE------------------------------------------------" + empresa.getPUE().size());
        // for(ProcesoUsuarioEmpresa p : pues) {
        //     p.setEmpresa(empresa);
        //     procesoUsuarioEmpresaService.addNewPUE(p);
        // }
        model.addAttribute("error", errors);
        return "admin/empresa/ingresar_empresa";
    }
    @GetMapping(path = "empresa/del/{idEmpresa}")
    public String eliminarEmpresa(@PathVariable("idEmpresa") Long idEmpresa, Model model){
        model.addAttribute("empresas", empresaService.getEmpresas());
        empresaService.eliminarEmpresa(idEmpresa);
        return "admin/empresa/ver_empresa";
    }
}