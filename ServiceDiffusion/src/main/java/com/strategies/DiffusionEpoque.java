package com.strategies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.interfaces.IObservateur;

public class DiffusionEpoque extends Diffusion {

	HashMap<Integer, Integer> tableValeurs = new HashMap<>();
	int date = 0;

	@Override
	public void executeDiffusion() {
		date++;
		tableValeurs.put(date, capteur.getValue());

		ExecutorService exec = Executors.newFixedThreadPool(nbObservateur);
		ArrayList<Future<Void>> lesRetours = new ArrayList<>();
		ArrayList<Callable<Void>> lesExecutions = new ArrayList<>();

		for (final IObservateur obser : capteur.getObservateur()) {

			Callable<Void> tache = new Callable<Void>() {
				@Override
				public Void call() throws Exception {
					obser.actualise(DiffusionEpoque.this);
					return null;
				}
			};

			lesExecutions.add(tache);
			lesRetours.add(exec.submit(tache));
		}

	}

	@Override
	public int recupererValeur() {
		
		return tableValeurs.get(date);
		
	}

}
