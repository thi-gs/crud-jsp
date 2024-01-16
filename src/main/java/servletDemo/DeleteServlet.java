package servletDemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.DaoDelete;

public class DeleteServlet extends HttpServlet {
	
	DaoDelete daoDelete = new DaoDelete();
	
	private static final long serialVersionUID = 1L;
       
    public DeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			
			if(daoDelete.deleteUser(id)) {
				 response.sendRedirect(request.getContextPath() + "/SelectServlet");
			} 
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
