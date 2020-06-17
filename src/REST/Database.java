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
	
	// Salvar entidades principais do jogo battleroyale no banco para consulta futura
	
	// Caue da Conceição Morelis 081170042
	// Iago Gomes 081170024
	// Carlos Augusto Reis 082170042
	
	private static final long serialVersionUID = 1L;

    public Database() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String body = Util.getRequestBody(request);
		String type = request.getHeader("Type");
		
		System.out.println("from server" + body);
		
//		Boolean hasError = false;
		String message;
		
		MySQL database = new MySQL();
		
		try {
		
			database.insert(body, type);
			
			message = "Success";
		
		} catch (Exception e) {
			message = Util.getExceptionMessage(e);
			System.out.println(message);
		}
		
		response.getWriter().append(message);
		
	}

}
