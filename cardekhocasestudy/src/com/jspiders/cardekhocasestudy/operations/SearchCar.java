package com.jspiders.cardekhocasestudy.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchCar {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;

	public void searchById(Scanner scanner) {

		System.out.println("Enter car id");
		int id = scanner.nextInt();

		try {

			openConnection();
			query = "SELECT * FROM car_details WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				System.out.println("==========Car Details==========\n");
				System.out.println(resultSet.getInt(1)+"  " +resultSet.getString(2)+"  "+resultSet.getString(3)+"  "+resultSet.getDouble(4)+"  "+resultSet.getString(5)+"  "+resultSet.getString(6)+"\n");
			} else {
				System.out.println("Data not found");
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

	public void searchByName(Scanner scanner) {
		
		scanner.nextLine();
		System.out.println("Enter car name");
		String name = scanner.nextLine();

		try {

			openConnection();
			query = "SELECT * FROM car_details WHERE name = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("==========Car Details==========\n");
			while(resultSet.next())
			{
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

	public void searchByFuel(Scanner scanner) {
		
		scanner.nextLine();
		System.out.println("Enter fuel type");
		String fuel_type = scanner.nextLine();

		try {

			openConnection();
			query = "SELECT * FROM car_details WHERE fuel_type = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, fuel_type);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("==========Car Details==========\n");
			while(resultSet.next())
			{
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

	public void searchByPrice(Scanner scanner) {
		
		System.out.println("Enter minimum price");
		double minPrice = scanner.nextDouble();
		System.out.println("Enter maximum price");
		double maxPrice = scanner.nextDouble();

		try {

			openConnection();
			query = "SELECT * FROM car_details WHERE price BETWEEN ? AND ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDouble(1, minPrice);
			preparedStatement.setDouble(2, maxPrice);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("==========Car Details==========\n");
			while(resultSet.next())
			{
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

	public void searchByColor(Scanner scanner) {
		
		scanner.nextLine();
		System.out.println("Enter color");
		String color = scanner.nextLine();

		try {

			openConnection();
			query = "SELECT * FROM car_details WHERE color = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, color);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("==========Car Details==========\n");
			while(resultSet.next())
			{
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

	public void searchByTransmission(Scanner scanner) {
		
		scanner.nextLine();
		System.out.println("Enter transmission type");
		String transmission_type = scanner.nextLine();

		try {

			openConnection();
			query = "SELECT * FROM car_details WHERE transmission_type = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, transmission_type);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("==========Car Details==========\n");
			while(resultSet.next())
			{
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
