package uk.ac.ncl.project.car_hire_application;

import java.util.List;
import java.util.Map;

public interface RentalSystemInterface {
	
	List<Car> determineType(String typeOfCar); // Determines the type of car being requested.
	
	String availableCars(String typeOfCar); // Displays the available cars, of the type requested.
	
	Map<DrivingLicence, Car> getRentedCars(); // Displays the currently rented cars.
	
	Car getCar(DrivingLicence drivingLicence); // Gets the car assigned to a driving licence.
	
	String issueCar(DrivingLicence drivingLicence, String typeOfCar); // Issues a car to a driving licence.	
	
	int terminateRental(DrivingLicence drivingLicence); // Terminates the rental of a car, which is assigned to a driving licence.
	
	DrivingLicence createDrivingLicence(String firstName, String lastName, int yearOfBirth, int monthOfBirth, 
	int dayOfBirth, int yearOfIssue, int monthOfIssue, int dayOfIssue, boolean isFullLicence); // Creates the Calendar objects for a DrivingLicence object, 																			   // and calls the method to create the object.
	
	void createCarFleet (int numberOfSmall, int numberOfLarge); // Creates a set number of LargeCar and SmallCar objects for the rental system.

	Object getSmallcars();
	Object getLargecars();
		
}
