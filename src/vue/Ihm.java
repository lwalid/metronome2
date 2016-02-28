package vue;

import javafx.scene.control.Slider;

public interface Ihm {


	/**
	 * allumer led
	 * @param numLed
	 */
	public void allumerLed(int numLed) ;

	/**
	 * eteindre LED 
	 * @param numLed
	 */
	public void etendreLed(int numLed) ;

	/**
	 * afficher la mesure dans l afficheur
	 * @param valeurMesure
	 */
	public void afficherMesure(int valeurMesure) ;

	/**
	 * afficher tempo dans l afficheur
	 * @param valeurTempo
	 */
	public void afficherTempo(float valeurTempo) ;
	
	/**
	 * emettre clic sonor
	 */
	public void emettreClic();

	/**
	 * return slider 
	 * @return
	 */
	public Slider getSlider();
}
