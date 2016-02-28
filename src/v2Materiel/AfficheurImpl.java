package v2Materiel;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import version2.View;

public class AfficheurImpl  implements Afficheur{

	View view;
	
	public AfficheurImpl(View view){
		this.view=view;
	}
	
	private final int TEMPO_LED = 0;
	private final int BAR_LED = 1;
	
	
	public void allumerLed(int numLed) {
		if(numLed==TEMPO_LED){
			Platform.runLater(new Runnable() {
				public void run() {
					view.getLed1().setFill(Color.GREEN);
			    }
			});
		}
		else if(numLed==BAR_LED){
			Platform.runLater(new Runnable() {
				public void run() {
					view.getLed2().setFill(Color.BLUE);
			    }
			});
		}
		
		
	}

	public void etendreLed(int numLed) {
		if(numLed==TEMPO_LED){
			Platform.runLater(new Runnable() {
				public void run() {
					view.getLed1().setFill(Color.BLACK);
			    }
			});
		}
		else if(numLed==BAR_LED){
			Platform.runLater(new Runnable() {
				public void run() {
					view.getLed2().setFill(Color.BLACK);
			    }
			});
		}
		
	}

	

	public void afficherMesure(int valeurMesure) {
		view.getMesure().setText("Mesure : "+valeurMesure);
		
	}

	public void afficherTempo(float valeurTempo) {
		view.getTemps().setText("Tempo : "+valeurTempo);
		
	}

}
