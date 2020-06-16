package DAOs;

import java.util.ArrayList;

public interface DAO {
	
	public Boolean insert(Object obj) throws Exception;
	
	public Boolean update(Object obj) throws Exception;
	
	public Boolean delete(Object obj) throws Exception;
	
	public Object find(Object obj);
	
	public ArrayList<Object> findAll(Object obj);

}
