package fr.esiea1617.glpoo.ihm;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.*;

import org.apache.log4j.Logger;

import fr.esiea1617.glpoo.domain.Map;

public class IngameJFrame extends JPanel{

	private static final Logger LOGGER = Logger.getLogger(IngameJFrame.class);
	
	private int H;
	private int W;
	private int maxH;
	private int maxW;
	private int [][]map;
	private Random rand;
	private Image roche;
	private Image terre;
	private Map positions = new Map();
	
	public IngameJFrame(){
		H = positions.getHeight();
		W = positions.getWidth();
		map = new int [H][W];
		rand = new Random();
		roche = chargerImageRoche();
		terre = chargerImageTerre();
	}
	
	public void initIntegerMap(){
		for(int i=0; i<map.length; i++){
			for(int j=0; j<map[i].length; j++){
				map[i][j]=0;
				//LOGGER.debug(map[i][j]);
			}
		}
		for(int k = 0; k<positions.getRocks().size(); k++){
			//LOGGER.info(positions.getRocks().get(k).getX()-1);
			//LOGGER.info(positions.getRocks().get(k).getY()-1);
			map[positions.getRocks().get(k).getX()-1][positions.getRocks().get(k).getY()-1] = 1;
		}
	}
	
	public void afficheCarte(Graphics g){
		initIntegerMap();
		//LOGGER.debug(map.length);
		for (int y = 0; y<map.length; y++){
			for (int x = 0; x<map[y].length; x++){
				//LOGGER.debug(map[y][x]);
				if(map[y][x]==0) afficherImage(terre,50*x,50*y,g);
				else if(map[y][x]==1) afficherImage(roche,50*x,50*y,g);
			}
		}
	}
	
	public void paintComponent(Graphics g){
		afficheCarte(g);
	}
	
	public void afficherImage(Image img, int x, int y, Graphics g) {
		g.drawImage(img, x, y, this);
		Toolkit.getDefaultToolkit().sync();

	}
	
	public Image chargerImageRoche() {
		Image img;
		ImageIcon imageIcon = new ImageIcon("src/main/ressources/mur.png");
		img = imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		return img;                
    }
	
	public Image chargerImageTerre() {
		Image img;
		ImageIcon imageIcon = new ImageIcon("src/main/ressources/terre.png");
		img = imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		return img;                
    }
	
}
