package fr.esiea1617.glpoo.ihm;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class IngameJFrame extends JPanel{

	protected int H;
	protected int W;
	protected int maxH;
	protected int maxW;
	protected int [][]map;
	protected Random rand;
	protected Image mur;
	protected Image terre;
	
	public IngameJFrame(){
		H = 5;
		W = 5;
		map = new int [H][W];
		rand = new Random();
		mur = chargerImage();
		//afficheCarte()
	}
	
	public void afficheCarte(Graphics g){
		for (int y = 0; y<H; y++){
			for (int x = 0; x<W; x++){
				afficherImage(mur,30*x,30*y,g);
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
	
	public Image chargerImage() {
		Image img;
		ImageIcon imageIcon = new ImageIcon("src/main/ressources/mur.png");
		img = imageIcon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		return img;                
    }
	
}
