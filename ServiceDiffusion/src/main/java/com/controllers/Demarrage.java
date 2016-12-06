package com.controllers;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.vues.VDemarrage;;

public class Demarrage {
	static Capteur capteur;
	public VDemarrage vueDemarrage; 
	
	public Demarrage(){
		vueDemarrage = new VDemarrage(this);
	}
	
	
	public void demarrageApplication( int nbAfficheur, int typeDiffusion, int tick){
		
		// Ajoute les observateurs du capteur
		ArrayList<Canal> listeAfficheur = new ArrayList<Canal>();
		capteur = new Capteur(typeDiffusion);
		for(int i = 1; i <= nbAfficheur; i++){
			Canal canal = new Canal();
			listeAfficheur.add(canal);
			capteur.ajouterObservateur(canal);
		}
		
		TimerTask updateCapteur = new TimerTask(){
			@Override
			public void run() { capteur.tick(); }	
		};
		
		Timer horloge = new Timer();
		horloge.schedule(updateCapteur,0,tick);
	}
	
	
	public static void main(String[] args){
		new Demarrage();
	}
	

}
