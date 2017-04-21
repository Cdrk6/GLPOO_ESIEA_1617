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

		boolean going_on = true;
		map = new Map();

		/**
		 * 
		 * In 1 second
		 * 
		 * 		
		 */
		
		long base_time = System.nanoTime();
		long intermediate_time = System.nanoTime();
		
		//iterator sur :hasFinished de chaque enfant.
		while (going_on) {
			base_time = System.nanoTime();
			going_on = false;
			for(Iterator<Child> childIt = map.getChildren().iterator(); childIt.hasNext(); ) {
				Child child = childIt.next();
				child.move();
				if (!child.hasFinished()) going_on = true;
			}
			intermediate_time = System.nanoTime();
			while (intermediate_time - base_time < 1000000000) {
				intermediate_time = System.nanoTime();
			}
		}
	}
}