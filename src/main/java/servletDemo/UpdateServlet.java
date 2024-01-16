package servletDemo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.DaoUpdate;

public class UpdateServlet extends HttpServlet {
	
	DaoUpdate daoEdit = new DaoUpdate();
	
	private static final long serialVersionUID = 1L;
	
    public UpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			
			if(daoEdit.updateUser(id, login, password)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("login-success.jsp");
				dispatcher.forward(request, response);
			} 
		}catch (Exception e){
			e.printStackTrace();
		}
		} 
	}
