package com.jspiders.cardekhocasestudy.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddCar {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	
	public void add(Scanner scanner) {
		
		System.out.println("Enter how many car's you want to add:");
		int count = scanner.nextInt();
		
		try {
			
			openConnection();
			
			for (int i = 1; i <=count; i++) {
				
				System.out.println("Enter car id");
				int id = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter car name");
				String name = scanner.nextLine();
				System.out.println("Enter fuel type");
				String fuel_type = scanner.nextLine();
				System.out.println("Enter car price");
				double price = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Enter car color");
				String color = scanner.nextLine();
				System.out.println("Enter transmission type");
				String transmission_type = scanner.nextLine();
				System.out.println();
				
				query = "INSERT INTO car_details VALUES(?,?,?,?,?,?)";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, name);
				preparedStatement.setString(3, fuel_type);
				preparedStatement.setDouble(4, price);
				preparedStatement.setString(5, color);
				preparedStatement.setString(6, transmission_type);
				preparedStatement.execute();
				
			}
			
			System.out.println("Car(s) details added successfully!!!");
			
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
