package VOs;
import Utils.*;

public class Arena {
	
	String name;
	Entity[][][] grid;
	static final Integer CELL_ELEMENTS = 2;
	
	static final Integer MIN_SIZE = 3;
	
	static Integer SET_X_SIZE;
	static Integer SET_Y_SIZE;
	
	void setSizes(Integer size) {
		SET_X_SIZE = size;
		SET_Y_SIZE = size;
	}
	void setSizes(Integer xSize, Integer ySize) {
		SET_X_SIZE = xSize;
		SET_Y_SIZE = ySize;
	}
	
	public Arena() {
		this.name = "normal";
		setSizes(21);
		grid = new Entity[SET_X_SIZE][SET_Y_SIZE][CELL_ELEMENTS];
	}
	public Arena(String name) {
		this.name = name;
		setSizes(21);
		grid = new Entity[SET_X_SIZE][SET_Y_SIZE][CELL_ELEMENTS];
	}
	
	public Arena(Integer xSize, Integer ySide) {
		setSizes(useMinSize(xSize), useMinSize(ySide));
		grid = new Entity[SET_X_SIZE][SET_Y_SIZE][CELL_ELEMENTS];
	}
	
	Integer useMinSize(Integer size) {
		return size >= MIN_SIZE ? size : MIN_SIZE;
	}
	
	public void setEntityPosition(Entity entity) throws Exception {
		
//		System.out.println("ENTITY: " + entity.getType());
		
		Integer valueX = entity.getPosition().get(Axis.X);
		Integer valueY = entity.getPosition().get(Axis.Y);
		
		Entity[] arrayToAddValue = grid[valueX][valueY];
		
		Entity entityInNewPosition = getEntityFromCoordinate(entity.getPosition());
		if (entityInNewPosition instanceof Item && entity instanceof Player) {
			Player player = (Player)entity;
			Item item = (Item)entityInNewPosition;
			if (item.isPickable()) {
				player.setItem(item);
			} else {
//				player.useItem(item);
			}
			removeEntityFromCoordinate(item, item.getPosition());
		}
		Util.setTopItemInArray(entity, arrayToAddValue);
	}
	
	public Entity getEntityFromCoordinate(Coordinate coordinate) throws Exception {
		Integer xValue = coordinate.get(Axis.X);
		Integer yValue = coordinate.get(Axis.Y);
		if (SET_X_SIZE <= xValue || SET_Y_SIZE <= yValue || xValue < 0 || yValue < 0)
			return null;
		return (Entity)Util.getTopItemFromArray(grid[coordinate.get(Axis.X)][coordinate.get(Axis.Y)]);
	}
	
	public void removeEntityFromCoordinate(Entity entity, Coordinate coordinate) throws Exception {
		if (entity == getEntityFromCoordinate(coordinate)) {
			Util.removeTopItemFromArray(grid[coordinate.get(Axis.X)][coordinate.get(Axis.Y)]);
		} else {
			throw new Exception("Instances from entities are different!");
		}
	}
	
	public void resetArena() throws Exception {
		for (Integer i = 0; i < grid.length; i++) {
			for (Integer j = 0; j < grid[i].length; j++) {
				Ground ground = new Ground();
				ground.setPosition(i, j);
				setEntityPosition(ground);
//				Wall wall = new Wall();
//				wall.setPosition(i, j);
//				setEntityPosition(wall);
			}
		}
	}

}
