package Things;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.sun.glass.ui.Menu;

import Actions.*;

public class Queue {
	
	static LinkedHashMap<Long, Intention> queue = new LinkedHashMap<Long, Intention>();
	
	public static LinkedHashMap<Long, Intention> getMap() {
		return getMap(null);
	}
	public static LinkedHashMap<Long, Intention> getMap(Long time) {
		if (time != null) {
			LinkedHashMap<Long, Intention> auxQueue = new LinkedHashMap<Long, Intention>();
			Boolean getItems = false;
			for (Long key : queue.keySet()) {
				if (getItems || key > time) {
					getItems = true;
					auxQueue.put(key, queue.get(key));
				}
			}
			return auxQueue;
		}
		return queue;
	}
	
	public static Integer getSize() {
		return queue.size();
	}
	
	public static void add(Intention intention) {
		Date date = new Date();
		queue.put(date.getTime(), intention);
	}
	public static void add(LinkedHashMap<Long, Intention> intentionMap) throws InterruptedException {
		queue.putAll(intentionMap);
	}
	
	public static Intention remove() {
		Map.Entry<Long, Intention> entry = queue.entrySet().iterator().next();
		Intention first = entry.getValue();
		queue.remove(entry.getKey());
		return first;
	}
	
	public static void unload() throws Exception {
		while (!queue.isEmpty()) {
			Map.Entry<Long, Intention> entry = queue.entrySet().iterator().next();
			Intention first = entry.getValue();
			// execute first intention found calling javascript function to update screen
			queue.remove(entry.getKey());
		}
	}

}
