package com.jspiders.cardekhocasestudy.main;

import java.util.Scanner;

import com.jspiders.cardekhocasestudy.operations.AddCar;
import com.jspiders.cardekhocasestudy.operations.DeleteCar;
import com.jspiders.cardekhocasestudy.operations.SearchCar;
import com.jspiders.cardekhocasestudy.operations.UpdateCar;
import com.jspiders.cardekhocasestudy.operations.ViewCar;

public class CarMain {

	static boolean flag = true;
	private static AddCar addCar = new AddCar();
	private static ViewCar viewCar = new ViewCar();
	private static SearchCar searchCar = new SearchCar();
	private static UpdateCar updateCar = new UpdateCar();
	private static DeleteCar deleteCar = new DeleteCar();

	public static void main(String[] args) {

		mainMenu();

	}

	private static void mainMenu() {

		Scanner scanner = new Scanner(System.in);

		while (flag) {

			System.out.println("==========MAIN MENU==========\n");
			System.out.println("1) Add car detail(s)\n" + "2) View car detail(s)\n" + "3) Search car detail(s)\n"
					+ "4) Update car detail(s)\n" + "5) Delete car detail(s)\n" + "6) Exit\n" + "\n"
					+ "Enter your choice");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				addCar.add(scanner);
				mainMenu();
				break;

			case 2:
				viewCar.view();
				mainMenu();
				break;

			case 3:
				searchCar();
				mainMenu();
				break;

			case 4:
				updateCar();
				mainMenu();
				break;

			case 5:
				deleteCar.deleteCarById(scanner);
				mainMenu();
				break;

			case 6:
				System.out.println("Thank you!!!");
				flag = false;
				break;

			default:
				System.out.println("Invalid choice");
				break;
			}

		}

	}

	private static void searchCar() {

		Scanner scanner = new Scanner(System.in);

		while (flag) {

			System.out.println("==========SEARCH MENU==========\n");
			System.out.println("1) Search car by id\n" + "2) Search car by name\n" + "3) Search car by fuel_type\n"
					+ "4) Search car by price\n" + "5) Search car by color\n" + "6) Search car by transmission_type\n"
					+ "7) Exit to main menu\n" + "\n" + "Enter your choice");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				searchCar.searchById(scanner);
				searchCar();
				break;

			case 2:
				searchCar.searchByName(scanner);
				searchCar();
				break;

			case 3:
				searchCar.searchByFuel(scanner);
				searchCar();
				break;

			case 4:
				searchCar.searchByPrice(scanner);
				searchCar();
				break;

			case 5:
				searchCar.searchByColor(scanner);
				searchCar();
				break;

			case 6:
				searchCar.searchByTransmission(scanner);
				searchCar();
				break;

			case 7:
				mainMenu();
				break;

			default:
				System.out.println("Invalid choice");
				break;
			}

		}

	}
	
	private static void updateCar() {

		Scanner scanner = new Scanner(System.in);

		while (flag) {

			System.out.println("==========UPDATE CAR MENU==========\n");
			System.out.println("1) Update car by name\n" + "2) Update car by fuel_type\n"
					+ "3) Update car by price\n" + "4) Update car by color\n" + "5) Update car by transmission_type\n"
					+ "6) Exit to main menu\n" + "\n" + "Enter your choice");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				updateCar.updateName(scanner);
				updateCar();
				break;

			case 2:
				updateCar.updateFuelType(scanner);
				updateCar();
				break;

			case 3:
				updateCar.updatePrice(scanner);
				updateCar();
				break;

			case 4:
				updateCar.updateColor(scanner);
				updateCar();
				break;

			case 5:
				updateCar.updateTransmissionType(scanner);
				updateCar();
				break;

			case 6:
				mainMenu();
				break;

			default:
				System.out.println("Invalid choice");
				break;
			}

		}

	}

}
