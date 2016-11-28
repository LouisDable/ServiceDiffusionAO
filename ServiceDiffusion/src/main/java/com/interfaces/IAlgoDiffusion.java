package com.interfaces;

public interface IAlgoDiffusion {

	public void configure(ICapteur capteur);
	public void executeDiffusion();
	public int recupererValeur();
	
}
