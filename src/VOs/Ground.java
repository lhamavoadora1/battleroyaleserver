package VOs;

public class Ground extends Entity {
	
	public Ground() {
		super("Plain", "Ground", true, false, null);
	}
	
	public Ground(String name, String imageUrl) {
		super(name, "Ground", true, false, imageUrl);
	}

}
