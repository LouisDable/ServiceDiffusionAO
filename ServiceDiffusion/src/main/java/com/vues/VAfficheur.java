package com.vues;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import com.controllers.Afficheur;

public class VAfficheur extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel panneauPrincipal;
	JLabel titreLbl, modeLbl, affValeurLbl;
	
	int numeroAff;
	
	Afficheur controleur;
	
	public VAfficheur(Afficheur contrl){
		
		super();
		this.controleur = contrl;
			
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		getContentPane().setBackground(new Color(255, 170, 55));
		
		initIHM();
		
		pack();
		setLocation(50, 50);
		Dimension tailleFen = new Dimension(150, 200);
		setMinimumSize(tailleFen);
		setSize(tailleFen);
		setResizable(false);
		setVisible(true);
		
	}

	public Afficheur getContoleur(){
		return controleur;
	}
	
	private void initIHM(){
		
		panneauPrincipal = new JPanel();
		Border bordureTempo = BorderFactory.createTitledBorder(
						BorderFactory.createLineBorder(Color.BLACK, 2), "Afficheur");
		panneauPrincipal.setBorder(bordureTempo);
		panneauPrincipal.setLayout(new BoxLayout(panneauPrincipal, BoxLayout.Y_AXIS));
		panneauPrincipal.setSize(140, 150);
		panneauPrincipal.setPreferredSize(panneauPrincipal.getSize());
		panneauPrincipal.setBackground(getContentPane().getBackground());
		
		titreLbl = new JLabel();
		titreLbl.setText("Aff n° ");

		panneauPrincipal.add(titreLbl);
		
		affValeurLbl = new JLabel();
		affValeurLbl.setText("Valeur = ");

		panneauPrincipal.add(affValeurLbl);
				
		getContentPane().add(panneauPrincipal);
	}

	public void setNumAff(int num){
		
		this.numeroAff = num;
		
		setLocation(50 + (200 * ((numeroAff - 1) % 5)), 50 + ((numeroAff-1) / 5) * 220);
		titreLbl.setText("Aff n° " + numeroAff);
	}
	
	public void setValAff(int valeur){
		
		affValeurLbl.setText("Valeur = " + valeur);
	}

public void setModeAff(String mode){
		
	modeLbl.setText("mode : " + mode);
	}

}
