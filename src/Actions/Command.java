package Actions;

import com.google.gson.Gson;

import VOs.*;

public class Command {
	
	static Arena arena;
	
	public static void set(Intention intention, Arena arena) throws Exception {
		
		Gson parser = new Gson();
		
		switch (intention.getType()) {
			case "attack":
				Action act = parser.fromJson(parser.toJson(intention), Action.class);
				act.attackUI();
				break;
			case "move":
				Movement mv = parser.fromJson(parser.toJson(intention), Movement.class);
				mv.moveUI();
				break;
		}
		
	}

}
