package com.generation.lojagames.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.lojagames.model.Usuario;
import com.generation.lojagames.repository.UsuarioRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	// implementação da Interface UserDetailsService, valida a existência de um usuário no sistema através do Banco de dados e retorna um Objeto da Classe UserDetailsImpl.A busca será feita através do atributo usuario (e-mail).
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Optional<Usuario> usuario = usuarioRepository.findByUsuario(userName);

		if (usuario.isPresent())
			return new UserDetailsImpl(usuario.get());
		else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
			
	}
}
