package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.SingleConnection;

public class DaoDelete {

	private Connection connection;
	
	public DaoDelete() {
		connection = SingleConnection.getConnection();
	}
	
	public boolean deleteUser(int id) throws SQLException {
		String sql = "DELETE FROM public.\"user\" WHERE \"ID\" = ?;";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
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
