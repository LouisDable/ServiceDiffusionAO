package com.controllers;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.interfaces.IObservateur;

public class testCapteur {

	public testCapteur(){
		
	}

	@Test
	public final void testPCObserver() {
		Capteur capteur = new Capteur(1);
		ArrayList<IObservateur> observateur = null; // Liste des observateurs
		// Je crée un canal
		Canal c1 = new Canal();
		Canal c2 = new Canal();
		Canal c3 = new Canal();
		// Je les ajoute à la liste des Observateurs
		capteur.ajouterObservateur(c1);
		capteur.ajouterObservateur(c2);
		capteur.ajouterObservateur(c3);
		// Je verifie s'ils ont été ajouté
		observateur = capteur.getObservateur();
		assertTrue(" Nous avons les 3 Observateurs ", observateur.size() == 3 );
		// Je supprime un observateur
		capteur.supprimerObservateur(c3);
		//Je verifie s'il a été supprimé
		assertTrue(" Nous avons maintenant 2 Observateurs ", observateur.size() == 2 );
		// Je verifie la valeur du compteur
		assertTrue(" la valeur du compteur doit être nulle au départ ", capteur.getValue() == 0 );
		// On verifie que le capteur incrémente
		int valeurC = 0;
		for(int i = 0; i<5;i++){
			capteur.tick();
			valeurC++;
		}
		assertTrue(" la valeur du compteur doit être "+ valeurC, capteur.getValue() == valeurC );
	}

}
