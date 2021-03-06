package Utils;

import java.io.IOException;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;

public class Util {
	
	public static Object[] setTopItemInArray(Object obj, Object[] array) {
		Boolean isFull = true;
		for (Integer i = 0; i < array.length; i++) {
			if (array[i] == null) {
				array[i] = obj;
				isFull = false;
//				System.out.println("Object set in last array empty position!" + " " + ((Entity)array[i]).getType());
				break;
			}
		}
		if (isFull) {
			System.out.println("Array is full!");
		}
		return array;
	}
	
	public static Object getTopItemFromArray(Object[] array) {
		for (Integer i = array.length - 1; i >= 0; i--) {
			if (array[i] != null) {
//				System.out.println("Getting object from position " + String.valueOf(i) + " " + ((Entity)array[i]).getType());
				return array[i];
			}
		}
//		System.out.println("Array is empty!");
		return null;
	}
	
	public static Object removeTopItemFromArray(Object[] array) {
		for (Integer i = array.length - 1; i >= 0; i--) {
			if (array[i] != null) {
//				System.out.println("Removing object from position " + String.valueOf(i));
				array[i] = null;
				return array[i];
			}
		}
//		System.out.println("Array is empty!");
		return null;
	}
	
	public static String getRequestBody(HttpServletRequest request) throws IOException {
		return request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
	}
	
	public static Boolean isNull(Object obj) {
		return obj == null;
	}
	
	public static String getExceptionMessage(Exception e) {
		return e.getMessage() + " - " + e.getStackTrace().toString();
	}

}
