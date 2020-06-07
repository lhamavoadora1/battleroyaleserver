package VOs;

public abstract class Life extends Entity {
	
	protected Integer lifePoints;
	protected Boolean isUnconscious;
	protected Boolean isDead;
	
	protected Life(String name, String type, Integer lifePoints, Boolean isWalkable, String imageUrl) {
		super(name, type, isWalkable, true, imageUrl);
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
