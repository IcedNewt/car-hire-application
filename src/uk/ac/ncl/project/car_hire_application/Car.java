package uk.ac.ncl.project.car_hire_application;

public interface Car {
	
	int getMaxFuel(); // Maximum capacity of the fuel tank.
	
	int getCurrentFuel(); // Current amount of fuel in the tank.
	void setCurrentFuel(int currentFuel); 
	
	int calculateFuelUsed(); // Calculates the fuel used on the journey.
	int driveCar(int kilometres);	// Simulates the car being driven, to use fuel.
	
	void isTankFull(); // True = tank is full.
	void isCarRented(); // True = car is rented out.

	String getCAR_REGISTRATION();

	void setRented(boolean b);
	
}
