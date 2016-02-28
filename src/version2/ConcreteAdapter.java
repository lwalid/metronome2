package version2;


import command.CommandLireMateriel;
import controller.Controller;
import javafx.scene.control.Slider;
import moteur.Moteur;
import v2Materiel.Horloge;
import v2Materiel.HorlogeImpl;
import vue.Ihm;

public class ConcreteAdapter implements Adapter{

	private Controller controller;
	private View view;
	
	private Horloge horloge;

	private boolean btnStart=false;//1
	private boolean btnStop=false;//2
	private boolean btnPlus=false;//3
	private boolean btnMinus=false;//4

	private float tempo;

	private CommandLireMateriel read;

	public ConcreteAdapter(View view,Controller controller){
		super();
		this.view=view;
		this.controller=controller;
	}
	
	public void lireMateriel() {

		
		boolean oldBtnStart = btnStart;
		btnStart=view.getClavier().touchePres(0);
		if ((btnStart != oldBtnStart )&& btnStart) {
			controller.start();
		}


		boolean oldBtnStop = btnStop;
		btnStop=view.getClavier().touchePres(1);
		if ((btnStop != oldBtnStop )&& btnStop) {
			controller.stop();
		}

		boolean oldBtnPlus = btnPlus;
		btnPlus=view.getClavier().touchePres(2);
		if ((btnPlus != oldBtnPlus )&& btnPlus) {
			controller.incMesure();
		}

		boolean oldBtnMinus = btnMinus;
		btnMinus=view.getClavier().touchePres(3);
		if ((btnMinus != oldBtnMinus )&& btnMinus) {
			controller.decMesure();
		}

		float oldtempo = tempo;
		tempo= view.getMolette().position()*240;
		if (tempo != oldtempo ) {
			controller.updateTempo();
		}

	}
	
	
	
			//--------- methode de IHM --------------//
	
	
	public void allumerLed(int numLed) {
		
		view.getAfficheur().allumerLed(numLed);
		
		
	}

	public void etendreLed(int numLed) {
		view.getAfficheur().etendreLed(numLed);
		
	}

	

	public void afficherMesure(int valeurMesure) {
		view.getAfficheur().afficherMesure(valeurMesure);
		
	}

	public void afficherTempo(float valeurTempo) {
		view.getAfficheur().afficherTempo(valeurTempo);
		
	}
	
	public void emettreClic(){
		
		view.getEmetteurSonore().emettreClic();
		}
	
	public Slider getSlider() {
		return (Slider) view.getSlider();
	}
	
	public boolean getbtnStart(){
		return btnStart;
	}
	
	public boolean getbtnStop(){
		return btnStop;
	}
	
	public boolean getbtnPlus(){
		return btnPlus;
	}
	
	public boolean getbtnMinus(){
		return btnMinus;
	}
	
	public Controller getController(){
		return this;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	
	
	
	// ------------- methode de controller------------ //
	
public void start(){
	controller.start();
}
	
	public void stop(){
		controller.stop();
	}
	
	public void tic(){
		controller.tic();
	}
	
	public void marquerTemps(){
		controller.marquerTemps();
	}
	
	public void marquerMesure(){
		controller.marquerMesure();
	}
	
	public void updateTempo(){
		controller.updateTempo();
	}
	
	public void incMesure(){
		controller.incMesure();
	}
	
	public void decMesure(){
		controller.decMesure();
	}



	public Moteur getMoteur() {
		return controller.getMoteur();
	}



	public void setMoteur(Moteur moteur) {
		controller.setMoteur(moteur);
		
	}



	public Ihm getView() {
		
		return this;
	}



	
	public void setIhm(Ihm view) {
		this.view=(View)view;
		
	}
	
	public void setIhm(View i) {
		this.view= i;
		this.horloge = new HorlogeImpl();
		this.read = new CommandLireMateriel(this);
		this.horloge.activerPeriodiquement(read, (float) 0.05);
	}




}
