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
	public Usuario getUsuarioById(Long idUsuario){
		Optional<Usuario> u = usuarioRepository.findById(idUsuario);
		Usuario usuario;
		if(u.isPresent()) usuario = u.get();
		else return null;
		return usuario;
	}

	public boolean addNewUsuario(Usuario usuario) {
		Optional<Usuario> usuarioByEmail = usuarioRepository.findUsuarioByEmail(usuario.getEmail());
		if(usuarioByEmail.isPresent()){
			return false;
		}
		usuarioRepository.save(usuario);
		return true;
	}

	public boolean modificarUsuario(Usuario usuario) {
		Optional<Usuario> usuarioByEmail = usuarioRepository.findUsuarioByEmail(usuario.getEmail());
		if(usuarioByEmail.isPresent() && usuario.getIduser() != usuarioByEmail.get().getIduser()){
			return false;
		}
		usuarioRepository.save(usuario);
		return true;
	}

    public void eliminarUsuario(Long usuarioId) {
		boolean existe = usuarioRepository.existsById(usuarioId);
		if(!existe){
			throw new IllegalStateException("Usuario con la ID: " + usuarioId + " no existe.");
		}
		usuarioRepository.deleteById(usuarioId);
    }
}
