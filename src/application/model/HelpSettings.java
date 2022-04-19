package application.model;

import java.util.ArrayList;
import java.util.List;

//rappresenta i messaggi di aiuto che possono essere visualizzati dal giocatore
//in fase di gioco, i quali suggeriscono come effettuare determinate azioni
public class HelpSettings {
	private List<String> helpMessages;
	private boolean isOpen;
	
	public HelpSettings(ArrayList<String> helpMessages, boolean isOpen) {
		this.helpMessages = helpMessages;
		this.isOpen= isOpen;
	}
	
	public List<String> getHelpMessages(){
		return helpMessages;
	}
	public boolean isOpen() {
		return isOpen;
	}
	
	public void switchOpenState() {
		isOpen= !isOpen;
	}
	
}
