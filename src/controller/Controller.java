package controller;

import moteur.Moteur;
import vue.Ihm;


public interface Controller {

	/**
	 * implementation de la command start
	 * demare le moteur 
	 */
	public void start();
	
	/**
	 * implementation de la command stop 
	 * arete le moteur
	 */
	
	public void stop();
	
	/**
	 * implementation de la command tic
	 * Emettre un clic sonore
	 */
	
	public void tic();
	
	/**
	 * implementation de la command marquerTemps
	 * Emettre eclaire pour led 1 
	 */
	
	public void marquerTemps();
	
	/**
	 * implementation de la command marquerMesure
	 * Emettre eclaire pour led 2
	 */
	
	public void marquerMesure();
	
	/**
	 * implementation de la command sliderChange
	 * change le slider
	 */
	
	public void updateTempo();
	
	/**
	 * implemetation de la commande increment
	 * increment le mesure
	 */
	
	public void incMesure();
	
	/**
	 * implemetation de la commande increment
	 * decrement le mesure
	 */
	
	public void decMesure();
	
	
	/**
	 * return le moteur 
	 */
	public Moteur getMoteur();

	/**
	 * seter pour le moteur
	 * @param moteur
	 */
	
	public void setMoteur(Moteur moteur);

	/*
	 * get view
	 */
	public Ihm getView();

	/**
	 * set view
	 * @param view
	 */
	
	public void setIhm(Ihm view);
	
	
	
	
	
}
