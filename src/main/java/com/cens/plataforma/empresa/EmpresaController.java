package com.cens.plataforma.empresa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "empresa/ver_empresa";
    }

    @PostMapping
    public String registroEmpresa(@ModelAttribute Empresa empresa, Model model){
        int error= 2;
        if(!empresaService.addNewEmpresa(empresa)){
            error=1;
        }
        model.addAttribute("error", error);
        return "empresa/ingresar_empresa";
    }
}
