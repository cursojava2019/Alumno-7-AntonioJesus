package es.indra.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import es.indra.model.entities.Cliente;
import es.indra.model.support.Dao;
import es.indra.model.support.DaoException;
import es.indra.model.support.DatosConexion;

public class ClienteDao implements Dao<String, Cliente> {

	private Connection getConexion() throws SQLException {

		Connection co = DriverManager.getConnection(DatosConexion.URL, DatosConexion.USUARIO_BD,
				DatosConexion.PASSWORD_BD);
		return co;
	}

	@Override
	public void create(Cliente entity) throws DaoException {
		try {
			Connection co = getConexion();
			PreparedStatement ps = co.prepareStatement("INSERT INTO cliente VALUES (?,?,?,?,?) ");
			ps.setString(1, entity.getNombre());
			ps.setString(2, entity.getApellidos());
			ps.setString(3, entity.getDni());
			ps.setString(4, entity.getTln());
			ps.setString(5, entity.getDireccion());
			ps.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public void update(Cliente entity) throws DaoException {
		try {
			Connection co = getConexion();
			PreparedStatement ps = co
					.prepareStatement("UPDATE cliente SET nombre=?,apellidos=?, tlf=?, direccion=? where dni=? ");
			ps.setString(1, entity.getNombre());
			ps.setString(2, entity.getApellidos());

			ps.setString(4, entity.getTln());
			ps.setString(5, entity.getDireccion());
			ps.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error al modificar en la BBDD");
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public void delete(String key) throws DaoException {

	}

	@Override
	public Cliente find(String key) throws DaoException {
		Cliente cliente = null;
		try {
			Connection co = getConexion();
			String query = "SELECT * FROM Cliente WHERE dni=?";
			PreparedStatement instruccion = co.prepareStatement(query);

			instruccion.setString(3, key);
			ResultSet resultados = instruccion.executeQuery();
			if (resultados.next()) {
				cliente = obtenerCliente(resultados);
			}
			co.close();
			return cliente;
		} catch (SQLException e) {
			System.out.println("Error en Busqueda del objeto en BBDD");
			throw new DaoException();
		}
	}

	@Override
	public List<Cliente> findAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	protected static Cliente obtenerCliente(ResultSet resultado) throws SQLException {
		String nombre = resultado.getString(1);
		String apellidos = resultado.getString(2);
		String dni = resultado.getString(3);
		String tlf = resultado.getString(4);
		String direccion = resultado.getString(5);
		Cliente cliente = new Cliente(nombre, apellidos, dni, tlf, direccion);
		return cliente;
	}

}
