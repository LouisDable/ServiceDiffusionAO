/**
 * 
 */
package com.strategies;

import com.interfaces.IAlgoDiffusion;
import com.interfaces.ICapteur;


public abstract class Diffusion implements IAlgoDiffusion {
	ICapteur capteur;
	int nbObservateur;

	public void configure(ICapteur cpt) {
		this.capteur=cpt;
		this.nbObservateur=cpt.getObservateur().size();
		
	}

	abstract public void executeDiffusion();

	abstract public int recupererValeur();
	

}
