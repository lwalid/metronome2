package version2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import command.Command;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import v2Materiel.Afficheur;
import v2Materiel.AfficheurImpl;
import v2Materiel.Clavier;
import v2Materiel.ClavierImpl;
import v2Materiel.EmetteurSonore;
import v2Materiel.EmetteurSonoreImpl;
import v2Materiel.Horloge;
import v2Materiel.HorlogeImpl;
import v2Materiel.Molette;
import v2Materiel.MoletteImpl;
import vue.Ihm;

public class View implements Ihm{
	
	private Command cmdStart;
	private Command cmdStop;
	private Command cmdIncr;
	private Command cmdDec;
	private Command cmdSlider;
	
	private Adapter adapter;
	private Horloge horloge;
	
	
	Clavier clavier;
	Afficheur afficheur;
	EmetteurSonore emetteurSonore;
	private Molette molette;
	
	
	public View() {
		super();
		
		horloge = new HorlogeImpl();
		
		afficheur = new AfficheurImpl(this);
		clavier = new ClavierImpl(this); 
		emetteurSonore = new EmetteurSonoreImpl(this);
		molette = new MoletteImpl(this);
				
		
	}
	
	
	
	private final int TEMPO_LED = 0;
	private final int BAR_LED = 1;
	
	@FXML
	private Button start;
	
	@FXML
	private Button stop;
	
	@FXML
	private Button inc;
	
	@FXML
	private Button dec;
	
	@FXML
	private TextField temps;
	
	@FXML
	private  TextField mesure;
	
	@FXML
	private Circle led1;
	
	@FXML 
	private Circle led2;
	
	@FXML
	private Slider slider;
	
	
	@FXML
	private void onStart(ActionEvent e){
		 this.getClavier().appuyer(0);
	}

	@FXML
	private void onStop(ActionEvent e){
		this.getClavier().appuyer(1);
	}
	
	@FXML
	private void onDec(ActionEvent e){
		this.getClavier().appuyer(2);
	}
	
	@FXML
	private void onInc(ActionEvent e){
		this.getClavier().appuyer(3);
	}
	
	@FXML
	private void onSliderChanged(MouseEvent e){
		
	}

	

	public TextField getTemps() {
		return temps;
	}

	public void setTemps(TextField temps) {
		this.temps = temps;
	}

	public TextField getMesure() {
		return mesure;
	}

	public void setMesure(TextField mesure) {
		this.mesure = mesure;
	}

	public Circle getLed1() {
		return led1;
	}

	public void setLed1(Circle led1) {
		this.led1 = led1;
	}

	public Circle getLed2() {
		return led2;
	}

	public void setLed2(Circle led2) {
		this.led2 = led2;
	}

	public Slider getSlider() {
		return slider;
	}

	public void setSlider(Slider slider) {
		this.slider = slider;
	}

	public void setCmdStart(Command cmdStart) {
		this.cmdStart = cmdStart;
	}

	public void setCmdStop(Command cmdStop) {
		this.cmdStop = cmdStop;
	}

	public void setCmdIncr(Command cmdIncr) {
		this.cmdIncr = cmdIncr;
	}

	public void setCmdDec(Command cmdDec) {
		this.cmdDec = cmdDec;
	}
	
	public void setCmdSlider(Command cmdSlider){
		this.cmdSlider = cmdSlider;
	}

	
	
	

	
	
	public void allumerLed(int numLed) {
		if(numLed==TEMPO_LED){
			Platform.runLater(new Runnable() {
				public void run() {
					led1.setFill(Color.GREEN);
			    }
			});
		}
		else if(numLed==BAR_LED){
			Platform.runLater(new Runnable() {
				public void run() {
					led2.setFill(Color.BLUE);
			    }
			});
		}
		
		
	}

	public void etendreLed(int numLed) {
		if(numLed==TEMPO_LED){
			Platform.runLater(new Runnable() {
				public void run() {
					led1.setFill(Color.BLACK);
			    }
			});
		}
		else if(numLed==BAR_LED){
			Platform.runLater(new Runnable() {
				public void run() {
					led2.setFill(Color.BLACK);
			    }
			});
		}
		
	}

	

	public void afficherMesure(int valeurMesure) {
		mesure.setText("Mesure : "+valeurMesure);
		
	}

	public void afficherTempo(float valeurTempo) {
		temps.setText("Tempo : "+valeurTempo);
		
	}
	
	public void emettreClic(){
		
		try{
			String url = "res/beep.wav";
			 AudioStream audioStream ;
				
			 InputStream in = new FileInputStream(url);
			  audioStream = new AudioStream(in);
			     AudioPlayer.player.start(audioStream);
			  }  catch (IOException ex) {
		            System.out.println("Error playing the audio file.");
		            ex.printStackTrace();
		        }
	}
	
	public Clavier getClavier(){
		return  clavier;
	}
	
	public Molette getMolette(){
		return molette;
	}

	public Adapter getAdapter() {
		return adapter;
	}

	public void setAdapter(Adapter adapter) {
		this.adapter = adapter;
	}

	public Horloge getHorloge() {
		return horloge;
	}

	public void setHorloge(Horloge horloge) {
		this.horloge = horloge;
	}

	public Afficheur getAfficheur() {
		return afficheur;
	}

	public void setAfficheur(Afficheur afficheur) {
		this.afficheur = afficheur;
	}

	public void setClavier(Clavier clavier) {
		this.clavier = clavier;
	}

	public void setMolette(Molette molette) {
		this.molette = molette;
	}

	public EmetteurSonore getEmetteurSonore() {
		return emetteurSonore;
	}

	public void setEmetteurSonore(EmetteurSonore emetteurSonore) {
		this.emetteurSonore = emetteurSonore;
	}
	
	
}
