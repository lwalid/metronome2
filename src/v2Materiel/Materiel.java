package v2Materiel;

import version2.View;

public class Materiel {

	
	static View view;
	
	Materiel(View view){
		this.view=view;
	}
	
	private static Afficheur afficheur = new AfficheurImpl(view);
	private static EmetteurSonore emetteurSonore = new EmetteurSonoreImpl(view);
	private static Molette molette = new MoletteImpl(view);
	private static Clavier clavier= new ClavierImpl(view);
	
	
	public static Molette getMolette() {
		return molette;
	}

	public static Clavier getClavier() {
		return clavier;
	}

	public static void setClavier(Clavier clavier) {
		Materiel.clavier = clavier;
	}

	public static EmetteurSonore getEmetteurSonore() {
		return emetteurSonore;
	}

	public static Afficheur getAfficheur() {
		return afficheur;
	}

	public static void setAfficheur(Afficheur afficheur) {
		Materiel.afficheur = afficheur;
	}

	public static void setEmetteurSonore(EmetteurSonore emetteurSonore) {
		Materiel.emetteurSonore = emetteurSonore;
	}

	public static void setMolette(Molette molette) {
		Materiel.molette = molette;
	}

	
}
