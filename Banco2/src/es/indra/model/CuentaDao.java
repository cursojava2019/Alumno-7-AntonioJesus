package es.indra.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import es.indra.model.entities.Cuenta;
import es.indra.model.entities.CuentaCC;
import es.indra.model.entities.CuentaCV;
import es.indra.model.entities.CuentaFI;
import es.indra.model.support.Dao;
import es.indra.model.support.DaoException;
import es.indra.model.support.DatosConexion;

public class CuentaDao implements Dao<Integer, Cuenta> {

	private Connection getConexion() throws SQLException {

		Connection co = DriverManager.getConnection(DatosConexion.URL, DatosConexion.USUARIO_BD,
				DatosConexion.PASSWORD_BD);
		return co;
	}

	@Override
	public void create(Cuenta entity) throws DaoException {
		try {

			Connection co = getConexion();
			PreparedStatement ps = co.prepareStatement("INSERT INTO Cuenta VALUES (?,?,?,?,?,?) ");
			ps.setInt(1, entity.getCodigo());
			System.out.println();

			ps.setDouble(2, entity.getSaldo());

			if (entity instanceof CuentaCC) {
				ps.setString(3, "C");
			} else if (entity instanceof CuentaCV) {
				ps.setString(3, "V");
			} else {
				ps.setString(3, "I");
			}

			ps.setString(4, entity.getDniCliente());

			ps.setInt(5, entity.getPing());
			ps.setBoolean(6, false);

			ps.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();

		}

	}

	@Override
	public void update(Cuenta entity) throws DaoException {
		try {
			Connection co = getConexion();
			PreparedStatement ps = co.prepareStatement("UPDATE Cuenta SET saldo=? where codigo=? ");
			ps.setDouble(1, entity.getSaldo());
			ps.setInt(2, entity.getCodigo());
			ps.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error al actualizar el objeto en BBDD");
			throw new DaoException();
		}

	}

	public void bloqueo(Integer key) throws DaoException {
		try {
			Connection co = getConexion();
			PreparedStatement ps = co.prepareStatement("UPDATE Cuenta SET bloqueo=? where codigo=? ");
			ps.setBoolean(6, true);
			ps.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error al bloquear el objeto en BBDD");
			throw new DaoException();
		}
	}

	public void desbloqueo(Integer key) throws DaoException {
		try {
			Connection co = getConexion();
			PreparedStatement ps = co.prepareStatement("UPDATE cuenta SET bloqueo=? where codigo=? ");
			ps.setBoolean(6, false);
			ps.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error al desbloquear el objeto en BBDD");
			throw new DaoException();
		}
	}

	@Override
	public void delete(Integer key) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Cuenta find(Integer key) throws DaoException {
		Cuenta cuenta = null;
		try {
			Connection co = getConexion();
			String query = "SELECT * FROM Cuenta WHERE codigo=?";
			PreparedStatement instruccion = co.prepareStatement(query);

			instruccion.setInt(1, key);
			ResultSet resultados = instruccion.executeQuery();
			if (resultados.next()) {
				cuenta = obtenerCuenta(resultados);
			}
			co.close();
			return cuenta;
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}
	}

	@Override
	public List<Cuenta> findAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	protected static Cuenta obtenerCuenta(ResultSet resultado) throws SQLException {
		Cuenta cuenta;
		Integer codigo = resultado.getInt(1);
		Double saldo = resultado.getDouble(2);
		String tipo = resultado.getString(3);
		String dnicliente = resultado.getString(4);
		Integer ping = resultado.getInt(5);
		if (tipo.equals("C")) {
			cuenta = new CuentaCC(dnicliente, saldo, codigo, ping);
		} else if (tipo.equals("V")) {
			cuenta = new CuentaCV(dnicliente, saldo, codigo, ping);
		} else {
			cuenta = new CuentaFI(dnicliente, saldo, codigo, ping);
		}
		return cuenta;
	}

}
