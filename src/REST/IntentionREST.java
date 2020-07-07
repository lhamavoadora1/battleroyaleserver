package REST;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Things.*;
import Utils.Util;

@WebServlet("/IntentionREST")
public class IntentionREST extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IntentionREST() {
        super();
    }
    
	Gson jsonParser = new Gson();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PlayerIntention playerIntention = jsonParser.fromJson(Util.getRequestBody(request), PlayerIntention.class);
		
		Session session = Round.sessionMap.get(Round.playerIdToSessionIdMap.get(playerIntention.playerId));
		
		try {
			
			session.userIntention(playerIntention.intention);
			response.getWriter().append(jsonParser.toJson(new UI("Intention received!", true)));
			
		} catch (Exception e) {
			
			String message = Util.getExceptionMessage(e);
			System.out.println(message);
			response.getWriter().append(jsonParser.toJson(new UI(message, false)));
			
		}
		
	}

}
