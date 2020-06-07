package Utils;

import com.google.gson.Gson;

import VOs.Entity;

public class JSON {
	
	static Gson jsonParser;
	
	static {
		jsonParser = new Gson();
	}
	
	public static String serialize(Object obj) {
		return jsonParser.toJson(obj);
	}
	
	public static Object deserialize(String json, Class<Entity> classType) { // fix this
		return jsonParser.fromJson(json, classType);
	}

}
