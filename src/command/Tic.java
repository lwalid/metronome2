package command;

import controller.Controller;

public class Tic implements Command {

	private Controller controller;
	
	
	public Tic(Controller controller) {
		super();
		this.controller = controller;
	}


	public void execute() {
		this.controller.tic();
	}

}
