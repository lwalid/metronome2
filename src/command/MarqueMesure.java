package command;

import controller.Controller;

public class MarqueMesure implements Command {

	
	private Controller controller;
	
	
	public MarqueMesure(Controller controller) {
		super();
		this.controller = controller;
	}


	public void execute() {
		this.controller.marquerMesure();
	}

}
