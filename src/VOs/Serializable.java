package VOs;

import com.google.gson.Gson;

public abstract class Serializable {
	
	String name;
	String type;
	
	public Serializable(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getSerialized() {
		return (new Gson()).toJson(this);
	}

}
