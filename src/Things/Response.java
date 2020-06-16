package Things;

public class Response {
	
	String message;
	Boolean success;
	
	public Response(String message, Boolean success) {
		this.message = message;
		this.success = success;
	}
	public Response(String message) {
		this.message = message;
		this.success = false;
	}

}
