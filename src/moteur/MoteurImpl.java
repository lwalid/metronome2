package moteur;

import command.Command;
import v2Materiel.Horloge;
import v2Materiel.HorlogeImpl;

public class MoteurImpl implements Moteur {

	private float tempo;
	private Command tic;
	private Command marquerTemps;
	private Command marquerMesure;
	private boolean etat;
	private int nbTemps;
	private int nbTempsCourant;
	
	private Horloge horloge;
   
	public MoteurImpl() {

		this.etat = false;
		this.tempo = 40;
		this.nbTemps = 3;
		this.nbTempsCourant = 1;
		
	}

	public float getTempo() {
		return tempo;
	}

	
	public void setTempo(float tempo) {
		this.tempo = tempo;

	}

	public boolean getEtat() {
		return this.etat;
	}

	public void setEtat(boolean etat) {
		if (this.etat != etat) {
			this.etat = etat;
			if (this.etat == true) {
				
				if (this.horloge == null) {
				this.horloge = new HorlogeImpl();
				}

				this.horloge.activerPeriodiquement(tic, 60 / tempo);
				this.horloge.activerPeriodiquement(marquerTemps, 60 / tempo);
				this.horloge.activerPeriodiquement(marquerMesure, (60 / tempo)*nbTemps);
			}
		} 
		if(this.etat == false){
			this.horloge.desactiver(tic);
			this.horloge.desactiver(marquerTemps);
			this.horloge.desactiver(marquerMesure);
		}
	}

	public void tick() {
		tic.execute();
	}
	

	public void setCmdMarquerTemps(Command cmd) {
		this.marquerTemps = cmd;
	}

	public void setCmdMarquerMesure(Command cmd) {
		this.marquerMesure = cmd;

	}
	
	public void setCmdTic(Command cmd){
		this.tic = cmd;
	}
	
	public void cmdMarquerTemps(){
			marquerTemps.execute();
		
	}
	
	public void cmdMarquerMesure(){
			marquerMesure.execute();
		
	}

	public int getNbTemps() {
		return nbTemps;
	}

	public void setNbTemps(int nbTemps) {
		
			this.nbTemps = nbTemps;
		
	}

	public Horloge getHorloge() {
		return horloge;
	}

	public void setHorloge(Horloge horloge) {
		this.horloge = horloge;
	}

	


}
