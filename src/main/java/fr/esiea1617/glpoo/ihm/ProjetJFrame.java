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
	
	JButton jouer;
	JButton quitter;
	
	JPanel pane = new JPanel();
	
	public ProjetJFrame() {
        setTitle("Chasse aux oeufs");
        setPreferredSize(new Dimension(700, 720));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        try {
			pane = setBackgroundImage(this, new File("src/main/ressources/menu.png"));
			
			pane.setLayout(null);
			
			jouer = new JButton(new jouerAction("Jouer"));
			jouer.setBounds(125, 285, 150, 90);
	                
			quitter = new JButton(new quitterAction("Quitter"));
			quitter.setBounds(425, 285, 150, 90);
			
			pane.add(jouer);
			pane.add(quitter);
			
			add(pane);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        
        /*panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        soustitre = new JLabel("Choisissez un fichier à exécuter");
        Font font2 = new Font("Arial", Font.BOLD, 20);
        soustitre.setFont(font2);
        panel2.add(soustitre);
        add(panel2);
        
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
        
        add(panel3, BorderLayout.CENTER);*/
        
        
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
	
	private class jouerAction extends AbstractAction {
		
		public jouerAction(String text){
			super(text);
		}

		public void actionPerformed(ActionEvent arg0) {
			LOGGER.debug("Jouons");
			ChoixFichier ch = new ChoixFichier();
			ch.setVisible(true);
			dispose();
		}
		
	}
	
	private class quitterAction extends AbstractAction {
		
		public quitterAction(String text){
			super(text);
		}

		public void actionPerformed(ActionEvent arg0) {
			LOGGER.debug("Au revoir !");
			dispose();
		}
		
	}

}