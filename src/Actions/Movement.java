package Actions;
import Utils.*;
import VOs.*;
import Things.*;

public class Movement extends Intention {
	
	public Movement(Life life, Direction direction, Arena arena) {
		super("move", life, direction, arena);
	}
	
	public UI moveUI() throws Exception {
		if (this.isFilled()) {
			switch (direction) {
				case UP:
					return move(this.life, this.direction, this.arena, Axis.Y, 1);
				case DOWN:
					return move(this.life, this.direction, this.arena, Axis.Y, -1);
				case LEFT:
					return move(this.life, this.direction, this.arena, Axis.X, -1);
				case RIGHT:
					return move(this.life, this.direction, this.arena, Axis.X, 1);
			}
			throw new Exception("No value for Direction enum when moving");
		}
		throw new Exception("Movement must be instantiated first!");
	}
	
	UI move(Life life, Direction direction, Arena arena, Axis axis, Integer value) throws Exception {
		
		Entity lookedEntity = look(life, direction, arena);
		
		if (lookedEntity != null && lookedEntity.isWalkable()) {
			
			//start moving
			arena.removeEntityFromCoordinate(life, life.getPosition());
			life.getPosition().change(axis, value);
			arena.setEntityPosition(life);
			//stop moving
			
			Queue.add(this);
			
			return new UI("You move " + direction.toString(), true);
		} else {
			return new UI("You cannot move " + direction.toString() + " more!", false);
		}
		
	}
	
	public UI lookUI() throws Exception {
		if (this.isFilled()) {
			Entity lookedEntity = look(this.life, this.direction, this.arena);
			
			Queue.add(this);
			
			return new UI("You look to a " + lookedEntity.getType(), lookedEntity.isWalkable());
		} else {
			throw new Exception("Movement must be instantiated first!");
		}
	}
	
	Entity look(Life life, Direction direction, Arena arena) throws Exception {
		switch (direction) {
			case UP:
				return arena.getEntityFromCoordinate(life.getPosition().get(Axis.Y, 1));
			case DOWN:
				return arena.getEntityFromCoordinate(life.getPosition().get(Axis.Y, -1));
			case LEFT:
				return arena.getEntityFromCoordinate(life.getPosition().get(Axis.X, -1));
			case RIGHT:
				return arena.getEntityFromCoordinate(life.getPosition().get(Axis.X, 1));
		}
		throw new Exception("No value for Direction enum when looking");
	}

}
