package fr.esiea1617.glpoo.domain;

import java.util.ArrayList;
import java.util.Iterator;

public class Child {
	
	private int posX;
	private int posY;
	private String name;
	private char direction;
	private ArrayList<Character> displacement;
	private ArrayList<Egg> eggs;
	private Map map;
	
	public Child(int x, int y, char dir, ArrayList<Character> displ, String n, Map m) {
		posX = x;
		posY = y;
		name = n;
		direction = dir;
		displacement = displ;
		eggs = new ArrayList<Egg>();
		map = m;
		}
	
	public void move() {
		
		if (map.isThereARockInFrontOf(this)) {
			while (displacement.get(0) == 'A') {
				displacement.remove(0);
			}
		}
		
		switch(displacement.get(0)) {
			case 'A':
				advance();
				break;
			case 'G':
				turnLeft();
				break;
			case 'D':
				turnRight();
				break;
		}
		displacement.remove(0);
		System.out.println(name + " has moved");
		lookForEgg();
	}
	
	private void advance() {
		switch(direction) {
			case 'N':
				if (posY != 1) posY--;
				break;
			case 'S':
				if (posY != map.getHeight()) posY++;
				break;
			case 'W':
				if (posX != 1) posX--;
				break;
			case 'E':
				if (posX != map.getWidth()) posX++;
				break;
		}
	}
	
	private void turnLeft() {
		switch(direction) {
			case 'N':
				direction = 'W';
				break;
			case 'W':
				direction = 'S';
				break;
			case 'S':
				direction = 'E';
				break;
			case 'E':
				direction = 'N';
				break;
		}
	}
	private void turnRight() {
		switch(direction) {
			case 'N':
				direction = 'E';
				break;
			case 'E':
				direction = 'S';
				break;
			case 'S':
				direction = 'W';
				break;
			case 'W':
				direction = 'N';
				break;
		}
	}
	
	private void lookForEgg() {
		for (Iterator<Egg> egg  = map.getEggs().iterator(); egg.hasNext(); ) {
			if (egg.next().getX() == posX && egg.next().getY() == posY) {
				takeEgg(egg.next());
				System.out.println(name + " found an egg!");
			}
		}
	}
	
	public void takeEgg(Egg e) {
		eggs.add(e);
		map.removeEgg(e);
		System.out.println(name + " took an egg!");
	}
	
	public int getX() {
		return posX;
	}
	
	public int getY() {
		return posY;
	}
}
