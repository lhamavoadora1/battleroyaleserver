package Actions;

import VOs.*;

public class Command {
	
	public static void set(String type, Life life, Direction direction, Arena arena) throws Exception {
		
		switch (type) {
			case "attack":
				Action.attackUI(life, direction, arena);
				break;
			case "move":
				Movement.moveUI(life, direction, arena);
				break;	
		}
		
	}

}
