package uk.ac.ncl.project.car_hire_application;

import java.util.List;
import java.util.Map;

public interface RentalSystemInterface {
	
	List<Car> determineType(String typeOfCar);
	
	String availableCars(String typeOfCar);
	
	Map<DrivingLicence, Car> getRentedCars();
	
	Car getCar(DrivingLicence drivingLicence);
	
	String issueCar(DrivingLicence drivingLicence, String typeOfCar);		
	
	void terminateRental(DrivingLicence drivingLicence);
	
	DrivingLicence createDrivingLicence(String firstName, String lastName, int yearOfBirth, int monthOfBirth, 
	int dayOfBirth, int yearOfIssue, int monthOfIssue, int dayOfIssue, boolean isFullLicence);
	
	void createCarFleet (int numberOfSmall, int numberOfLarge);
		
}
