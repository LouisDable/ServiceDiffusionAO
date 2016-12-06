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
		afficheur.setNumAff(idAfficheur);
		
	}
	
	public void actualiseAfficheur(ISujetObserve Observable){
		
		valeurAffiche = ((Canal) Observable).getValue();
		afficheur.setValAff(valeurAffiche);
	}
	
	public VAfficheur getAfficheur(){
		return afficheur;
	}

}
