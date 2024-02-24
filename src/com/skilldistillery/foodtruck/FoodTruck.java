package com.skilldistillery.foodtruck;

public class FoodTruck {
	private static int nextTruckId = 1;
	private int truckId;
	private String name;
	private String foodType;
	private double rating;

	{

	}

	FoodTruck() {
	};

	FoodTruck(String name, String foodType, double rating) {
		this.truckId = nextTruckId;
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		nextTruckId++;
	};

	public static int getNextTruckId() {
		return nextTruckId;
	}

	public static void setNextTruckId(int nextTruckId) {
		FoodTruck.nextTruckId = nextTruckId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getTruckId() {
		return truckId;
	}

	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}



	@Override
	public String toString() {
		return "FoodTruck [truckId=" + truckId + ", name=" + name + ", foodType=" + foodType + ", rating=" + rating
				+ "]";
	}


}
