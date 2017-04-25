package fr.esiea1617.glpoo.ihm;

import java.awt.Dimension;
import javax.swing.JFrame;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;

public class ProjetJFrame extends JFrame{
	
	public ProjetJFrame() {
        setTitle("Chasse aux oeufs");
        setPreferredSize(new Dimension(500, 400));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
	
}