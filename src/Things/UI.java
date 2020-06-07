package Things;

public class UI {
	
	public String message;
	public Boolean confirmation;
	
	public UI(String message) {
		this.message = message;
	}
	public UI(String message, Boolean confirmation) {
		this.message = message;
		this.confirmation = confirmation;
	}

}
