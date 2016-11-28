/**
 * 
 */
package com.interfaces;

/**
 * @author hp
 *
 */
public interface ISujetObserve {
	
	public void ajouterObservateur(IObservateur observateur);
	public void supprimerObservateur(IObservateur observateur);
	public void notification();
	
}
