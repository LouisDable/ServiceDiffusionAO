package com.vues;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.controllers.Demarrage;


public class VDemarrage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panneauPrincipal;
	private JSpinner spinTick;
	private JComboBox comboBox;
	private JSpinner spinAff;
	private JButton btnValider;
	public static JLabel lblCapteur = new JLabel("Valeur du capteur : ");
	public static int test = 0;
	private int tempo = 1000, type = 1, nbAff = 3;
	
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
		Dimension tailleFen = new Dimension(300, 300);
		setMinimumSize(tailleFen);
		setSize(tailleFen);
		setLocationRelativeTo(null) ;
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
						BorderFactory.createLineBorder(Color.GRAY, 2), "Setting");
		panneauPrincipal.setBorder(bordure);
		panneauPrincipal.setLayout(null);
		panneauPrincipal.setSize(270, 250);
		panneauPrincipal.setPreferredSize(panneauPrincipal.getSize());
		panneauPrincipal.setBackground(getContentPane().getBackground());
		
		// TICK HORLOGE
		JLabel lblTickHorloge = new JLabel("Tick Horloge");
		lblTickHorloge.setBounds(10, 42, 72, 14);
		panneauPrincipal.add(lblTickHorloge);
		
		SpinnerModel sm = new SpinnerNumberModel(1000, 1000, 9000, 1000);
		spinTick = new JSpinner(sm);
		spinTick.setBounds(100, 42, 50, 20);
		panneauPrincipal.add(spinTick);
		
		// ALGO DE DIFFUSION
		JLabel lblAlgorithme = new JLabel("Diffusion");
		lblAlgorithme.setBounds(10, 83, 60, 14);
		panneauPrincipal.add(lblAlgorithme);
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Atomique", "Sequentielle", "Epoque"}));
		comboBox.setBounds(100, 80, 110, 20);
		panneauPrincipal.add(comboBox);
		
		//NOMBRE AFFICHEURS
		JLabel lblNombreAfficheurs = new JLabel("Afficheurs");
		lblNombreAfficheurs.setBounds(10, 120, 98, 14);
		panneauPrincipal.add(lblNombreAfficheurs);
		SpinnerModel sma = new SpinnerNumberModel(4, 2, 10, 1);
		spinAff = new JSpinner(sma);
		spinAff.setBounds(100, 117, 60, 20);
		panneauPrincipal.add(spinAff);
		
		// BUTON VALIDER
		btnValider = new JButton("Valider");
		btnValider.setBounds(170, 170, 78, 23);
		panneauPrincipal.add(btnValider);
		
		// SEPARATEUR
		JSeparator separator = new JSeparator();
		separator.setBounds(5,200,260, 45);
		panneauPrincipal.add(separator);
		
		// LABEL HORLOGE
		lblCapteur.setBounds(60, 210, 200, 14);
		lblCapteur.setForeground(Color.BLUE);
		panneauPrincipal.add(lblCapteur);
		
		getContentPane().add(panneauPrincipal);
	}

	private void initACTION(){
		
		btnValider.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				tempo = Integer.parseInt(spinTick.getValue().toString());
				nbAff = Integer.parseInt(spinAff.getValue().toString());
				
				switch(comboBox.getSelectedItem().toString()){
					case "Atomique":
						type = 1;
					break;
					case "Sequentielle":
						type = 2;
					break;
					case "Epoque":
						type = 3;
					break;
					default:
						System.out.println("Par défaut l'algo Atomique est choisi");
						type = 1;
						break;
				
				}			
				controleur.demarrageApplication(nbAff, type, tempo);
				
			}
		});
	}
	
}
