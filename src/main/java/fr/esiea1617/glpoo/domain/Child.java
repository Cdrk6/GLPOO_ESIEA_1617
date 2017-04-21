package fr.esiea1617.glpoo.domain;

import java.util.ArrayList;
import java.util.Iterator;

public class Child {
	
	private int posX;
	private int nextX;
	private int nextY;
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
		System.out.println(displacement);
		eggs = new ArrayList<Egg>();
		map = m;
		}
	
	public void move() {
		
		nextX = calculateNextX();
		nextY = calculateNextY();
		
		if (displacement.isEmpty()) return;
		if (map.isThereARockInFrontOf(this)) {
			while (displacement.get(0) == 'A') {
				displacement.remove(0);
			}
		}
		
		if (map.isthereAChildInFrontOf(this)) {
			return;
		}
		
		System.out.println(displacement.size());
		switch(displacement.get(0)) {
			case 'A':
				advance();
				System.out.println(name + " has moved to " + posX + " " + posY);
				break;
			case 'G':
				turnLeft();
				System.out.println(name + " has turned");
				break;
			case 'D':
				turnRight();
				System.out.println(name + " has turned");
				break;
		}
		displacement.remove(0);
		lookForEgg();
	}
	
	private void advance() {
		posX = nextX;
		posY = nextY;
	}
	
	private int calculateNextX() {
		
		switch(direction) {
			case 'W':
				if (posX > 1) return posX-1;
				break;
			case 'E':
				if (posX < map.getWidth()) return posX+1;
				break;
		}
		return posX;
	}
	
	private int calculateNextY() {
		
		switch(direction) {
			case 'N':
				if (posY > 1) return posY-1;
				break;
			case 'S':
				if (posY < map.getHeight()) return posY+1;
				break;
		}
		return posY;
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
		for (Iterator<Egg> eggIt  = map.getEggs().iterator(); eggIt.hasNext(); ) {
			Egg egg = eggIt.next();
			if (egg.getX() == posX && egg.getY() == posY) {
				System.out.println(name + " found an egg!");
				takeEgg(egg);
				break;
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
	
	public int getNextX() {
		return nextX;
	}
	
	public int getNextY() {
		return nextY;
	}
}
