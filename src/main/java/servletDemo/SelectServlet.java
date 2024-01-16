package servletDemo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.DaoSelect;

public class SelectServlet extends HttpServlet {
	
	DaoSelect daoSelect = new DaoSelect();
	
	private static final long serialVersionUID = 1L;
       
    public SelectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher view = request.getRequestDispatcher("select-table.jsp");
			request.setAttribute("users", daoSelect.list());
			view.forward(request, response);
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
