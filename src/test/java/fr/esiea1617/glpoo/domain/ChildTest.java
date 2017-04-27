package fr.esiea1617.glpoo.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;



public class ChildTest {
	
	private Child child;
	private Child childGoWall;
	
	@Before 
	 public void doBefore(){
		 Map m= new Map();
		 ArrayList<Character> displ=new ArrayList<Character>();
		 displ.add('A');
		 child = new Child(0,0,'E',displ,"buu",m);
		 childGoWall = new Child(5,0,'N',displ,"Wall",m);
		 
	 }
	
	 @Test
		public void testmoveX(){
		 child.move();
		 assertEquals(1,child.getX());
		 
	 }
	 
	 @Test
		public void testmoveY(){
		 child.move();
		 assertEquals(0,child.getY());
		 
	 }
	 
	 @Test
	 public void testInWallX(){
		 childGoWall.move();
		 assertEquals(5,childGoWall.getX());
	 }
	 
	 @Test
	 public void testInWallY(){
		 childGoWall.move();
		 assertEquals(0,childGoWall.getY());
	 }
		
		
    
    
    

}
