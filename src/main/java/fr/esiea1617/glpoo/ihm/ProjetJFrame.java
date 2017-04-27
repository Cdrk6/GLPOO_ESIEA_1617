package fr.esiea1617.glpoo.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;


import javax.swing.border.EtchedBorder;

import org.apache.log4j.Logger;

public class ProjetJFrame extends JFrame{
	
	private static final long serialVersionUID = -638731145561555723L;
	
	private static final Logger LOGGER = Logger.getLogger(ProjetJFrame.class);
	
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel31;
	JPanel panel32;
	JPanel panel33;
	JPanel panel34;
	JPanel panel35;
	JPanel panel36;
	JPanel panel37;
	JPanel panel38;
	
	JLabel titre;
	JLabel soustitre;
	
	JButton fichier1;
	JButton fichier2;
	JButton fichier3;
	JButton fichier4;
	JButton fichier5;
	JButton fichier6;
	JButton fichier7;
	JButton fichier8;
	
	Jeu debut;
	
	JPanel pane = new JPanel();
	
	public ProjetJFrame() {
        setTitle("Chasse aux oeufs");
        setPreferredSize(new Dimension(960, 820));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        setLayout(new GridLayout(4,1));
        
        /*ImageIcon image = new ImageIcon("src/main/ressources/menu.png");
        JLabel label = new JLabel(image);
        JScrollPane scrollPane = new JScrollPane(label);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
        
        panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titre = new JLabel("Chasse aux oeufs");
        Font font = new Font("Arial", Font.BOLD, 30);
		titre.setFont(font);
        panel1.add(titre);
        add(panel1);*/
        
        try {
			pane =setBackgroundImage(this, new File("src/main/ressources/menu.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//pane.setLayout(null);
        
        /*panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        soustitre = new JLabel("Choisissez un fichier à exécuter");
        Font font2 = new Font("Arial", Font.BOLD, 20);
        soustitre.setFont(font2);
        panel2.add(soustitre);
        add(panel2);*/
        
        panel3 = new JPanel(new GridLayout(4,2));
        
        panel31 = new JPanel();
        fichier1 = new JButton(new fichier1Action("Fichier 1"));
        panel31.add(fichier1);
        
        panel32 = new JPanel();
        fichier2 = new JButton(new fichier2Action("Fichier 2"));
        panel32.add(fichier2);
        
        panel33 = new JPanel();
        fichier3 = new JButton(new fichier3Action("Fichier 3"));
        panel33.add(fichier3);
        
        panel34 = new JPanel();
        fichier4 = new JButton(new fichier4Action("Fichier 4"));
        panel34.add(fichier4);
        
        panel35 = new JPanel();
        fichier5 = new JButton(new fichier5Action("Fichier 5"));
        panel35.add(fichier5);
        
        panel36 = new JPanel();
        fichier6 = new JButton(new fichier6Action("Fichier 6"));
        panel36.add(fichier6);
        
        panel37 = new JPanel();
        fichier7 = new JButton(new fichier7Action("Fichier 7"));
        panel37.add(fichier7);
        
        panel38 = new JPanel();
        fichier8 = new JButton(new fichier8Action("Fichier 8"));
        panel38.add(fichier8);
        
        panel3.add(panel31);
        panel3.add(panel32);
        panel3.add(panel33);
        panel3.add(panel34);
        panel3.add(panel35);
        panel3.add(panel36);
        panel3.add(panel37);
        panel3.add(panel38);
        panel3.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        
        add(panel3);
        //add(new JScrollPane());
        
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
		
		frame.setContentPane(panel);
		
		return panel;
	}
	
	private class fichier1Action extends AbstractAction {
		
		public fichier1Action(String text) {
			super(text);
		}

		public void actionPerformed(ActionEvent arg0) {
			LOGGER.debug("Ouverture du fichier 1");		
			debut = new Jeu();
			debut.setVisible(true);
			dispose();
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