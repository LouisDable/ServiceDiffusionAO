package com.controllers;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import com.interfaces.ICapteur;
import com.interfaces.IObservateur;
import com.strategies.Diffusion;

public class Canal implements IObservateur,ICapteur {
	
	static int nbCanal;
	Integer valeurEntrante;
	int idCanal;
	Afficheur monAfficheur;
	Diffusion strategieDiffusion;
	
	public Canal(){
		nbCanal++;
		this.idCanal = nbCanal;
		monAfficheur = new Afficheur(idCanal);
	}
	
	public void actualise(Diffusion strategie) {
		
		int poolSize = 10; //Nombre de threads dans le pool
		this.strategieDiffusion = strategie;
		System.out.println("Canal update before tick : CANAL "+ idCanal);
		System.out.flush(); // vide le flux
		ScheduledExecutorService pileExecution = Executors.newScheduledThreadPool(poolSize);
		
		ScheduledFuture executionFuture = pileExecution.schedule(new Callable<Object>(){

			public Object call() throws Exception {
				monAfficheur.actualiseAfficheur(Canal.this);
				return null;
			}
			
		}, idCanal*600,TimeUnit.MILLISECONDS);
		
		try {
			executionFuture.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("Canal update after tick : CANAL "+idCanal);
		System.out.flush(); // vide le flux
		
	}
	
	public Integer getValue() {
		valeurEntrante = this.strategieDiffusion.recupererValeur();
		System.out.println("Operation getvalue par le Canal "+idCanal+" : valeur recupérée = "+valeurEntrante);
		System.out.flush();
		return valeurEntrante;
	}
	
	public void ajouterObservateur(IObservateur observateur) {}

	public void supprimerObservateur(IObservateur observateur) {}

	public void notification() {}

	public ArrayList<IObservateur> getObservateur() {return null;}
	
	public void tick() {}
	
}
