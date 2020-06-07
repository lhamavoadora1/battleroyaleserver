package VOs;

public class Weapon extends Item {
	
	Integer damage;
	Integer[][] distance;
	
	public Weapon() {
		this.damage   = 1;
		this.distance = new Integer[1][1];
	}
	public Weapon(Integer damage, Integer[][] distance) {
		this.damage   = damage;
		this.distance = distance;
	}
	
	public Integer getDamage() {
		return this.damage;
	}
	
	public Integer[][] getDistance() {
		return this.distance;
	}
	
}
