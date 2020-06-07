package VOs;
import com.google.gson.Gson;

import Utils.*;

public abstract class Entity {
	
	protected String name;
	protected String type;
	protected Boolean isWalkable;
	protected Boolean isAttackable;
	protected Coordinate position;
	protected String imageUrl;

	protected Entity(String name, String type, Boolean isWalkable, Boolean isAttackable, String imageUrl) {
		this.name         = name;
		this.type         = type;
		this.isWalkable   = isWalkable;
		this.isAttackable = isAttackable;
		this.imageUrl     = imageUrl;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}
	
	public Boolean isWalkable() {
		return this.isWalkable;
	}
	
	public Boolean isAttackable() {
		return this.isAttackable;
	}
	
	public void setPosition(Integer xPosition, Integer yPosition) {
		this.position = new Coordinate(xPosition, yPosition);
	}
	public Coordinate getPosition() {
		return this.position;
	}
	
	public String getSerialized() {
		return (new Gson()).toJson(this);
	}

}
