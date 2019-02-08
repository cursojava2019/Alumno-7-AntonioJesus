package es.indra.academia.model.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import es.indra.academia.model.entities.Usuario;
import es.indra.academia.model.support.Dao;
import es.indra.academia.model.support.DaoException;

@Repository
public class UsuarioDao implements Dao<Long, Usuario> {

	private HashMap<String, Usuario> listado = new HashMap<String, Usuario>();

	@PostConstruct
	void init() {
		Usuario usuario = new Usuario();
		usuario.setId(new Long(1));
		usuario.setUsuario("usuario1");
		usuario.setClave("password1");
		usuario.setHabilitado(true);
		usuario.setPermisos("ALUMNOS");
		this.listado.put("usuario1", usuario);

		usuario = new Usuario();
		usuario.setId(new Long(2));
		usuario.setUsuario("usuario2");
		usuario.setClave("password2");
		usuario.setHabilitado(true);
		usuario.setPermisos("PROFESORES");
		this.listado.put("usuario2", usuario);

		usuario = new Usuario();
		usuario.setId(new Long(3));
		usuario.setUsuario("usuario3");
		usuario.setClave("password3");
		usuario.setHabilitado(true);
		usuario.setPermisos("ALUMNOS;PROFESORES");
		this.listado.put("usuario3", usuario);
	}

	@Override
	public void create(Usuario entity) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Usuario entity) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long key) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario find(Long key) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario buscarUsuario(String key) throws DaoException {

		return this.listado.get(key);
	}

}