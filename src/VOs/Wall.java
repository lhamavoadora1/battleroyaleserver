package VOs;

public class Wall extends Entity {
	
	public Wall() {
		super("Wall", false, false, null);
	}
	
	public Wall(String imageUrl) {
		super("Wall", false, false, imageUrl);
	}

}
