package fr.esiea1617.glpoo.domain;

import java.util.ArrayList;

public class Child {
	
	private int posX;
	private int posY;
	private String name;
	private char direction;
	private ArrayList<Character> displacement;
	private boolean isMoving;
	private ArrayList<Egg> eggs;
	private Map map;
	
	public Child(int x, int y, char dir, ArrayList<Character> displ, String n) {
		posX = x;
		posY = y;
		name = n;
		direction = dir;
		displacement = displ;
		isMoving = true;
		eggs = new ArrayList<Egg>();
		}
	
	public void move() {
		
		if (isMoving == false) {
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
	
	public void takeEgg(Egg e) {
		eggs.add(e);
	}
	
	public void stop() {
		isMoving = false;
	}
	
	public void resume() {
		isMoving = true;
	}
}
