package es.indra.academia.configuration;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Configuracion {

	private static Configuracion singleton = null;
	private static String fichero = "configuracion.properties";

	Properties parametros;

	private Configuracion() {
		try {
			this.parametros = new Properties();
			InputStream propertiesStream = getClass().getClassLoader().getResourceAsStream(fichero);
			this.parametros.load(propertiesStream);
			propertiesStream.close();
		} catch (Exception e) {

		}
	}

	public static Configuracion getInstance() {
		if (singleton == null) {
			singleton = new Configuracion();
		}
		return singleton;

	}

	public Connection obtenerConexionBD() throws SQLException {
		String url = this.parametros.getProperty("bbdd.url");
		String usuario = this.parametros.getProperty("bbdd.usuario");
		String pass = this.parametros.getProperty("bbdd.pass");
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection co = DriverManager.getConnection(url, usuario,pass);
		return co;
	}

	public String obtenerParametro(String parametro) {
		return this.parametros.getProperty(parametro);
	}

}
