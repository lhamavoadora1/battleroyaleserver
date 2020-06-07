package Actions;
import Utils.*;
import VOs.*;
import Things.*;

public class Movement {
	
	public static UI moveUI(Life life, Direction direction, Arena arena) throws Exception {
		switch (direction) {
			case UP:
				return move(life, direction, arena, Axis.Y, 1);
			case DOWN:
				return move(life, direction, arena, Axis.Y, -1);
			case LEFT:
				return move(life, direction, arena, Axis.X, -1);
			case RIGHT:
				return move(life, direction, arena, Axis.X, 1);
		}
		throw new Exception("No value for Direction enum when moving");
	}
	
	static UI move(Life life, Direction direction, Arena arena, Axis axis, Integer value) throws Exception {
		
		Entity lookedEntity = look(direction, life, arena);
		
		if (lookedEntity != null && lookedEntity.isWalkable()) {
			
			//start moving
			arena.removeEntityFromCoordinate(life, life.getPosition());
			life.getPosition().change(axis, value);
			arena.setEntityPosition(life);
			//stop moving
			
			return new UI("You move " + direction.toString(), true);
		} else {
			return new UI("You cannot move " + direction.toString() + " more!", false);
		}
		
	}
	
	public static UI lookUI(Direction direction, Life entity, Arena arena) throws Exception {
		Entity lookedEntity = look(direction, entity, arena);
		return new UI("You look to a " + lookedEntity.getType(), lookedEntity.isWalkable());
	}
	
	static Entity look(Direction direction, Life life, Arena arena) throws Exception {
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
