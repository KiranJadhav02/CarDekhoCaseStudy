package com.jspiders.cardekhocasestudy.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteCar {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	private static int resultSet;
	
	public void deleteCarById(Scanner scanner) {
		
		System.out.println("Enter car id to delete");
		int id = scanner.nextInt();
		
		try {
			
			openConnection();
			query = "DELETE FROM car_details WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeUpdate();
			if (resultSet > 0) {
				System.out.println("car info deleted");
			} else {
				System.out.println("Id not found");
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
