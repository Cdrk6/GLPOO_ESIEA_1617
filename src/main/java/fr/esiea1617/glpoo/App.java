package fr.esiea1617.glpoo;

import java.util.Iterator;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import fr.esiea1617.glpoo.domain.Child;
import fr.esiea1617.glpoo.domain.Map;

public class App {

	private static Map map;

	private static final Logger LOGGER = Logger.getLogger(App.class);

	public static void main(String[] args) {

		BasicConfigurator.configure();
		// System.out.println( "Hello World!" );
		LOGGER.info("Arnaud test succeed");
		LOGGER.info("Victor test succeed");
		LOGGER.info("Jean-Yann test succeed");
		LOGGER.info("Floriane test succeed");

		map = new Map();

		/**
		 * 
		 * In 1 second
		 * 
		 * 		
		 */

		for (int index = 0; index < 8; index++) {
			for(Iterator<Child> child = map.getChildren().iterator(); child.hasNext(); ) {
				child.next().move();
			}
		}
	}
}