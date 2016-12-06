package com.vues;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.controllers.Demarrage;


public class VDemarrage extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel panneauPrincipal, pnlTempo, pnlType, pnlNbaff;
	JLabel titreLbl, modeLbl, affValeurLbl;
	JButton valid;
	JSlider molette, modeSld, nbAffSld;
	JLabel afficheMolette, affichemodeSld, affichenbaffSld;
	
	int tempo = 1000, type = 1, nbAff = 4;
	
	
	
	Demarrage controleur;
	
	/**
	 * Constructor for PDemarrage.
	 * @param ctrl CDemarrage
	 */
	public VDemarrage(Demarrage ctrl) {
		
		super();
		this.controleur = ctrl;
			
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		getContentPane().setBackground(new Color(245,245,245));
		
		initIHM();
		initACTION();
		
		pack();
		setLocation(150, 150);
		Dimension tailleFen = new Dimension(350, 350);
		setMinimumSize(tailleFen);
		setSize(tailleFen);
		setResizable(false);
		setVisible(true);
		
	}
	
	/**
	 * Method getContoleur.
	 * @return CDemarrage
	 */
	public Demarrage getContoleur(){
		return controleur;
	}
	
	private void initIHM(){
		
		panneauPrincipal = new JPanel();
		Border bordure = BorderFactory.createTitledBorder(
						BorderFactory.createLineBorder(Color.GRAY, 2), "Paramètres de l'appli OBSERVER");
		panneauPrincipal.setBorder(bordure);
		panneauPrincipal.setLayout(new BoxLayout(panneauPrincipal, BoxLayout.Y_AXIS));
		panneauPrincipal.setSize(300, 300);
		panneauPrincipal.setPreferredSize(panneauPrincipal.getSize());
		panneauPrincipal.setBackground(getContentPane().getBackground());
		
		
		pnlTempo = new JPanel();
		Border bordureTempo = BorderFactory.createTitledBorder(
						BorderFactory.createLineBorder(Color.BLACK, 2), "Tempo horloge en ms");
		pnlTempo.setBorder(bordureTempo);
		pnlTempo.setLayout(new BoxLayout(pnlTempo, BoxLayout.Y_AXIS));
		pnlTempo.setSize(300, 70);
		pnlTempo.setPreferredSize(pnlTempo.getSize());
		pnlTempo.setBackground(getContentPane().getBackground());
		
		molette = new JSlider();
		molette.setMaximum(10000);
		molette.setMinimum(1000);
		molette.setValue(1000);
		
		afficheMolette = new JLabel(String.valueOf(molette.getValue()));

		molette.setBackground(getContentPane().getBackground());
		molette.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent arg0) {
				
				tempo = molette.getValue();
				afficheMolette.setText(String.valueOf(molette.getValue()));
			}

		});
		
		pnlTempo.add(molette);		
		pnlTempo.add(afficheMolette);
		
		panneauPrincipal.add(pnlTempo);
		
		
		pnlType = new JPanel();
		Border bordureType = BorderFactory.createTitledBorder(
						BorderFactory.createLineBorder(Color.BLACK, 2), "Type de stratégie");
		pnlType.setBorder(bordureType);
		pnlType.setLayout(new BoxLayout(pnlType, BoxLayout.Y_AXIS));
		pnlType.setSize(300, 70);
		pnlType.setPreferredSize(pnlType.getSize());
		pnlType.setBackground(getContentPane().getBackground());
		
		modeSld = new JSlider();
		modeSld.setMaximum(3);
		modeSld.setMinimum(1);
		modeSld.setValue(1);
		
		affichemodeSld = new JLabel("ATOMIQUE");

		modeSld.setBackground(getContentPane().getBackground());
		modeSld.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent arg0) {
				
				type = modeSld.getValue();
				
				String txt = "";
				
				switch (type) {
				case 1:
					txt = "ATOMIQUE";
					break;
				case 2:
					txt = "SEQUENTIELLE";
					break;
				case 3:
					txt = "EPOQUE";
					break;
				default:
					break;
				}
				affichemodeSld.setText(txt);
			}

		});
		
		pnlType.add(modeSld);		
		pnlType.add(affichemodeSld);
		
		panneauPrincipal.add(pnlType);
		
		pnlNbaff = new JPanel();
		Border bordureAff = BorderFactory.createTitledBorder(
						BorderFactory.createLineBorder(Color.BLACK, 2), "Nombre d'"
								+ "Afficheurs");
		pnlNbaff.setBorder(bordureAff);
		pnlNbaff.setLayout(new BoxLayout(pnlNbaff, BoxLayout.Y_AXIS));
		pnlNbaff.setSize(300, 70);
		pnlNbaff.setPreferredSize(pnlNbaff.getSize());
		pnlNbaff.setBackground(getContentPane().getBackground());
		
		nbAffSld = new JSlider();
		nbAffSld.setMaximum(20);
		nbAffSld.setMinimum(1);
		nbAffSld.setValue(4);
		
		affichenbaffSld = new JLabel(String.valueOf(nbAffSld.getValue()));

		nbAffSld.setBackground(getContentPane().getBackground());
		
		nbAffSld.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent arg0) {
				
				nbAff = nbAffSld.getValue();
				affichenbaffSld.setText(String.valueOf(nbAffSld.getValue()));
			}

		});
		
		pnlNbaff.add(nbAffSld);		
		pnlNbaff.add(affichenbaffSld);
		
		panneauPrincipal.add(pnlNbaff);
		
		
		
		valid = new JButton("OK");
		
		panneauPrincipal.add(valid);
		
		getContentPane().add(panneauPrincipal);
	}

	private void initACTION(){
		
		valid.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {

				controleur.demarrageApplication(nbAff, type, tempo);
				
			}
		});
	}
	
}
