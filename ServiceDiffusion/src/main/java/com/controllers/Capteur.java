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
			System.out.println("Aucun choix effectué");
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
		System.out.println("Valeur Capteur : " + valeurDiffuse);
		VDemarrage.lblCapteur.setText("Valeur du Capteur : " + valeurDiffuse);
		notification();
	}

	public void ajouterObservateur(IObservateur obs) {
		observateur.add(obs); // j'ajout un observateur
		diffusion.configure(this); // j'enregistre la configuration

	}

	public void supprimerObservateur(IObservateur obs) {
		observateur.remove(obs); // je supprime un observateur
		diffusion.configure(this); // j'enregistre la configuration
	}

	public void notification() {
		diffusion.executeDiffusion(); // je lance la diffusion choisie

	}
}
