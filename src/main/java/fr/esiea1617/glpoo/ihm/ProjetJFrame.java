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
        
        */
        
        
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