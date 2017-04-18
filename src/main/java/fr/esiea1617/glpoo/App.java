package fr.esiea1617.glpoo;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import fr.esiea1617.glpoo.domain.Map;

/**
 *
 * Hello world!
 *
 */
public class App {
	
	private static Map map;
	
    private static final Logger LOGGER = Logger.getLogger(App.class);
	
    public static void main( String[] args ) {
    	
    	BasicConfigurator.configure();
        //System.out.println( "Hello World!" );
    	LOGGER.info("Arnaud test succeed");
    	LOGGER.info("Victor test succeed");
    	LOGGER.info("Jean-Yann test succeed");
    	LOGGER.info("Floriane test succeed");
    	
    	map = new Map();
    	
    	System.out.println(map.getHeight() + " - " + map.getWidth());
    	System.out.println(map.getChildren());
    	System.out.println(map.getEggs());
    	System.out.println(map.getRocks());
    }
}