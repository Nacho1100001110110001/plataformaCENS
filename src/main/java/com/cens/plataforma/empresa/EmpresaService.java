package com.cens.plataforma.empresa;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> getEmpresas(){
        return empresaRepository.findAll();
    }

    public Empresa getEmpresaById(Long idEmpresa){
 		Optional<Empresa> e = empresaRepository.findById(idEmpresa);
		Empresa empresa;
		if(e.isPresent()) empresa = e.get();
		else return null;
		return empresa;       
    }

    public boolean addNewEmpresa(Empresa empresa){
		Optional<Empresa> empresaByRut = empresaRepository.findEmpresaByRutEmpresa(empresa.getRutEmpresa());
		if(empresaByRut.isPresent()){
			return false;
		}
		empresaRepository.save(empresa);
		return true;        
    }

    public boolean modificarEmpresa(Empresa empresa){
		Optional<Empresa> empresaByRut = empresaRepository.findEmpresaByRutEmpresa(empresa.getRutEmpresa());
		if(empresaByRut.isPresent() && empresa.getIdEmpresa() != empresaByRut.get().getIdEmpresa()){
			System.out.println("Empresa encontrada: " + empresaByRut+ "\nEmpresa 1 id: "+ empresa.getIdEmpresa() + " Empresa 2 id: "+ empresaByRut.get().getIdEmpresa());
			return false;
		}
		empresaRepository.save(empresa);
		return true;
    }

    public void eliminarEmpresa(Long idEmpresa){
		boolean existe = empresaRepository.existsById(idEmpresa);
		if(!existe){
			throw new IllegalStateException("Empresa con la ID: " + idEmpresa + " no existe.");
		}
		empresaRepository.deleteById(idEmpresa);
    }
}
