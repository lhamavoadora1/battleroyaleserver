package REST;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import DAOs.MySQL;
import Things.Session;
import Things.UI;
import Utils.*;
import VOs.*;

@WebServlet("/round")
public class Round extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public Round() {
        super();
    }

    public static HashMap<String, Session> sessionMap;
    public static HashMap<String, String> playerIdToSessionIdMap;
    
    static {
		sessionMap             = new HashMap<String, Session>();
		playerIdToSessionIdMap = new HashMap<String, String>(); 
    }
	
	Gson jsonParser = new Gson();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		if (sessionMap == null) {
//			sessionMap             = new HashMap<String, Session>();
//			playerIdToSessionIdMap = new HashMap<String, String>(); 
//		}
		
		Session session = null;
		String message = null;
		Boolean confirmation = true;
		try {
			
			session = new Session();
			
			if (sessionMap.isEmpty()) {
				sessionMap.put(session.getId(), session);
			}
			
			String playerId = Util.getRequestBody(request);
			
			System.out.println("Received Player Id: " + playerId);

			Session firstNotFull = null;
			Session containingPlayer = null;
			for (Session sess : sessionMap.values()) {
				
				if (sess.containsPlayer(playerId)) {
					containingPlayer = sess;
				}
				
				if (firstNotFull == null && !sess.isFull()) {
					firstNotFull = sess;
				}
				
			}
			
			if (containingPlayer != null) {
				message = containingPlayer.getId();
			} else if (firstNotFull != null) {
				message = firstNotFull.getId();
				playerIdToSessionIdMap.put(playerId, firstNotFull.getId());
			} else {
				confirmation = false;
				message = "Deu ruim irmão";
				System.out.println(message);
			}
			
		} catch (Exception e) {
			confirmation = false;
			message = Util.getExceptionMessage(e);
			System.out.println(message);
		}
		
		response.getWriter().append(jsonParser.toJson(new UI(message, confirmation)));
		
	}
	
}
