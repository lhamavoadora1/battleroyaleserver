package VOs;
import Things.*;

public class Player extends Life {
	
//	private String id;
	private Weapon weapon;
	private Item item;
	
	public Player() {
		super("Player", 5, false);
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
