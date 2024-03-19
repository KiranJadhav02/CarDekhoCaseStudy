package com.jspiders.cardekhocasestudy.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewCar {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;

	public void view() {
		
		try {
			
			openConnection();
			query = "SELECT * FROM car_details";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.execute();
			resultSet = preparedStatement.getResultSet();
			
			System.out.println("==========Car Details==========");
			System.out.println();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"  " +resultSet.getString(2)+"  "+resultSet.getString(3)+"  "+resultSet.getDouble(4)+"  "+resultSet.getString(5)+"  "+resultSet.getString(6)+"\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private static void openConnection() throws SQLException {
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4", "root", "root");
		
	}
	
	private static void closeConnection() throws SQLException {
		
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		
		if (connection != null) {
			connection.close();	
		}
		
	}
	
}
