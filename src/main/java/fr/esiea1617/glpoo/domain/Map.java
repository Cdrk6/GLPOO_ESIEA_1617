package fr.esiea1617.glpoo.domain;

import java.util.List;

public class Map {
	
	private int width;
	private int height;
	private List<Egg> eggs;
	private List<Rock> rocks;
	private List<Child> children;
	
	public Map(int x, int y) {
		width = x;
		height = y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public List<Egg> getEggs() {
		return eggs;
	}
	
	public List<Rock> getRocks() {
		return rocks;
	}
	
	public void setRocks(List<Rock> newRocks) {
		rocks = newRocks;
	}
	
	public List<Child> getChildren() {
		return children;
	}
	
	public void setChildren(List<Child> newChildren) {
		children = newChildren;
	}
}