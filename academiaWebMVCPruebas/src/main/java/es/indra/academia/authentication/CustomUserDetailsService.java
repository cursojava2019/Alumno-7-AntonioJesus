package es.indra.academia.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import es.indra.academia.model.entities.Usuario;
import es.indra.academia.model.service.UsuarioService;

@Service("autenticacionService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usu = this.usuarioService.buscarUsuario(username);
		if (usu == null) {
			return null;
		}
		MyUserDetails user = new MyUserDetails(usu);
		return user;

	}

}
