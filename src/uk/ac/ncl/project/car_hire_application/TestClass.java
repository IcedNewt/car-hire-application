package uk.ac.ncl.project.car_hire_application;

public class TestClass {
	
	public static void main(String[] args) {
		
		RentalSystem.createCarFleet(20,10);
		
		System.out.println(RentalSystem.availableCars("Large"));	
		
		DrivingLicence licence1 = RentalSystem.createDrivingLicence("Jonah", "Robinson", 1990, 9, 7, 2015, 4, 28, true);
		
		System.out.println(RentalSystem.issueCar(licence1,"Small"));
		
	}
}