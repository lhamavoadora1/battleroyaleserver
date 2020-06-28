package Actions;

import com.google.gson.Gson;

import Utils.Util;
import VOs.Arena;
import VOs.Life;

public class Intention {

	String type;
	protected Life life;
	protected Direction direction;
	transient protected Arena arena;
	
	public String getType() {
		return this.type;
	}
	
	public void setArena(Arena arena) {
		this.arena = arena;
	}
	
	public Intention(String type, Life life, Direction direction, Arena arena) {
		this.type      = type;
		this.life      = life;
		this.direction = direction;
		this.arena     = arena;
	}
	
	public String getSerialized() {
		return (new Gson()).toJson(this);
	}
	
	public Boolean isFilled() {
		return !(Util.isNull(this.life) && Util.isNull(this.direction) && Util.isNull(this.arena));
	}

}
