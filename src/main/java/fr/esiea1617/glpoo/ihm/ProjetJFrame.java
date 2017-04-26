package fr.esiea1617.glpoo.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;

public class ProjetJFrame extends JFrame{
	
	private static final long serialVersionUID = -638731145561555723L;
	
	public ProjetJFrame() {
        setTitle("Chasse aux oeufs");
        //setPreferredSize(new Dimension(700, 760));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon image = new ImageIcon("src/main/ressources/menu.png");
        JLabel label = new JLabel(image);
        JScrollPane scrollPane = new JScrollPane(label);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.CENTER);
        pack();
        
    }
	
}