package DAOs;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;

import VOs.Arena;
import VOs.Ground;
import VOs.Player;
import VOs.Serializable;
import VOs.Wall;
import VOs.Weapon;

public class MySQL implements DAO {
	
	Connection connection;
	
	public MySQL() {
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
	public void insert(Object obj) {
		
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
		
	}
	
	void insert(Arena arena) {
		// TODO
	}
	void insert(Ground ground) {
		// TODO
	}
	void insert(Wall wall) {
		// TODO
	}
	void insert(Weapon weapon) {
		// TODO
	}
	void insert(Player player) {
		// TODO
	}

	@Override
	public void update(Object obj) {
		
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
		
	}
	
	void update(Arena arena) {
		// TODO
	}
	void update(Ground ground) {
		// TODO
	}
	void update(Wall wall) {
		// TODO
	}
	void update(Weapon weapon) {
		// TODO
	}
	void update(Player player) {
		// TODO
	}

	@Override
	public void delete(Object obj) {
		
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
		
	}
	
	void delete(Arena arena) {
		// TODO
	}
	void delete(Ground ground) {
		// TODO
	}
	void delete(Wall wall) {
		// TODO
	}
	void delete(Weapon weapon) {
		// TODO
	}
	void delete(Player player) {
		// TODO
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
