package command;

import version2.Adapter;

public class CommandLireMateriel implements Command {

private Adapter adapter;
	
	
	public CommandLireMateriel(Adapter adapter) {
		super();
		this.adapter = adapter;
	}


	public void execute() {
		
		adapter.lireMateriel();
	}
}
