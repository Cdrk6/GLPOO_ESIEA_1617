package fr.esiea1617.glpoo.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
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
	
	public ChoixFichier(){
		setTitle("Chasse aux oeufs");
        setPreferredSize(new Dimension(700, 720));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
                
        panel3 = new JPanel();
        
        try {
			panel3 = setBackgroundImage(this, new File("src/main/ressources/menu.png"));
			panel3.setLayout(null);
			
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
			panel3.add(fichier8);
			
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
	
	private class fichier1Action extends AbstractAction {
		
		public fichier1Action(String text) {
			super(text);
		}

		public void actionPerformed(ActionEvent arg0) {
			LOGGER.debug("Ouverture du fichier 1");
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
	
	private class fichier2Action extends AbstractAction {
		
		public fichier2Action(String text) {
			super(text);
		}

		public void actionPerformed(ActionEvent arg0) {
			LOGGER.debug("Ouverture du fichier 2");
		}
		
	}
	
	private class fichier3Action extends AbstractAction {
		
		public fichier3Action(String text) {
			super(text);
		}

		public void actionPerformed(ActionEvent arg0) {
			LOGGER.debug("Ouverture du fichier 3");
		}
		
	}

	private class fichier4Action extends AbstractAction {
		
		public fichier4Action(String text) {
			super(text);
		}

		public void actionPerformed(ActionEvent arg0) {
			LOGGER.debug("Ouverture du fichier 4");
		}
		
	}
	
	private class fichier5Action extends AbstractAction {
		
		public fichier5Action(String text) {
			super(text);
		}

		public void actionPerformed(ActionEvent arg0) {
			LOGGER.debug("Ouverture du fichier 5");
		}
		
	}
	
	private class fichier6Action extends AbstractAction {
		
		public fichier6Action(String text) {
			super(text);
		}

		public void actionPerformed(ActionEvent arg0) {
			LOGGER.debug("Ouverture du fichier 6");
		}
		
	}
	
	private class fichier7Action extends AbstractAction {
		
		public fichier7Action(String text) {
			super(text);
		}

		public void actionPerformed(ActionEvent arg0) {
			LOGGER.debug("Ouverture du fichier 7");
		}
		
	}
	
	private class fichier8Action extends AbstractAction {
		
		public fichier8Action(String text) {
			super(text);
		}

		public void actionPerformed(ActionEvent arg0) {
			LOGGER.debug("Ouverture du fichier 8");
			
		}
		
	}
	
}
