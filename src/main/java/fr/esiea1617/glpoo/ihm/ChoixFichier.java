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
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

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

import fr.esiea1617.glpoo.domain.Child;
import fr.esiea1617.glpoo.domain.Map;

public class ChoixFichier extends JFrame {
	
	private static final Logger LOGGER = Logger.getLogger(ChoixFichier.class);
	
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	
	JButton play;
	
	static String[] Terrain = {"Terrain 1","Terrain 2","Terrain 3","Terrain 4","Terrain 5","Terrain 6"};
	static JComboBox ChoixTerrain = new JComboBox(Terrain);
	static String[] Enfant1 = {"Enfant 1","Enfant 2","Enfant 3","Enfant 4","Enfant 5","Enfant 6"};
	static JComboBox ChoixEnfant1 = new JComboBox(Enfant1);
	
	
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
		int width = new Map().getWidth();
		int height = new Map().getHeight();
		
		public Terrain1Action(String text) {
			super(text);
		}

		public void actionPerformed(ActionEvent arg0) {
			LOGGER.debug("Ouverture du Terrain 1");
			dispose();
			JFrame petitest = new JFrame();
	        petitest.setPreferredSize(new Dimension(width*80, height*80));
	        petitest.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        IngameJFrame terrain = new IngameJFrame();
	        petitest.add(terrain);
	        petitest.pack();
	        petitest.setVisible(true);
	        petitest.revalidate();
	        petitest.repaint();
		}
	}
	
	public static int ConversionTerrain(){
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
	
	public static int ConversionEnfant(){
		String child = new String(ChoixEnfant1.getSelectedItem().toString());
		int b=0;
	    if(child.equals("Enfant 1")){
	    	b = 1;
	    }
	    if(child.equals("Enfant 2")){
	    	b = 2;
	    }
	    if(child.equals("Enfant 3")){
	    	b = 3;
	    }
	    if(child.equals("Enfant 4")){
	    	b = 4;
	    }
	    if(child.equals("Enfant 5")){
	    	b = 5;
	    }
	    if(child.equals("Enfant 6")){
	    	b = 6;
	    }
	    return b;
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