package DAOs;

import java.sql.Connection;
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
		connection = DbUtil.getConnection();
		jsonParser = new Gson();
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
	public Boolean insert(Object obj) throws Exception {
		
		Serializable jsonObj = (Serializable)obj;
		switch (jsonObj.getType()) {
		case "Arena":
			insert((Arena)jsonObj);
			break;
		case "Ground":
			insert((Ground)jsonObj);
			break;
		case "Wall":
			insert((Wall)jsonObj);
			break;
		case "Weapon":
			insert((Weapon)jsonObj);
			break;
		case "Player":
			insert((Player)jsonObj);
			break;
		}
		
		throw new Exception("Type not found: " + jsonObj.getType());
		
	}
	
	Boolean insert(Arena arena) {
		String name = arena.getName();
		String grid = jsonParser.toJson(arena.getGrid());
		// TODO
		return true;
	}
	Boolean insert(Ground ground) {
		String name     = ground.getName();
		String type     = ground.getType();
		String imageUrl = ground.getImageUrl();
		// TODO
		return true;
	}
	Boolean insert(Wall wall) {
		String name     = wall.getName();
		String type     = wall.getType();
		String imageUrl = wall.getImageUrl();
		// TODO
		return true;
	}
	Boolean insert(Weapon weapon) {
		String name     = weapon.getName();
		String type     = weapon.getType();
		String imageUrl = weapon.getImageUrl();
		Integer damage  = weapon.getDamage();
		String distance = jsonParser.toJson(weapon.getImageUrl());
		// TODO
		return true;
	}
	Boolean insert(Player player) {
		String id         = player.getId();
		String name       = player.getName();
		String type       = player.getType();
		String imageUrl   = player.getImageUrl();
		String weaponName = player.getWeapon().getName();
		// TODO
		return true;
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
	
	Boolean update(Arena arena) {
		// TODO
		return true;
	}
	Boolean update(Ground ground) {
		// TODO
		return true;
	}
	Boolean update(Wall wall) {
		// TODO
		return true;
	}
	Boolean update(Weapon weapon) {
		// TODO
		return true;
	}
	Boolean update(Player player) {
		// TODO
		return true;
	}

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
