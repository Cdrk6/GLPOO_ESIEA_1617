package fr.esiea1617.glpoo.ihm;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import javax.swing.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import fr.esiea1617.glpoo.App;
import fr.esiea1617.glpoo.domain.Child;
import fr.esiea1617.glpoo.domain.Map;

public class IngameJFrame extends JPanel {

	private static final Logger LOGGER = Logger.getLogger(IngameJFrame.class);

	private static long movingTime = 1000;

	private int H;
	private int W;
	private int maxH;
	private int maxW;
	private int[][] terrain;
	private Image roche;
	private Image terre;
	private Image oeuf;
	private Image enfant;
	private Child child;
	// private Map map = new Map();
	private Map map;

	boolean going_on = true;

	AtomicLong base_time = new AtomicLong(System.currentTimeMillis());
	AtomicLong intermediate_time = new AtomicLong(System.currentTimeMillis());

	public IngameJFrame() {
		map = new Map();
		H = map.getHeight() + 1;
		W = map.getWidth() + 1;
		terrain = new int[H][W];
		roche = chargerImageRoche();
		terre = chargerImageTerre();
		oeuf = chargerImageOeuf();
		enfant = chargerImageEnfant();
		setIntegerMap();
		runGame();
		revalidate();
		repaint();
	}

	public void runGame() {
		// iterator sur :hasFinished de chaque enfant.
		while (going_on) {
			base_time.set(System.currentTimeMillis());
			going_on = false;
			for (Iterator<Child> childIt = map.getChildren().iterator(); childIt
					.hasNext();) {
				Child child = childIt.next();
				child.move();
				if (!child.hasFinished())
					going_on = true;
				setIntegerMap();
				revalidate();
				repaint();
			}
			intermediate_time.set(System.currentTimeMillis());
			while (intermediate_time.longValue() - base_time.longValue() < movingTime) {
				intermediate_time.set(System.currentTimeMillis());
			}
		}
	}

	public static long getMovingTime() {
		return movingTime;
	}

	public static void setMovingTime(long newMovingTime) {
		movingTime = newMovingTime;
	}

	public void setIntegerMap() {
		AtomicLong base_time = new AtomicLong(System.currentTimeMillis());
		AtomicLong intermediate_time = new AtomicLong(
				System.currentTimeMillis());
		boolean going_on = true;

		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain[i].length; j++) {
				terrain[i][j] = 0;
				// LOGGER.debug(map[i][j]);
			}
		}

		for (int k = 0; k < map.getRocks().size(); k++) {
			// LOGGER.info(map.getRocks().get(k).getX()-1);
			// LOGGER.info(map.getRocks().get(k).getY()-1);
			terrain[map.getRocks().get(k).getX() - 1][map.getRocks().get(k)
					.getY() - 1] = 1;
		}

		for (int k = 0; k < map.getEggs().size(); k++) {
			terrain[map.getEggs().get(k).getX() - 1][map.getEggs().get(k)
					.getY() - 1] = 2;
		}

		for (int k = 0; k < map.getChildren().size(); k++) {
			LOGGER.debug(map.getChildren().get(k).getX());
			LOGGER.debug(map.getChildren().get(k).getY());
			terrain[map.getChildren().get(k).getX() - 1][map.getChildren()
					.get(k).getY() - 1] = 3;
		}

	}

	public void paintComponent(Graphics g) {
		// LOGGER.debug(map.length);
		for (int y = 0; y < terrain.length; y++) {
			for (int x = 0; x < terrain[y].length; x++) {
				afficherImage(terre, 50 * x, 50 * y, g);
				if (terrain[y][x] == 1)
					afficherImage(roche, 50 * x, 50 * y, g);
				else if (terrain[y][x] == 2)
					afficherImage(oeuf, 50 * x, 50 * y, g);
				else if (terrain[y][x] == 3)
					afficherImage(enfant, 50 * x, 50 * y, g);
			}
		}
	}

	public void afficherImage(Image img, int x, int y, Graphics g) {
		g.drawImage(img, x, y, this);
		Toolkit.getDefaultToolkit().sync();

	}

	public Image chargerImageRoche() {
		Image img;
		ImageIcon imageIcon = new ImageIcon("src/main/ressources/mur.png");
		img = imageIcon.getImage().getScaledInstance(50, 50,
				Image.SCALE_DEFAULT);
		return img;
	}

	public Image chargerImageTerre() {
		Image img;
		ImageIcon imageIcon = new ImageIcon("src/main/ressources/terre.png");
		img = imageIcon.getImage().getScaledInstance(50, 50,
				Image.SCALE_DEFAULT);
		return img;
	}

	public Image chargerImageOeuf() {
		Image img;
		ImageIcon imageIcon = new ImageIcon("src/main/ressources/obj.gif");
		img = imageIcon.getImage().getScaledInstance(50, 50,
				Image.SCALE_DEFAULT);
		return img;
	}

	public Image chargerImageEnfant() {
		Image img;
		ImageIcon imageIcon = new ImageIcon("src/main/ressources/S1.png");
		img = imageIcon.getImage().getScaledInstance(50, 50,
				Image.SCALE_DEFAULT);
		return img;
	}

}
