package REST;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

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
		
		Boolean hasError = false;
		String message;
		
		Gson jsonParser = new Gson();
		
		try {
		
			Serializable jsonObj = jsonParser.fromJson(body, Serializable.class);
			
			switch (jsonObj.getType()) {
			case "Arena":
				// here call the DAO insert Arena method
				break;
			case "Ground":
				// here call the DAO insert Ground method
				break;
			case "Wall":
				// here call the DAO insert Wall method
				break;
			case "Weapon":
				// here call the DAO insert Weapon method
				break;
			case "Player":
				// here call the DAO insert Player method
				break;
			}
			
			message = "Body returned";
		
		} catch (Exception e) {
			message = Util.getExceptionMessage(e);
		}
		
		response.getWriter().append(message);
		
	}

}
