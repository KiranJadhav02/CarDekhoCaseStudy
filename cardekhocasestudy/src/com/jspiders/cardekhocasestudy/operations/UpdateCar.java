package com.jspiders.cardekhocasestudy.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateCar {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;

	public void updateName(Scanner scanner) {
		
		
		System.out.println("Enter car id");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter new name");
		String name = scanner.nextLine();

		try {

			openConnection();
			query = "UPDATE car_details SET name = ? WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			int res = preparedStatement.executeUpdate();
			
			if (res == 1) {
				System.out.println("Car's name updated successfully");
			} else {
				System.out.println("Data not found");
				System.out.println();
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

	public void updateFuelType(Scanner scanner) {

		System.out.println("Enter car id");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter new fuel type");
		String fuel_type = scanner.nextLine();

		try {

			openConnection();
			query = "UPDATE car_details SET fuel_type = ? WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, fuel_type);
			preparedStatement.setInt(2, id);
			int res = preparedStatement.executeUpdate();
			
			if (res == 1) {
				System.out.println("Car's fuel type updated successfully");
			} else {
				System.out.println("Data not found");
				System.out.println();
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

	public void updatePrice(Scanner scanner) {

		System.out.println("Enter car id");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter new price");
		double price = scanner.nextDouble();

		try {

			openConnection();
			query = "UPDATE car_details SET price = ? WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDouble(1, price);
			preparedStatement.setInt(2, id);
			int res = preparedStatement.executeUpdate();
			
			if (res == 1) {
				System.out.println("Car's price updated successfully");
			} else {
				System.out.println("Data not found");
				System.out.println();
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

	public void updateColor(Scanner scanner) {
		
		System.out.println("Enter car id");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter new color");
		String color = scanner.nextLine();

		try {

			openConnection();
			query = "UPDATE car_details SET color = ? WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, color);
			preparedStatement.setInt(2, id);
			int res = preparedStatement.executeUpdate();
			
			if (res == 1) {
				System.out.println("Car's color updated successfully");
			} else {
				System.out.println("Data not found");
				System.out.println();
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

	public void updateTransmissionType(Scanner scanner) {
		
		System.out.println("Enter car id");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter new transmission type");
		String transmission_type = scanner.nextLine();

		try {

			openConnection();
			query = "UPDATE car_details SET transmission_type = ? WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, transmission_type);
			preparedStatement.setInt(2, id);
			int res = preparedStatement.executeUpdate();
			
			if (res == 1) {
				System.out.println("Car's transmission type updated successfully");
			} else {
				System.out.println("Data not found");
				System.out.println();
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
