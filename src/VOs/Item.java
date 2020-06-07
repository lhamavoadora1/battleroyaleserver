package VOs;

public class Item extends Life {
	
	protected Boolean isPickable;

	protected Item() {
		super("Item", 1, true);
		this.isPickable = false;
	}
	
	public Boolean isPickable() {
		return this.isPickable;
	}

}
