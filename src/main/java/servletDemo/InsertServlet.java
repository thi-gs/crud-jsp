package servletDemo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.DaoInsert;

@WebServlet("/servletDemo.SignUpServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DaoInsert daoInsert = new DaoInsert();
       
    public InsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String login = request.getParameter("login");
			String password = request.getParameter("password");
		
			if(daoInsert.insertUser(login, password)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("insert-user-success.jsp");
				dispatcher.forward(request, response);
			} 
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
