package VOs;

public class Player extends Life {
	
	String id;
	Weapon weapon;
	Item item;
	
	public Player() {
		super("Steve", "Player", 5, false, null);
		this.weapon = new Weapon();
	}
	
	public Player(String id, String name, String imageUrl) {
		super(name, "Player", 5, false, imageUrl);
		this.id     = id;
		this.weapon = new Weapon();
	}
	
	public Weapon setWeapon(Weapon weapon) {
		this.weapon = weapon;
		return this.weapon;
	}
	public Weapon getWeapon() {
		return this.weapon;
	}
	
	public Item setItem(Item item) {
		this.item = item;
		return this.item;
	}
	public Weapon getItem() {
		return this.weapon;
	}
	
	public void heal(Integer value) {
		this.lifePoints    += value;
		this.isUnconscious = false;
	}

}
