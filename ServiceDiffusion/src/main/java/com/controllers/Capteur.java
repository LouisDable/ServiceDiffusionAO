package com.controllers;

import java.util.ArrayList;

import com.interfaces.IAlgoDiffusion;
import com.vues.*;
import com.interfaces.ICapteur;
import com.interfaces.IObservateur;
import com.strategies.DiffusionAtomique;
import com.strategies.DiffusionEpoque;
import com.strategies.DiffusionSequentielle;

public class Capteur implements ICapteur {

	private ArrayList<IObservateur> observateur = null; // Liste des observateurs
	private int valeurDiffuse;
	private IAlgoDiffusion diffusion;

	// Choix de l'algo de diffusion
	public Capteur(int choix) {
		observateur = new ArrayList<IObservateur>();
		valeurDiffuse = 0;
		switch (choix) {
		case 1:
			diffusion = new DiffusionAtomique();
			break;
		case 2:
			diffusion = new DiffusionSequentielle();
			break;
		case 3:
			diffusion = new DiffusionEpoque();
			break;
		default:
			System.out.println("Aucun choix n'a été effectué");
			break;
		}
		diffusion.configure(this); // j'enregistre la configuration du capteur courant (this)
	}

	public ArrayList<IObservateur> getObservateur() {
		return observateur;
	}

	public Integer getValue() {
		return valeurDiffuse;
	}

	public void tick() {
		valeurDiffuse++;
		System.out.println("La Valeur du Capteur est : " + valeurDiffuse);
		VDemarrage.lblCapteur.setText("Valeur du capteur : " + valeurDiffuse);
		notification();
	}

	public void ajouterObservateur(IObservateur obs) {
		observateur.add(obs); // on ajout un observateur
		diffusion.configure(this); // on enregistre la configuration

	}

	public void supprimerObservateur(IObservateur obs) {
		observateur.remove(obs); // on supprime un observateur
		diffusion.configure(this); // on enregistre la configuration
	}

	public void notification() {
		// on lance la diffusion choisie
		diffusion.executeDiffusion(); 

	}
}
