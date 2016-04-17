package uk.ac.ncl.project.car_hire_application;

import java.util.Map;

public interface RentalSystemInterface {
	
	public int availableCars(Car typeOfCar);
	
	public Map getRentedCars();
	
	public String getCar(String drivingLicence, Car typeOfCar);
	
	public void issueCar(DrivingLicence drivingLicence, Car typeOfCar);
	
	public void terminateRental(DrivingLicence drivingLicence);
		
}
