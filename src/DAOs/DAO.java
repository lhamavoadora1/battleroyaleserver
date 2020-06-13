package DAOs;

import java.util.ArrayList;

public interface DAO {
	
	public void insert(Object obj);
	
	public void update(Object obj);
	
	public void delete(Object obj);
	
	public Object find(Object obj);
	
	public ArrayList<Object> findAll(Object obj);

}
