package command;

import controller.Controller;

public class Increment implements Command{

	private Controller controller;
	
	public Increment(Controller controller) {
		super();
		this.controller = controller;
	}
	
	public void execute() {
		this.controller.incMesure();
		
	}

}
