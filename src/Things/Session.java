package Things;

import java.util.HashMap;

import com.google.gson.Gson;

import Actions.Action;
import Actions.Intention;
import Actions.Movement;
import Utils.Key;
import VOs.*;

public class Session {

	String id;
	Arena arena;
	Integer currentTurn;
	HashMap<String, Player> playerMap;
	
	static final Integer playerLimit = 10; 
	
	public Session() throws Exception {
		this.id          = Key.generate();
		this.arena       = new Arena();
		this.playerMap   = new HashMap<String, Player>();
		this.arena.resetArena();
		this.currentTurn = -1;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getPlayerIdTurn() {
		return ((Player)this.playerMap.values().toArray()[this.currentTurn]).getId();
	}
	
	public String nextPlayerIdTurn() {
		this.currentTurn++;
		if (playerLimit <= this.currentTurn) {
			this.currentTurn = 0;
		}
		return this.getPlayerIdTurn();
	}
	
	public void join(Player player) {
		if (this.currentTurn == -1) {
			this.currentTurn = 0;
		}
		if (!this.isFull()) {
			this.playerMap.put(player.getId(), player);
		}
	}
	
	public Boolean isFull() {
		return playerMap.size() > playerLimit;
	}
	
	public Boolean containsPlayer(String playerId) {
		return playerMap.containsKey(playerId);
	}
	
	public void userIntention(Intention intention) throws Exception {
		
		if (this.arena == null) {
			System.out.println("Arena is null!");
		} else {
			
			intention.setArena(this.arena);

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

}
