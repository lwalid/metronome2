package v2Materiel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import version2.View;



public class EmetteurSonoreImpl implements EmetteurSonore {

	View view;
	
	public EmetteurSonoreImpl(View view){
		this.view=view;
	}
	
	public void emettreClic() {
		try{
		String url = "/home/nounou/Bureau/AOC/workspace/metronome/src/beep.wav";
		 AudioStream audioStream ;
			
		 InputStream in = new FileInputStream(url);
		  audioStream = new AudioStream(in);
		     AudioPlayer.player.start(audioStream);
		  }  catch (IOException ex) {
	            System.out.println("Error playing the audio file.");
	            ex.printStackTrace();
	        }
	}

}
