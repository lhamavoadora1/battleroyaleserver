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

@WebServlet("/insert")
public class Insert extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public Insert() {
        super();
    }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Body returned: " +  Util.getRequestBody(request));
//		// here call the DAO read Serializable method
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String body = Util.getRequestBody(request);
		
		System.out.println("from server" + body);
		
		response.getWriter().append("Body returned: " + body);
		
		Gson jsonParser = new Gson();
		
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
	}

}
