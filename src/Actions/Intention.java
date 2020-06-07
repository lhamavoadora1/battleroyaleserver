package Actions;

import com.google.gson.Gson;

import VOs.Arena;
import VOs.Life;

public abstract class Intention {

	String type;
	protected Life attacker;
	protected Direction direction;
	protected Arena arena;
	
	public Intention(String type, Life attacker, Direction direction, Arena arena) {
		this.type      = type;
		this.attacker  = attacker;
		this.direction = direction;
		this.arena     = arena;
	}
	
	public String getSerialized() {
		return (new Gson()).toJson(this);
	}

}
