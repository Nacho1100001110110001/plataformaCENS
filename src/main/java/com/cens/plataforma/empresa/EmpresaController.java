package com.cens.plataforma.empresa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public String empresaTomar(Model model){
        model.addAttribute("empresas", empresaService.getEmpresas());
        return "admin/empresa/ver_empresa";
    }
    @PostMapping("/mod")
    public String modificaEmpresa(@ModelAttribute Empresa empresa, Model model){;  
        int error = 2;
        if(!empresaService.modificarEmpresa(empresa)){
            error = 1;
        }
        model.addAttribute("error", error);
        return "admin/empresa/modificar_empresa";
    }
    @PostMapping
    public String registroEmpresa(@ModelAttribute Empresa empresa, Model model){;
        int error= 2;
        if(!empresaService.addNewEmpresa(empresa)){
            error=1;
        }
        model.addAttribute("error", error);
        return "admin/empresa/ingresar_empresa";
    }
    @DeleteMapping(path = "{idEmpresa}")
    public String eliminarUsuario(@PathVariable("idEmpresa") Long idEmpresa){
        empresaService.eliminarEmpresa(idEmpresa);
        return "admin/empresa/ver_empresa";
    }
}
