package fr.esiea1617.glpoo;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import fr.esiea1617.glpoo.domain.Child;
import fr.esiea1617.glpoo.domain.Map;
import fr.esiea1617.glpoo.ihm.ProjetJFrame;

public class App {

	private static Map map;
	private static long movingTime = 1000;
	

	private static final Logger LOGGER = Logger.getLogger(App.class);

	public static void main(String[] args) {

		BasicConfigurator.configure();
		// System.out.println( "Hello World!" );
		LOGGER.info("Arnaud test succeed");
		LOGGER.info("Victor test succeed");
		LOGGER.info("Jean-Yann test succeed");
		LOGGER.info("Floriane test succeed");
		LOGGER.info("Ammallan test succeed");

		boolean going_on = true;
		map = new Map();

		/**
		 * 
		 * In 1 second
		 * 
		 * 		
		 */
		
		AtomicLong base_time = new AtomicLong(System.currentTimeMillis());
		AtomicLong intermediate_time = new AtomicLong(System.currentTimeMillis());
		
		//new ProjetJFrame().setVisible(true);
		
		//iterator sur :hasFinished de chaque enfant.
		while (going_on) {
			base_time.set(System.currentTimeMillis());
			going_on = false;
			for(Iterator<Child> childIt = map.getChildren().iterator(); childIt.hasNext(); ) {
				Child child = childIt.next();
				child.move();
				if (!child.hasFinished()) going_on = true;
			}
			intermediate_time.set(System.currentTimeMillis());
			while (intermediate_time.longValue() - base_time.longValue() < movingTime) {
				intermediate_time.set(System.currentTimeMillis());
			}
		}
		
		
        
	}
	
	public static long getMovingTime () {
		return movingTime;
	}
	
	public static void setMovingTime (long newMovingTime) {
		movingTime = newMovingTime;
	}
}