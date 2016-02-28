package v2Materiel;

import command.Command;

public interface Horloge {

	void activerPeriodiquement(Command command, float periode);
	
	void activerApresDelai(Command command, float delai);
	
	void desactiver(Command command);
}
