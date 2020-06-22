package Utils;

import Actions.Direction;

public class Coordinate {
	
	private Integer x;
	private Integer y;
	
	public Coordinate(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	public Coordinate(Coordinate coordinate) throws Exception {
		this.x = coordinate.get(Axis.X);
		this.y = coordinate.get(Axis.Y);
	}
	
	public Coordinate change(Axis axis, Integer value) {
		switch (axis) {
			case X:
				this.x += value;
				break;
			case Y:
				this.y += value;
				break;
		}
		return this;
	}
	
	public Integer get(Axis axis) throws Exception {
		switch (axis) {
			case X:
				return this.x;
			case Y:
				return this.y;
		}
		throw new Exception("No Axis to return");
	}
	
	public Coordinate get(Axis axis, Integer value) throws Exception {
		switch (axis) {
			case X:
				return new Coordinate(this.x + value, this.y);
			case Y:
				return new Coordinate(this.x, this.y + value);
		}
		throw new Exception("No Axis to increase");
	}
	
	public Coordinate get(Axis axis, Integer value, Direction direction) throws Exception {
		switch (axis) {
			case X:
				switch (value) {
					case 1:
						switch (direction) {
							case UP:
								new Coordinate(this.x + 1, this.y);
							case DOWN:
								new Coordinate(this.x - 1, this.y);
							case LEFT:
								new Coordinate(this.x, this.y + 1);
							case RIGHT:
								new Coordinate(this.x, this.y - 1);
						}
					case -1:
						switch (direction) {
							case UP:
								new Coordinate(this.x - 1, this.y);
							case DOWN:
								new Coordinate(this.x + 1, this.y);
							case LEFT:
								new Coordinate(this.x, this.y - 1);
							case RIGHT:
								new Coordinate(this.x, this.y + 1);
						}
				}
			case Y:
				switch (value) {
					case 1:
						switch (direction) {
							case UP:
								new Coordinate(this.x, this.y + 1);
							case DOWN:
								new Coordinate(this.x, this.y - 1);
							case LEFT:
								new Coordinate(this.x - 1, this.y);
							case RIGHT:
								new Coordinate(this.x + 1, this.y);
						}
					case -1:
						switch (direction) {
							case UP:
								new Coordinate(this.x, this.y - 1);
							case DOWN:
								new Coordinate(this.x, this.y + 1);
							case LEFT:
								new Coordinate(this.x + 1, this.y);
							case RIGHT:
								new Coordinate(this.x - 1, this.y);
						}
				}
		}
		throw new Exception("No Axis to increase");
	}

}
