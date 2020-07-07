package REST;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Things.*;
import Utils.Util;

@WebServlet("/turn")
public class TurnREST extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TurnREST() {
        super();
    }

	HashMap<String, Session> sessionMap;
	HashMap<String, String> playerIdToSessionIdMap;
	
	Gson jsonParser = new Gson();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
			PlayerTime playerTime = jsonParser.fromJson(Util.getRequestBody(request), PlayerTime.class);
			String playerId = playerTime.playerId;
			Long time = playerTime.time;
			
			System.out.println("Received Player Id: " + playerId);
			
			Session session = Round.sessionMap.get(Round.playerIdToSessionIdMap.get(playerId));
			
			Turn turn = new Turn();
			turn.isPlayerTurn = (session.getPlayerIdTurn() == playerId);
			turn.intentionMap = Queue.getMap(time);
			
			response.getWriter().append(jsonParser.toJson(new UI(jsonParser.toJson(turn), true)));
		
		} catch (Exception e) {
			
			String message = Util.getExceptionMessage(e);
			System.out.println(message);
			response.getWriter().append(jsonParser.toJson(new UI(Util.getExceptionMessage(e), false)));
			
		}
		
	}

}
