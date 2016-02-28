package moteur;

import command.Command;
import v2Materiel.Horloge;

public interface Moteur {
	
	/**
	 * return le nombre de batement par minut de moteur
	 * @return
	 */
	public float getTempo();
	
	/**
	 * modifier le nombre de battement par minute de moteur
	 * @param tempo
	 */
	public void setTempo(float tempo);
	
	/**
	 * return l'etat du moteur si ca marche ou non
	 * @return
	 */
	public boolean getEtat();
	
	/**
	 * modifier l etat du moteur 
	 * @param enMarche
	 */
	public void setEtat(boolean enMarche);
	
	/**
	 * afecter la commande marquerTemps au moteur
	 * @param cmd
	 */
	public void setCmdMarquerTemps(Command cmd);
	
	/**
	 * affecter la commande marquerMesure au moteur
	 * @param cmd
	 */
	public void setCmdMarquerMesure(Command cmd);
	
	
	/**
	 * affecter la command tic au moteur
	 * @param cmd
	 */
	public void setCmdTic(Command cmd);
	
	/**
	 * modifier le nbtemps 
	 * @param nbTemps
	 */
	public void setNbTemps(int nbTemps) ;
	
	/**
	 * return le nbtemps
	 * @return
	 */
	public int getNbTemps();

	/**
	 * allumer led 1 
	 */
	public void cmdMarquerTemps();
	/**
	 * allumer led 2
	 */
	public void cmdMarquerMesure();
	/**
	 * emmetre un clic sonor
	 */
	public void tick();
	
	/**
	 * return l horloge
	 * @return
	 */
	public Horloge getHorloge();
	
	/**
	 * modifier l horloge
	 * @param horloge
	 */
	public void setHorloge(Horloge horloge);
	
	
}
