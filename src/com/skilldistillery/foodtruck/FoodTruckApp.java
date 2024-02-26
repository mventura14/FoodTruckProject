package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class FoodTruckApp {
	private int maxTrucks = 5;
	private FoodTruck[] fleet = new FoodTruck[maxTrucks];

	public static void main(String[] args) {

		FoodTruckApp fta = new FoodTruckApp();
		fta.run();

	}

	public void run() {
		Scanner sc = new Scanner(System.in);

		addUserTrucks(sc);
		showMenu();
		menuUserSelection(sc);

		sc.close();
	}

	public void showMenu() {
		System.out.println("--------------------------------");
		System.out.println("1) List all existing food trucks");
		System.out.println("2) Average food truck rating");
		System.out.println("3) Show highest rated food truck");
		System.out.println("4) Quit App");
		System.out.println("--------------------------------");
	}

	public void showTrucks() {
		FoodTruck[] fleetCopy = getTrucks();
		for (FoodTruck trucks : fleetCopy) {
			if (trucks != null) {
				System.out.println(trucks.toString());
			}
		}

	}

	public int getFleetCount() {
		int count = 0;
		for (FoodTruck trucks : fleet) {
			if (trucks != null) {
				count++;
			}

		}
		return count;
	}

	public FoodTruck[] getTrucks() {
		int count = 0;
		FoodTruck[] fleetCopy = new FoodTruck[getFleetCount()];
		for (FoodTruck trucks : fleet) {
			if (trucks != null) {
				fleetCopy[count] = trucks;
				count++;
			}
		}

		return fleetCopy;
	};

	public double getAverageRating() {
		FoodTruck[] fleetCopy = getTrucks();
		double ratingAverage = 0;

		for (FoodTruck truck : fleetCopy) {
			ratingAverage += truck.getRating();
		}

		ratingAverage /= fleetCopy.length;
		return ratingAverage = Math.round(ratingAverage * 10) / 10.0;


	}

	public String getHighRatedFoodTruck() {
		double highestRating = 0;
		FoodTruck bestTruck = null;
		FoodTruck[] fleetCopy = getTrucks();
		for (FoodTruck truck : fleetCopy) {
			if (truck.getRating() > highestRating) {
				bestTruck = truck;
				highestRating = truck.getRating();
			}

		}

		return bestTruck.toString();
	}

	public void menuUserSelection(Scanner sc) {

		boolean selections = true;
		while (selections) {

			showMenu();
			int userSelection = sc.nextInt();
			switch (userSelection) {
			case 1:
				showTrucks();
				break;
			case 2:
				System.out.print("The average rating of our food truck fleet is: ");
				System.out.println(getAverageRating());
				;
				break;
			case 3:
				System.out.println("The Best Food truck:");
				System.out.println(getHighRatedFoodTruck());
				;
				break;
			case 4:
				System.out.println("Thank you for your feedback. Have a nice day.");
				selections = false;
			}

		}
	}

	public void addUserTrucks(Scanner sc) {

		for (int i = 0; i < maxTrucks; i++) {

			System.out.print("Truck name  : ");
			String name = sc.nextLine();
			if (name.equalsIgnoreCase("quit")) {
				System.out.println("Break out works");
				break;
			}
			System.out.print("Truck Food  : ");
			String food = sc.nextLine();
			System.out.print("Truck Rating: ");
			double rating = sc.nextDouble();
			System.out.println("*");
			fleet[i] = new FoodTruck(name, food, rating);
			sc.nextLine();
		}

	};

}
