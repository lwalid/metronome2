package v2Materiel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import command.Command;



public class HorlogeImpl implements Horloge{

	
	private List<PeriodicTask> tasks = new ArrayList<PeriodicTask>();
	

	public void activerPeriodiquement(Command cmd, float periodeEnSecondes) {
		
		PeriodicTask task = new PeriodicTask(cmd,(int)(periodeEnSecondes*1000));
		task.start();
		tasks.add(task);	
	}

	public void activerApresDelai(Command cmd, float delaiEnSecondes) {
		try{
			Thread.sleep((int)(delaiEnSecondes*1000));
			cmd.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void desactiver(Command cmd) {
		for(int i = 0; i<tasks.size(); i++){
			if(tasks.get(i).getCommand().equals(cmd)){
				tasks.get(i).stop();
				tasks.remove(i);
			}
		}
		
	}
	
	
	private class PeriodicTask{

		private Command command;
		private int msPeriode;
		private Timer timer = new Timer();
		
		public PeriodicTask(Command command, int msPeriode){
			this.command = command;
			this.msPeriode = msPeriode;
		}
		
		public Command getCommand(){
			return command;
		}
		
		public void start(){
			
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					command.execute();  
				}
			};
			timer.scheduleAtFixedRate(task, 0, msPeriode);
		}
		public void stop(){
			timer.cancel();
		}
		}

}
