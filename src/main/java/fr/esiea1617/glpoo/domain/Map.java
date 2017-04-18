package fr.esiea1617.glpoo.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Map {

	private int width;
	private int height;
	private List<Egg> eggs;
	private List<Rock> rocks;
	private List<Child> children;

	public Map() {

		eggs = new ArrayList<Egg>();
		rocks = new ArrayList<Rock>();

		File mapFile = getFile("mapFile.txt");
		Scanner scan;
		try {
			scan = new Scanner(mapFile);
			StringBuilder result = new StringBuilder("");

			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				if (line != null && !line.isEmpty()) {
					creationTree(line);
				}
				result.append(line).append("\n");
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("width : " + width);
		System.out.println("height : " + height);

		childrenCreation();
	}

	private File getFile(String fileName) {
		// Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		return file;
	}

	private void creationTree(String instruction) {
		char c = instruction.charAt(0);
		switch (c) {
		case 'J':
			createGarden(instruction);
			break;
		case 'C':
			createEgg(instruction);
			break;
		case 'R':
			createRock(instruction);
			break;
		}
	}

	private void createGarden(String gardenInstruction) {
		int remainingInfo = 2;
		String info = "";
		System.out.println("createGarden : " + gardenInstruction);

		for (int i = 0, n = gardenInstruction.length(); i < n; i++) {
			char c = gardenInstruction.charAt(i);

			if (Character.isDigit(c)) {
				info += c;
			}

			if ((c == ' ' || i == n - 1) && info != "") {
				if (remainingInfo == 2)
					width = Integer.parseInt(info);
				else
					height = Integer.parseInt(info);
				info = "";
				remainingInfo--;
			}
		}
	}

	private void createEgg(String eggInstruction) {
		int remainingInfo = 2;
		String info = "";
		System.out.println("createEgg " + eggInstruction);
		String[] coordinates = new String[2];
		coordinates[0] = coordinates[1] = "";

		for (int i = 0, n = eggInstruction.length(); i < n; i++) {
			char c = eggInstruction.charAt(i);

			if (Character.isDigit(c) || c == '-') {
				info += c;
			}

			if ((c == ' ' || i == n - 1) && info != "") {
				if (remainingInfo == 2) {
					coordinates = info.split("-");
					info = "";
					remainingInfo--;
				} else {
					for (int index = 0; index < Integer.parseInt(info); index++) {
						eggs.add(new Egg(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])));
						System.out.println("egg created");
					}
				}
			}
		}
	}

	private void createRock(String rockInstruction) {
		String info = "";
		System.out.println("createRock " + rockInstruction);
		String[] coordinates = new String[2];
		coordinates[0] = coordinates[1] = "";

		for (int i = 0, n = rockInstruction.length(); i < n; i++) {
			char c = rockInstruction.charAt(i);

			if (Character.isDigit(c) || c == '-') {
				info += c;
			}

			if ((c == ' ' || i == n - 1) && info != "") {
				coordinates = info.split("-");
				info = "";
				rocks.add(new Rock(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])));
				System.out.println("rock created");
			}
		}
	}

	private void childrenCreation() {

		children = new ArrayList<Child>();

		File childrenFile = getFile("childrenFile.txt");
		Scanner scan;
		try {
			scan = new Scanner(childrenFile);
			StringBuilder result = new StringBuilder("");

			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				if (line != null && !line.isEmpty()) {
					if (line.charAt(0) != '#')
						createChild(line);
				}
				result.append(line).append("\n");
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void createChild(String childInstruction) {

		int remainingInfo = 4;
		String info = "";
		System.out.println("createChild " + childInstruction);

		String[] coordinates = new String[2];
		coordinates[0] = coordinates[1] = "";
		char dir = ' ';
		ArrayList<Character> depl = new ArrayList<Character>();
		String name = "";

		for (int i = 1, n = childInstruction.length(); i < n; i++) {
			char c = childInstruction.charAt(i);

			if (Character.isDigit(c) || c == '-' || Character.isLetter(c)) {
				info += c;
			}

			if ((c == ' ' || i == n - 1) && info != "") {
				if (remainingInfo == 4) {

					coordinates = info.split("-");
					info = "";
					remainingInfo--;

				} else if (remainingInfo == 3) {

					dir = info.toCharArray()[0];
					info = "";
					remainingInfo--;

				} else if (remainingInfo == 2) {
					for (char ch : info.toCharArray()) {
						depl.add(new Character(ch));
					}
					info = "";
					remainingInfo--;
				} else if (remainingInfo == 1) {

					name = info;
					info = "";
					remainingInfo--;
					children.add(new Child(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]), dir,
							depl, name, this));
					System.out.println("child created");
				}
			}
		}
	}
	
	public boolean isThereARockInFrontOf(Child child) {
		
		for(Iterator<Rock> rock = rocks.iterator(); rock.hasNext(); ) {
		    if (rock.next().getX() == child.getX() && rock.next().getY() == child.getY()) return true;
		}
		return false;
	}
	
	public void removeEgg(Egg egg) {
		eggs.remove(egg);
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