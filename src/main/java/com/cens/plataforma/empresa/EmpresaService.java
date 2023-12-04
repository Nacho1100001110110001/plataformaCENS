package com.cens.plataforma.empresa;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cens.plataforma.usuario.Usuario;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> getEmpresas(){
        return empresaRepository.findAll();
    }

    public Empresa getEmpresaByRut(String rutEmpresa){
 		Optional<Empresa> e = empresaRepository.findById(rutEmpresa);
		Empresa empresa;
		if(e.isPresent()) empresa = e.get();
		else return null;
		return empresa;       
    }

    public boolean addNewEmpresa(Empresa empresa){
		Optional<Empresa> empresaByEmail = empresaRepository.findEmpresaByEmail(empresa.getEmail());
		if(empresaByEmail.isPresent()){
			return false;
		}
		empresaRepository.save(empresa);
		return true;        
    }

    public boolean modificarEmpresa(Empresa empresa){
		Optional<Empresa> empresaByEmail = empresaRepository.findEmpresaByEmail(empresa.getEmail());
		if(empresaByEmail.isPresent() && empresa.getRutEmpresa() != empresaByEmail.get().getRutEmpresa()){
			return false;
		}
		empresaRepository.save(empresa);
		return true;
    }
    public void eliminarEmpresa(String rutEmpresa){
		boolean existe = empresaRepository.existsById(rutEmpresa);
		if(!existe){
			throw new IllegalStateException("Empresa con la ID: " + rutEmpresa + " no existe.");
		}
		empresaRepository.deleteById(rutEmpresa);
    }
}
