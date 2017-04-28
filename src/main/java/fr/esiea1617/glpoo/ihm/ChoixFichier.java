package fr.esiea1617.glpoo.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import org.apache.log4j.Logger;

public class ChoixFichier extends JFrame {
	
	private static final Logger LOGGER = Logger.getLogger(ChoixFichier.class);
	
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	
	JButton fichier1;
	JButton fichier2;
	JButton fichier3;
	JButton fichier4;
	JButton fichier5;
	JButton fichier6;
	JButton fichier7;
	JButton fichier8;
	JButton play;
	
	String[] Terrain = {"Terrain 1","Terrain 2","Terrain 3","Terrain 4","Terrain 5","Terrain 6"};
	JComboBox ChoixTerrain = new JComboBox(Terrain);
	String[] Enfant1 = {"Enfant 1","Enfant 2","Enfant 3","Enfant 4","Enfant 5","Enfant 6"};
	JComboBox ChoixEnfant1 = new JComboBox(Enfant1);
	
	
	public ChoixFichier(){
		setTitle("Chasse aux oeufs");
        setPreferredSize(new Dimension(700, 720));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
                
        panel3 = new JPanel();
        
        try {
			panel3 = setBackgroundImage(this, new File("src/main/ressources/menu.png"));
			panel3.setLayout(null);
			
			ChoixTerrain.addItemListener(new ItemState());
			ChoixTerrain.addActionListener(new ActionTerrain());
			ChoixTerrain.setBounds(200,300,100,30);
			panel3.add(ChoixTerrain);
			
			
			ChoixEnfant1.addItemListener(new ItemState());
			ChoixEnfant1.addActionListener(new ActionEnfant());
			ChoixEnfant1.setBounds(400,300,100,30);
			panel3.add(ChoixEnfant1);
			
			play = new JButton(new Terrain1Action("PLAY"));
			play.setBounds(300, 400, 100, 50);
			panel3.add(play);
			/*
			fichier1 = new JButton(new fichier1Action("Fichier 1"));
			fichier1.setBounds(125, 285, 100, 50);
			panel3.add(fichier1);
			
			fichier2 = new JButton(new fichier2Action("Fichier 2"));
			fichier2.setBounds(275, 285, 100, 50);
			panel3.add(fichier2);
			
			fichier3 = new JButton(new fichier3Action("Fichier 3"));
			fichier3.setBounds(425, 285, 100, 50);
			panel3.add(fichier3);
			
			fichier4 = new JButton(new fichier4Action("Fichier 4"));
			fichier4.setBounds(125, 385, 100, 50);
			panel3.add(fichier4);
			
			fichier5 = new JButton(new fichier5Action("Fichier 5"));
			fichier5.setBounds(275, 385, 100, 50);
			panel3.add(fichier5);
			
			fichier6 = new JButton(new fichier6Action("Fichier 6"));
			fichier6.setBounds(425, 385, 100, 50);
			panel3.add(fichier6);
	        
	        fichier7 = new JButton(new fichier7Action("Fichier 7"));
	        fichier7.setBounds(125, 485, 100, 50);
			panel3.add(fichier7);
	        
	        fichier8 = new JButton(new fichier8Action("Fichier 8"));
	        fichier8.setBounds(275, 485, 100, 50);
			panel3.add(fichier8);*/
			
			add(panel3);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        
        pack();
	}
	
	public static JPanel setBackgroundImage(JFrame frame, final File img) throws IOException {
		JPanel panel = new JPanel()
		{
			private static final long serialVersionUID = 1;
			
			private BufferedImage buf = ImageIO.read(img);
			
			@Override
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(buf, 0,0, null);
			}
		};
		
		return panel;
	}
	
	private class Terrain1Action extends AbstractAction {
		
		public Terrain1Action(String text) {
			super(text);
		}

		public void actionPerformed(ActionEvent arg0) {
			LOGGER.debug("Ouverture du Terrain 1");
			dispose();
			JFrame petitest = new JFrame();
			petitest.setTitle("Chasse aux oeufs");
	        petitest.setPreferredSize(new Dimension(906, 636));
	        petitest.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        IngameJFrame terrain = new IngameJFrame();
	        petitest.add(terrain);
	        petitest.pack();
	        petitest.setVisible(true);
		}
		
	}
	
	int ConversionTerrain(){
		String map = new String(ChoixTerrain.getSelectedItem().toString());
		int a=0;
	    if(map.equals("Terrain 1")){
	    	a = 1;
	    }
	    if(map.equals("Terrain 2")){
	    	a = 2;
	    }
	    if(map.equals("Terrain 3")){
	    	a = 3;
	    }
	    if(map.equals("Terrain 4")){
	    	a = 4;
	    }
	    if(map.equals("Terrain 5")){
	    	a = 5;
	    }
	    if(map.equals("Terrain 6")){
	    	a = 6;
	    }
	    return a;
    }
	
	
	class ItemState implements ItemListener{
	    public void itemStateChanged(ItemEvent e) {
	      System.out.println("événement déclenché sur : " + e.getItem());
	    }               
	  }
	
	class ActionTerrain implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	String map = new String(ChoixTerrain.getSelectedItem().toString());	
	    	System.out.println("Terrain " + map);
	    }               
	  }
	
	class ActionEnfant implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	      System.out.println("Enfant " + ChoixEnfant1.getSelectedItem());
	    }               
	  }
	
}