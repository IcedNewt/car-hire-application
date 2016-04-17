package uk.ac.ncl.project.car_hire_application;

import java.util.*;

public class RentalSystem {	
	
	Map<DrivingLicence, Car> rentedCars = new HashMap<DrivingLicence, Car>();
	
	public int availableCars(Car typeOfCar){
		return 0;
	}
	
	public Map getRentedCars(){
		
		return rentedCars;
	}
	
	public String getCar(DrivingLicence drivingLicence, Car typeOfCar){
		return "null";
	}
	
	public void issueCar(DrivingLicence drivingLicence, Car typeOfCar){
		
	}
	
	public void terminateRental(DrivingLicence drivingLicence){
		
	}
	
	public static void createCarFleet (int numberOfSmall, int numberOfLarge){
		while(CarRegistration.getREGISTRATION_NUMBERS().size()!=numberOfSmall){
			new SmallCar();
		}
		while(CarRegistration.getREGISTRATION_NUMBERS().size()!=(numberOfSmall+numberOfLarge)){
			new LargeCar();
		}
		System.out.println(CarRegistration.getREGISTRATION_NUMBERS().size());
	}
	
}
