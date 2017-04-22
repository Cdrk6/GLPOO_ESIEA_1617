package fr.esiea1617.glpoo.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;



public class ChildTest {
	
	private Child child;
	
	@Before 
	 public void doBefore(){
		 ArrayList<Character> displ=new ArrayList<Character>();
		 displ.add('A');
		 
		 Map m= new Map();
		 
		 child = new Child(0,0,'E',displ,"buu",m);
	 }
	
	 @Test
		public void testmove(){
		 child.move();
		 assertEquals(1,child.getX());
		 
	 }
		
		
    
    
    

}
