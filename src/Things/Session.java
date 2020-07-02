package Things;

import java.util.HashMap;

import Utils.Key;
import VOs.*;

public class Session {

	String id;
	Arena arena;
	HashMap<String, Player> playerMap;
	
	public Session() throws Exception {
		this.id        = Key.generate();
		this.arena     = new Arena();
		this.playerMap = new HashMap<String, Player>();
		this.arena.resetArena();
	}
	
	public String getId() {
		return this.id;
	}
	
	public void join(Player player) {
		if (!this.isFull()) {
			this.playerMap.put(player.getId(), player);
		}
	}
	
	public Boolean isFull() {
		return playerMap.size() > 10;
	}
	
	public Boolean containsPlayer(String playerId) {
		return playerMap.containsKey(playerId);
	}

}
