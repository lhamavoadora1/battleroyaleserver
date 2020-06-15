package VOs;

import Utils.*;

public class Entity extends Serializable {
	
	protected Boolean isWalkable;
	protected Boolean isAttackable;
	protected Coordinate position;
	protected String imageUrl;

	protected Entity(String name, String type, Boolean isWalkable, Boolean isAttackable, String imageUrl) {
		super(name, type);
		this.isWalkable   = isWalkable;
		this.isAttackable = isAttackable;
		this.imageUrl     = imageUrl;
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

	public String getImageUrl() {
		return this.imageUrl;
	}

}
