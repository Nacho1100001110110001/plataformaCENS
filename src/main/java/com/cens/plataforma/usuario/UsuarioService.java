package com.cens.plataforma.usuario;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> getUsuarios(){
		return usuarioRepository.findAll();
	}

	public void addNewUsuario(Usuario usuario) {
		Optional<Usuario> usuarioByEmail = usuarioRepository.findUsuarioByEmail(usuario.getEmail());
		if(usuarioByEmail.isPresent()){
			throw new IllegalStateException("Email ya ocupado");
		}
		usuarioRepository.save(usuario);
	}

    public void eliminarUsuario(Long usuarioId) {
		boolean existe = usuarioRepository.existsById(usuarioId);
		if(!existe){
			throw new IllegalStateException("Usuario con la ID: " + usuarioId + " no existe.");
		}
		usuarioRepository.deleteById(usuarioId);
    }
}
