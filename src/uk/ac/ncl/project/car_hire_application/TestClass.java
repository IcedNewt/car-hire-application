package uk.ac.ncl.project.car_hire_application;

public class TestClass {
	
	public static String formatCollection(String collectionString){
		return collectionString.replace(",", "").replace("[", " ").replace("]", "").replace("{", " ").replace("}", "").replace("=", " = ");
	}
	
	public static void main(String[] args) {
		
		RentalSystem.createCarFleet(20,10);
		
		System.out.println(RentalSystem.availableCars("Large"));	
		
		DrivingLicence licence1 = RentalSystem.createDrivingLicence("Jonah", "Robinson", 1990, 9, 7, 2015, 4, 28, true);
		DrivingLicence licence2 = RentalSystem.createDrivingLicence("Jonah", "Robinson", 1990, 9, 7, 2015, 4, 28, true);
		
		System.out.println(RentalSystem.issueCar(licence1,"Small"));
		System.out.println(RentalSystem.issueCar(licence1,"Small"));
		System.out.println(RentalSystem.issueCar(licence2,"Small"));
		
		System.out.println(formatCollection(RentalSystem.smallCars.toString()));
		System.out.println(formatCollection(RentalSystem.largeCars.toString()));
		
		System.out.println(formatCollection(RentalSystem.rentedCars.toString()));
	}
}