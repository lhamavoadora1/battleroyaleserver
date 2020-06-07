package Utils;

import java.time.LocalDate;
import java.time.LocalTime;

public class Key {
	
	public static String generate() {
		LocalDate date = LocalDate.now();
//	    System.out.println(date);
	    LocalTime time = LocalTime.now();
//	    System.out.println(time);
	    String datetime = date.toString() + "-" + time.toString();
//	    System.out.println(datetime);
	    String key = "";
	    for (Integer i : datetime.chars().toArray()) {
	    	key += String.valueOf(i);
	    }
//	    System.out.println(key);
		return key;
	}

}
