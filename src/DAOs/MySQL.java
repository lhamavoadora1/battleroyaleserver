package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import com.google.gson.Gson;

import VOs.Arena;
import VOs.Ground;
import VOs.Player;
import VOs.Serializable;
import VOs.Wall;
import VOs.Weapon;

public class MySQL implements DAO {
	
	Connection connection;
	Gson jsonParser;
	
	public MySQL() {
		jsonParser = new Gson();
		connection = DbUtil.getConnection();
	}
	
	public static String buildInsertDml(String table_name, String[] columnArray, String[] valueArray) {
		return "INSERT INTO " + table_name + " (" + String.join(", ", columnArray) + ") " +
			   "VALUES (" + String.join(", ", valueArray) + ")";
	}
	
	public static String buildQuery(String table_name, String[] columnArray, String[] conditionArray, String[] valueArray) {
		return "SELECT * FROM " + table_name + 
			   " WHERE " + buildConditionsUsing("AND", conditionArray, valueArray);
	}
	
	static String buildConditionsUsing(String conditionType, String[] conditionArray, String[] valueArray) {
		LinkedList<String> fullConditionList = new LinkedList<String>();
		for (Integer i = 0; i < conditionArray.length; i++) {
			fullConditionList.add(conditionArray[i] + valueArray[i]);
		}
		return String.join(conditionType, fullConditionList);
	}

	@Override
	public Boolean insert(Object obj, String type) throws Exception {
		
		String body = obj.toString();
		switch (type) {
		case "Arena":
			return insert(jsonParser.fromJson(body, Arena.class));
		case "Ground":
			return insert(jsonParser.fromJson(body, Ground.class));
		case "Wall":
			return insert(jsonParser.fromJson(body, Wall.class));
		case "Weapon":
			return insert(jsonParser.fromJson(body, Weapon.class));
		case "Player":
			return insert(jsonParser.fromJson(body, Player.class));
		}
		
		throw new Exception("Type not found: " + type);
		
	}
	
	void insert(Arena arena) throws SQLException {
		String name  = arena.getName();
		String grid  = jsonParser.toJson(arena.getGrid());
		String query = "INSERT INTO ARENA (ARN_NAME, ARN_GRID) VALUES (?, ?);";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, grid);
			
			stmt.execute();			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
		
	}
	void insert(Ground ground) throws SQLException {
		String name     = ground.getName();
		String type     = ground.getType();
		String imageUrl = ground.getImageUrl();
		String query 	= "INSERT INTO GROUND (GRD_NAME, GRD_TYPE, GRD_IMAGE_URL) VALUES (?, ?, ?);";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, type);
			stmt.setString(3, imageUrl);
			
			stmt.execute();			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
		
	}
	void insert(Wall wall) throws SQLException {
		String name     = wall.getName();
		String type     = wall.getType();
		String imageUrl = wall.getImageUrl();
		String query 	=  "INSERT INTO WALL (WLL_NAME, WLL_TYPE, WLL_IMAGE_URL) VALUES (?, ?, ?);";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, type);
			stmt.setString(3, imageUrl);
			
			stmt.execute();
			connection.close();			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
	void insert(Weapon weapon) throws SQLException {
		String name     = weapon.getName();
		String type     = weapon.getType();
		String imageUrl = weapon.getImageUrl();
		Integer damage  = weapon.getDamage();
		String distance = jsonParser.toJson(weapon.getImageUrl());
		String query 	= "INSERT INTO WEAPON (WPN_NAME, WPN_TYPE, WPN_IMAGE_URL, WPN_DAMAGE, WPN_DISTANCE) VALUES (?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, type);
			stmt.setString(3, imageUrl);
			stmt.setInt(4, damage);
			stmt.setString(5, distance);
			
			stmt.execute();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			if (connection != null) {
				connection.close();
			}
		}

	}
	
	void insert(Player player) throws SQLException {
		String id         = player.getId();
		String name       = player.getName();
		String imageUrl   = player.getImageUrl();
		String weaponName = player.getWeapon().getName();
		String query = "INSERT INTO PLAYER (PLR_ID, PLR_NAME, PLR_IMAGE_URL, FK_WPN_NAME) VALUES (?, ?, ?, ?);";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, id);
			stmt.setString(2, name);
			stmt.setString(3, imageUrl);
			stmt.setString(4, weaponName);
			
			stmt.execute();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	@Override
	public Boolean update(Object obj) throws Exception {
		
		Serializable jsonObj = (Serializable)obj;
		switch (jsonObj.getType()) {
		case "Arena":
			update((Arena)jsonObj);
			break;
		case "Ground":
			update((Ground)jsonObj);
			break;
		case "Wall":
			update((Wall)jsonObj);
			break;
		case "Weapon":
			update((Weapon)jsonObj);
			break;
		case "Player":
			update((Player)jsonObj);
			break;
		}
		
		throw new Exception("Type not found: " + jsonObj.getType());
		
	}
	
	void update(Arena arena) throws SQLException {
/*		String name  = arena.getName();
		String grid  = jsonParser.toJson(arena.getGrid());
		String query = "UPDATE ARENA SET ARN_NAME = ?, ARN_GRID = ? WHERE ARN_NAME = '?';";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, grid);
			stmt.setString(3, name);
			
			stmt.execute();			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
*/	}
	void update(Ground ground) throws SQLException {
/*		String name     = ground.getName();
		String type     = ground.getType();
		String imageUrl = ground.getImageUrl();
		Integer id 		= ground.getId();
		String query 	= "UPDATE GROUND SET GRD_NAME = ?, GRD_TYPE = ?, GRD_IMAGE_URL = ? WHERE GRD_ID = '?';";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, type);
			stmt.setString(3, imageUrl);
			stmt.setInt(4, id);
			
			stmt.execute();			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
*/	}
	void update(Wall wall) throws SQLException {
/*		String name     = wall.getName();
		String type     = wall.getType();
		String imageUrl = wall.getImageUrl();
		Integer id 		= wall.getId();
		String query 	=  "UPDATE WALL SET WLL_NAME = ?, WLL_TYPE = ?, WLL_IMAGE_URL = ? WHERE WLL_ID = ?;";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, type);
			stmt.setString(3, imageUrl);
			stmt.setInt(4, id);
			
			stmt.execute();
			connection.close();			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
*/	}
	void update(Weapon weapon) throws SQLException {
/*		String name     = weapon.getName();
		String type     = weapon.getType();
		String imageUrl = weapon.getImageUrl();
		Integer damage  = weapon.getDamage();
		String distance = jsonParser.toJson(weapon.getImageUrl());
		Integer id		= weapon.getId();
		String query 	= "UPDATE WEAPON SET WPN_NAME = ?, WPN_TYPE = ?, WPN_IMAGE_URL = ?, WPN_DAMAGE = ?, WPN_DISTANCE = ? WHERE WPN_ID = ?;";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, type);
			stmt.setString(3, imageUrl);
			stmt.setInt(4, damage);
			stmt.setString(5, distance);
			stmt.setInt(6, id);
			
			stmt.execute();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
*/	}
	void update(Player player) throws SQLException {
/*		String id         = player.getId();
		String name       = player.getName();
		String type       = player.getType();
		String imageUrl   = player.getImageUrl();
		String weaponName = player.getWeapon().getName();
		Integer id		  = player.getId();
		String query 	  = "UPDATE PLAYER SET FK_WPN_ID = ? WHERE PLR_ID = ?;";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, weaponName);
			stmt.setInt(2, id);

			stmt.execute();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
*/	}

	@Override
	public Boolean delete(Object obj) throws Exception {
		
		Serializable jsonObj = (Serializable)obj;
		switch (jsonObj.getType()) {
		case "Arena":
			delete((Arena)jsonObj);
			break;
		case "Ground":
			delete((Ground)jsonObj);
			break;
		case "Wall":
			delete((Wall)jsonObj);
			break;
		case "Weapon":
			delete((Weapon)jsonObj);
			break;
		case "Player":
			delete((Player)jsonObj);
			break;
		}
		
		throw new Exception("Type not found: " + jsonObj.getType());
		
	}
	
	Boolean delete(Arena arena) {
		// TODO
		return true;
	}
	Boolean delete(Ground ground) {
		// TODO
		return true;
	}
	Boolean delete(Wall wall) {
		// TODO
		return true;
	}
	Boolean delete(Weapon weapon) {
		// TODO
		return true;
	}
	Boolean delete(Player player) {
		// TODO
		return true;
	}

	@Override
	public Object find(Object obj) {
		
		Serializable jsonObj = (Serializable)obj;
		switch (jsonObj.getType()) {
		case "Arena":
			find((Arena)jsonObj);
			break;
		case "Ground":
			find((Ground)jsonObj);
			break;
		case "Wall":
			find((Wall)jsonObj);
			break;
		case "Weapon":
			find((Weapon)jsonObj);
			break;
		case "Player":
			find((Player)jsonObj);
			break;
		}
		
		return null;
	}
	
	void find(Arena arena) {
		// TODO
	}
	void find(Ground ground) {
		// TODO
	}
	void find(Wall wall) {
		// TODO
	}
	void find(Weapon weapon) {
		// TODO
	}
	void find(Player player) {
		// TODO
	}

	@Override
	public ArrayList findAll(Object obj) {
		
		Serializable jsonObj = (Serializable)obj;
		switch (jsonObj.getType()) {
		case "Arena":
			findAll((Arena)jsonObj);
			break;
		case "Ground":
			findAll((Ground)jsonObj);
			break;
		case "Wall":
			findAll((Wall)jsonObj);
			break;
		case "Weapon":
			findAll((Weapon)jsonObj);
			break;
		case "Player":
			findAll((Player)jsonObj);
			break;
		}
		
		return null;
	}
	
	void findAll(Arena arena) {
		// TODO
	}
	void findAll(Ground ground) {
		// TODO
	}
	void findAll(Wall wall) {
		// TODO
	}
	void findAll(Weapon weapon) {
		// TODO
	}
	void findAll(Player player) {
		// TODO
	}

}
