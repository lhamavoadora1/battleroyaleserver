package Things;

import VOs.Serializable;

public class UI {
	
	public String message;
	public Boolean confirmation;
	public Serializable serializable;
	
	public UI(String message) {
		this.message = message;
	}
	public UI(String message, Boolean confirmation) {
		this.message      = message;
		this.confirmation = confirmation;
	}
	public UI(String message, Boolean confirmation, Serializable serializable) {
		this.message      = message;
		this.confirmation = confirmation;
		this.serializable = serializable;
	}

}
