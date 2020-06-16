package REST;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import DAOs.MySQL;
import Utils.*;
import VOs.*;

@WebServlet("/round")
public class Round extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public Round() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		MySQL.buildQuery(table_name, columnArray, conditionArray, valueArray);
		response.getWriter().append("Body returned: " +  Util.getRequestBody(request));
	}
	
}
