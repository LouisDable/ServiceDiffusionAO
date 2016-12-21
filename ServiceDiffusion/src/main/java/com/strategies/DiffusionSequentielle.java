package com.strategies;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.interfaces.IObservateur;

public class DiffusionSequentielle extends Diffusion{
	int valeurCourante;
	boolean lectureComplete = true;
	int nbLecture = 0;

	@Override
	public void executeDiffusion() {
		if(lectureComplete){
			
			nbLecture = 0;
			lectureComplete = false;
			this.valeurCourante = capteur.getValue();
			
				ExecutorService exec = Executors.newFixedThreadPool(nbObservateur);
				ArrayList<Future<Void>> lesRetours = new ArrayList<>();
				ArrayList<Callable<Void>> lesExecutions = new ArrayList<>();
			
				for(final IObservateur obser : capteur.getObservateur()){
				
					Callable<Void> tache = new Callable<Void>() {
						@Override
						public Void call() throws Exception {
							obser.actualise(DiffusionSequentielle.this);
							return null;
						}
					};
				
					lesExecutions.add(tache);
					lesRetours.add(exec.submit(tache));
				}
			}
		
	}

	@Override
	public int recupererValeur() {
		nbLecture++;
		lectureComplete = (nbLecture == nbObservateur);
		return this.valeurCourante;
	}

}
