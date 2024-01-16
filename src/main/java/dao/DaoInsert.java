package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.SingleConnection;

public class DaoInsert {

	private Connection connection;
	
	public DaoInsert() {
		connection = SingleConnection.getConnection();
	}
	
	public boolean insertUser(String login, String password) throws Exception {
		String sql = "INSERT INTO public.\"user\"(login, password) VALUES (?, ?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.execute();
            connection.commit();
            
            return true;
        } catch (Exception e) {
        	e.printStackTrace();
        	
        	try {
        		connection.rollback();
        	} catch (SQLException e1){
        		e1.printStackTrace();
        	}
            return false;
        }
	}
	
}
