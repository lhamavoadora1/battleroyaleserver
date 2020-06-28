package Things;

import java.util.LinkedList;

import com.sun.glass.ui.Menu;

import Actions.*;
import Main.Round;

public class Queue {
	
	static LinkedList<Intention> queue = new LinkedList<Intention>();
	
	public static Integer getSize() {
		return queue.size();
	}
	public static void add(Intention intention) {
		queue.add(intention);
	}
	public static void add(Intention[] intentionArray) {
		for (Intention intention : intentionArray) {
			queue.add(intention);
		}
	}
	public static void add(LinkedList<Intention> intentionList) {
		queue.addAll(intentionList);
	}
	
	public static Intention remove() {
		Intention first = queue.getFirst();
		queue.removeFirst();
		return first;
	}
	
//	public static void unload() throws Exception {
//		while (!queue.isEmpty()) {
//			Intention first = queue.getFirst();
////			Round.userIntention(first);
//			// execute first intention found calling javascript function to update screen
//			queue.removeFirst();	
//		}
//	}

}
