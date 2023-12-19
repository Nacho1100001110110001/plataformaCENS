package com.cens.plataforma.empresa;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.cens.plataforma.logica_proceso.nota_proceso.NotaProceso;
import com.cens.plataforma.logica_proceso.nota_proceso.NotaProcesoService;
import com.cens.plataforma.logica_proceso.proceso.Proceso;
import com.cens.plataforma.logica_proceso.proceso.ProcesoService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmpresaService {
    private final EmpresaRepository empresaRepository;
	private final NotaProcesoService notaProcesoService;
	private final ProcesoService procesoService;

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
		for(Proceso p : procesoService.getProcesos()){
			NotaProceso n = new NotaProceso();
			n.setEmpresa(empresa);
			n.setProceso(p);
			notaProcesoService.addNewNotaProceso(n);
		}

		return true;        
    }

    public boolean modificarEmpresa(Empresa empresa){
		Optional<Empresa> empresaByRut = empresaRepository.findEmpresaByRutEmpresa(empresa.getRutEmpresa());
		if(empresaByRut.isPresent() && empresa.getIdEmpresa() != empresaByRut.get().getIdEmpresa()){
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
		notaProcesoService.deleteByIdEmpresa(idEmpresa);
		empresaRepository.deleteById(idEmpresa);
    }
}
