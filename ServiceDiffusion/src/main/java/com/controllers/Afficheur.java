package com.controllers;

import com.interfaces.ISujetObserve;
import com.vues.VAfficheur;

public class Afficheur {
	
	public int idAfficheur;
	Integer valeurAffiche;
	VAfficheur afficheur;
		
	public Afficheur(int num){
		idAfficheur = num;
		afficheur= new VAfficheur(this);
	}
	
	public void actualiseAfficheur(ISujetObserve Observable){
		
		
	}

}
