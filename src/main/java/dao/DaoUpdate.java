package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.SingleConnection;

public class DaoUpdate {

	private Connection connection;
	
	public DaoUpdate() {
		connection = SingleConnection.getConnection();
	}
	
	public boolean updateUser(int id, String login, String password) throws Exception {
		String sql = "UPDATE public.\"user\" SET login = ?, password = ? WHERE \"ID\" = ?;";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, id);
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
