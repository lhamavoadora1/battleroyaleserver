package VOs;

public class Item extends Life {
	
	protected Boolean isPickable;

	protected Item() {
		super("Dew", "Item", 1, true, null);
		this.isPickable = false;
	}

	protected Item(String name, String imageUrl) {
		super(name, "Item", 1, true, imageUrl);
		this.isPickable = false;
	}
	
	public Boolean isPickable() {
		return this.isPickable;
	}

}
