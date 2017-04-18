package fr.esiea1617.glpoo.domain;

public class Rock {
	
	private int posX;
	private int posY;
	
	public Rock(int x, int y) {
		posX = x;
		posY = y;
	}
	
	public int getX() {
		return posX;
	}
	
	public int getY() {
		return posY;
	}
}