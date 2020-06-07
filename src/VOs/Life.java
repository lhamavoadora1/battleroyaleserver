package VOs;

public abstract class Life extends Entity {
	
	protected String name;
	protected Integer lifePoints;
	protected Boolean isUnconscious;
	protected Boolean isDead;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	protected Life(String type, Integer lifePoints, Boolean isWalkable, String imageUrl) {
		super(type, isWalkable, true, imageUrl);
		this.lifePoints    = lifePoints;
		this.isUnconscious = false;
		this.isDead        = false;
	}
	
	public Boolean isUnconscious() {
		return this.isUnconscious;
	}
	
	public Boolean isDead() {
		return this.isDead;
	}
	
	public void damage(Integer value) {
		if (!this.isUnconscious) {
			this.lifePoints -= value;
			if (this.lifePoints <= 0) {
				this.isUnconscious = true;
				this.lifePoints    = 0;
			}
		} else {
			this.isDead = true;
		}
	}

}
