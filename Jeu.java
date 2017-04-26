package fr.esiea1617.glpoo.ihm;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;

import javax.swing.JFrame;

public class Jeu extends JFrame {

	public Jeu(){
		setTitle("Chasse aux oeufs");
        setPreferredSize(new Dimension(906, 636));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        setLayout(new GridLayout(4,1));
        add(new ScrollPane());
        
        
        pack();
	}
	
}
