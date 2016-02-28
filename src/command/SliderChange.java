package command;

import controller.Controller;

public class SliderChange implements Command{
	

		private Controller controller;
		
		
		public SliderChange(Controller controller) {
			super();
			this.controller = controller;
		}


		public void execute() {
			this.controller.updateTempo();
		}

	
}
