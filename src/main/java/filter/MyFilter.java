package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import connection.SingleConnection;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = { "/*" })
public class MyFilter implements Filter{

	// Serve para fazer com que o 'filter' receba a conexão iniciada
	private static Connection connection;
	
	public void init(ServletConfig config)
			   throws ServletException {
		// Para "levantar" a conexão
				connection = SingleConnection.getConnection();
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// Para haver a interceptação dos 'request' e dar o 'response'
		try {
			arg2.doFilter(arg0, arg1);
				
			// Não havendo erros, ocorre o commit
			connection.commit();
		} catch (Exception e) {
			try {
				connection = SingleConnection.getConnection();
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}	
	}
}
