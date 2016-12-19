package com.vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Acceuil {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil window = new Acceuil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Acceuil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 334, 239);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(230, 170, 78, 23);
		frame.getContentPane().add(btnAnnuler);
		
		JLabel lblTickHorloge = new JLabel("Tick Horloge");
		lblTickHorloge.setBounds(10, 42, 72, 14);
		frame.getContentPane().add(lblTickHorloge);
		
		JLabel lblNombreAfficheurs = new JLabel("Nombre Afficheurs");
		lblNombreAfficheurs.setBounds(10, 120, 98, 14);
		frame.getContentPane().add(lblNombreAfficheurs);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 156, 318, 45);
		frame.getContentPane().add(separator);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(108, 39, 60, 20);
		frame.getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(108, 117, 60, 20);
		frame.getContentPane().add(spinner_1);
		
		JLabel lblAlgorithme = new JLabel("Algorithme");
		lblAlgorithme.setBounds(10, 83, 60, 14);
		frame.getContentPane().add(lblAlgorithme);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Atomique", "Sequentielle", "Epoque"}));
		comboBox.setBounds(108, 80, 91, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBox.getSelectedItem());
			}
		});
		btnValider.setBounds(121, 170, 78, 23);
		frame.getContentPane().add(btnValider);
		
	}
}
