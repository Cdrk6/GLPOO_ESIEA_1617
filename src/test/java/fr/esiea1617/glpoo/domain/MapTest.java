package fr.esiea1617.glpoo.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;



public class MapTest {
	
	List<Rock> rock = new ArrayList<Rock>();
	private Map map ;
	@Before
	 public void doBefore(){
		map = new Map();
		
	}
	
	@Test
	public void TestcreateGarden(){
		
		
		
		 assertEquals(5,map.getHeight());
		 assertEquals(6,map.getWidth());
		 
	}
	
}