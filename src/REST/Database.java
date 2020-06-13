package REST;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAOs.MySQL;
import Utils.*;
import VOs.*;

@WebServlet("/database")
public class Database extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public Database() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String body = Util.getRequestBody(request);
		
		System.out.println("from server" + body);
		
//		Boolean hasError = false;
		String message;
		
		Gson jsonParser = new Gson();
		MySQL database = new MySQL();
		
		try {
		
			Serializable jsonObj = jsonParser.fromJson(body, Serializable.class);
			database.insert(jsonObj);
			
//			switch (jsonObj.getType()) {
//			case "Arena":
//				database.insert((Arena)jsonObj);
//				break;
//			case "Ground":
//				database.insert((Ground)jsonObj);
//				break;
//			case "Wall":
//				database.insert((Wall)jsonObj);
//				break;
//			case "Weapon":
//				database.insert((Weapon)jsonObj);
//				break;
//			case "Player":
//				database.insert((Player)jsonObj);
//				break;
//			}
			
			message = "Body returned";
		
		} catch (Exception e) {
			message = Util.getExceptionMessage(e);
		}
		
		response.getWriter().append(message);
		
	}

}
