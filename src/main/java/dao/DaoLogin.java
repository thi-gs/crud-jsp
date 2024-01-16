package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnection;

public class DaoLogin {
	
	private Connection connection;
	
	public DaoLogin() {
		connection = SingleConnection.getConnection();
	}
	
	public boolean loginValidation(String login, String password) throws Exception {
		String sql = "SELECT * FROM public.\"user\" WHERE login = ? AND password = ?";
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Check if there's at least one row in the result set
                return resultSet.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false on error
        }
	}
}
