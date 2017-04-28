package fr.esiea1617.glpoo.ihm;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import javax.swing.*;

import org.apache.log4j.Logger;

import fr.esiea1617.glpoo.domain.Child;
import fr.esiea1617.glpoo.domain.Map;

public class IngameJFrame extends JPanel{

	private static final Logger LOGGER = Logger.getLogger(IngameJFrame.class);
	
	private static long movingTime = 1000;
	
	private int H;
	private int W;
	private int maxH;
	private int maxW;
	private int [][]map;
	private Random rand;
	private Image roche;
	private Image terre;
	private Image oeuf;
	private Image enfant;
	private Map positions = new Map();
	
	public IngameJFrame(){
		H = positions.getHeight();
		W = positions.getWidth();
		map = new int [H][W];
		rand = new Random();
		initIntegerMap();
		roche = chargerImageRoche();
		terre = chargerImageTerre();
		oeuf = chargerImageOeuf();
		enfant = chargerImageEnfant();
	}
	
	public void initIntegerMap(){
		AtomicLong base_time = new AtomicLong(System.currentTimeMillis());
		AtomicLong intermediate_time = new AtomicLong(System.currentTimeMillis());
		boolean going_on = true;
		
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
		
		for(int k = 0; k<positions.getEggs().size(); k++){
			map[positions.getEggs().get(k).getX()-1][positions.getEggs().get(k).getY()-1] = 2;
		}
		
		for(int k = 0; k<positions.getChildren().size(); k++){
				map[positions.getChildren().get(k).getX()][positions.getChildren().get(k).getY()] = 3;
				LOGGER.debug(positions.getChildren().get(k).getX());
				LOGGER.debug(positions.getChildren().get(k).getY());
		}

	}
	
	public void afficheCarte(Graphics g){
		
		//LOGGER.debug(map.length);
		for (int y = 0; y<map.length; y++){
			for (int x = 0; x<map[y].length; x++){
				if(map[y][x]==0) afficherImage(terre,50*x,50*y,g);
				else if(map[y][x]==1) afficherImage(roche,50*x,50*y,g);
				else if(map[y][x]==2){
					afficherImage(terre,50*x,50*y,g);
					afficherImage(oeuf,50*x,50*y,g);
				}
				else if(map[y][x]==3){
					afficherImage(terre,50*x,50*y,g);
					afficherImage(enfant,50*x,50*y,g);
				}
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
	
	public Image chargerImageOeuf() {
		Image img;
		ImageIcon imageIcon = new ImageIcon("src/main/ressources/obj.gif");
		img = imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		return img;                
    }
	
	public Image chargerImageEnfant() {
		Image img;
		ImageIcon imageIcon = new ImageIcon("src/main/ressources/S1.png");
		img = imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		return img;                
    }
	
}
