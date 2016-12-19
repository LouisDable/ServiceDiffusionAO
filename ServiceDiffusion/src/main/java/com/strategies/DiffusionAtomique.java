package com.strategies;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.interfaces.IObservateur;


public class DiffusionAtomique extends Diffusion{
	
	public int cmptGetval = 0;

	@Override
	public void executeDiffusion() {
		
		ExecutorService exec = Executors.newFixedThreadPool(nbObservateur);
		ArrayList<Future<Void>> lesRetours = new ArrayList<>();
		ArrayList<Callable<Void>> lesExecutions = new ArrayList<>();
		
		for(final IObservateur obser : capteur.getObservateur()){
			
			Callable<Void> tache = new Callable<Void>() {
				@Override
				public Void call() throws Exception {
					obser.actualise(DiffusionAtomique.this);
					return null;
				}
			};
			
			lesExecutions.add(tache);
			lesRetours.add(exec.submit(tache));
		}
		for(Future<Void> future : lesRetours){
			try {
				// S'assurer du retour
				future.get();
				System.out.println("RETOUR GET FUTURE");
				System.out.flush();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}


	@Override
	public int recupererValeur() {
		return capteur.getValue();
	}

	
}
