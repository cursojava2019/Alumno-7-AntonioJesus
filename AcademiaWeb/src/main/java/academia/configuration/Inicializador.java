package academia.configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Inicializador implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		// DOMConfigurator.configure("log4j.xml");

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}