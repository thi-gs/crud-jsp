package servletDemo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.DaoLogin;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DaoLogin daoLogin = new DaoLogin();

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try {
						
			String login = request.getParameter("login");
			String password = request.getParameter("password");
		
			if(daoLogin.loginValidation(login, password)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("login-success.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("login-error.jsp");
				dispatcher.forward(request, response);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
