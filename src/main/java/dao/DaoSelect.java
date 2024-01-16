package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import userBean.UserBean;

public class DaoSelect {
	
	private Connection connection;
	
	 public DaoSelect() {
	        this.connection = SingleConnection.getConnection();
	 }

	public List<UserBean> list(){
		List<UserBean> userList = new ArrayList<UserBean>();
		String sql = "SELECT * FROM public.\"user\"";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				UserBean user = new UserBean();
				
				user.setId(resultSet.getInt("id"));
				user.setLogin(resultSet.getString("login"));
				user.setPassword(resultSet.getString("password"));
				
				userList.add(user);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return userList;
	}
}
