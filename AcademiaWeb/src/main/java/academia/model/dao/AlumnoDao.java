package academia.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import academia.configuration.Configuracion;
import academia.model.entities.Alumno;
import academia.model.support.Dao;
import academia.model.support.DaoException;

public class AlumnoDao implements Dao<Long, Alumno> {

	private static final String CAMPOS = "nif,nombre,apellido1,apellido2,telefono,correo,repetidor,fechaalta,fechabaja,observaciones";

	@Override
	public void create(Alumno entity) throws DaoException {
		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			PreparedStatement p = co
					.prepareStatement("INSERT INTO ALUMNO(" + CAMPOS + ") VALUES (?,?,?,?,?,?,?,?,?,?) ");

			p.setString(1, entity.getNif());
			p.setString(2, entity.getNombre());
			p.setString(3, entity.getApellido1());
			p.setString(4, entity.getApellido2());
			p.setString(5, entity.getTlf());
			p.setString(6, entity.getCorreo());
			p.setBoolean(7, entity.getRepetidor());
			if (entity.getFechaAlta() != null) {
				p.setDate(8, new java.sql.Date(entity.getFechaAlta().getTime()));
			} else {
				p.setDate(8, null);
			}
			if (entity.getFechaBaja() != null) {
				p.setDate(9, new java.sql.Date(entity.getFechaBaja().getTime()));
			} else {
				p.setDate(9, null);
			}
			p.setString(10, entity.getObservaciones());
			p.executeUpdate();
			co.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}

	}

	@Override
	public void update(Alumno entity) throws DaoException {

		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			PreparedStatement p = co.prepareStatement("UPDATE ALUMNO" + " SET dni=?," + "nombre=?," + "apellido1=?,"
					+ "apellido2=?," + "telefono=?," + "correo=?," + "repetidor=?," + "fechaalta=?," + "fechabaja=?,"
					+ "observaciones=?  WHERE id=?;");

			p.setLong(11, entity.getId());
			p.setString(1, entity.getNif());
			p.setString(2, entity.getNombre());
			p.setString(3, entity.getApellido1());
			p.setString(4, entity.getApellido2());
			p.setString(5, entity.getTlf());
			p.setString(6, entity.getCorreo());
			p.setBoolean(7, entity.getRepetidor());
			p.setDate(8, new java.sql.Date(entity.getFechaAlta().getTime()));
			p.setDate(9, new java.sql.Date(entity.getFechaBaja().getTime()));
			p.setString(10, entity.getObservaciones());
			p.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error modificando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}

	}

	@Override
	public void delete(Long key) throws DaoException {
		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			PreparedStatement p = co.prepareStatement("DELETE FROM ALUMNO WHERE id=?");

			p.setLong(1, key);
			p.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error borrando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}

	}

	@Override
	public Alumno find(Long key) throws DaoException {
		Alumno alumno = null;
		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			String query = "SELECT id," + CAMPOS + " FROM ALUMNO WHERE id=?";
			PreparedStatement instruccion = co.prepareStatement(query);

			instruccion.setLong(1, key);
			ResultSet resultados = instruccion.executeQuery();
			if (resultados.next()) {
				alumno = obtenerAlumno(resultados);

			}
			co.close();
			return alumno;
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public List<Alumno> findAll() throws DaoException {
		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			Statement instruccion = co.createStatement();

			String query = "SELECT id," + CAMPOS + " FROM ALUMNO";
			ResultSet resultados = instruccion.executeQuery(query);

			ArrayList<Alumno> listado = new ArrayList<Alumno>();

			while (resultados.next()) {

				Alumno alumno = obtenerAlumno(resultados);

				listado.add(alumno);
			}

			co.close();
			return listado;
		} catch (Exception e) {
			System.out.println("Error creando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}
	}

	private Alumno obtenerAlumno(ResultSet resultado) throws SQLException {

		Long id = resultado.getLong(1);
		String nif = resultado.getString(2);
		String nombre = resultado.getString(3);
		String apellido1 = resultado.getString(4);
		String apellido2 = resultado.getString(5);
		String telefono = resultado.getString(6);
		String correo = resultado.getString(7);
		Boolean repetidor = resultado.getBoolean(8);
		Date fechaAlta = resultado.getDate(9);
		Date fechaBaja = resultado.getDate(10);
		String observaciones = resultado.getString(11);

		Alumno alumno = new Alumno();
		alumno.setId(id);
		alumno.setNif(nif);
		alumno.setNombre(nombre);
		alumno.setApellido1(apellido1);
		alumno.setApellido2(apellido2);
		alumno.setTlf(telefono);
		alumno.setCorreo(correo);
		alumno.setFechaAlta(fechaAlta);
		alumno.setFechaBaja(fechaBaja);
		alumno.setRepetidor(repetidor);
		alumno.setObservaciones(observaciones);

		return alumno;
	}

	public List<Alumno> findAlumnos(String patron) throws DaoException {

		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			Statement instruccion = co.createStatement();

			String query = "SELECT id," + CAMPOS + " FROM ALUMNO WHERE LOWER(nif) like LOWER('%" + patron
					+ "%') OR LOWER(nombre) like LOWER('%" + patron + "%') OR LOWER(apellido1) like LOWER('%" + patron
					+ "%')  OR LOWER(apellido2) like LOWER('%" + patron + "%') ;";
			ResultSet resultados = instruccion.executeQuery(query);

			ArrayList<Alumno> listado = new ArrayList<Alumno>();

			while (resultados.next()) {

				Alumno alumno = obtenerAlumno(resultados);

				listado.add(alumno);
			}

			co.close();
			return listado;
		} catch (Exception e) {
			System.out.println("Error creando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}
	}

}
