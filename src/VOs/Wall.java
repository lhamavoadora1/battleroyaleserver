package VOs;

public class Wall extends Entity {
	
	public Wall() {
		super("Rock", "Wall", false, false, null);
	}
	
	public Wall(String name, String imageUrl) {
		super(name, "Wall", false, false, imageUrl);
	}

}
