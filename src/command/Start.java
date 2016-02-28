package command;

import controller.Controller;

public class Start implements Command{

	private Controller controller;
	
	
	public Start(Controller controller) {
		super();
		this.controller = controller;
	}


	public void execute() {
		this.controller.start();
	}

}
