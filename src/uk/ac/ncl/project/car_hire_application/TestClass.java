package uk.ac.ncl.project.car_hire_application;

public class TestClass {
	
	// Formats any collection, so that it will display better when output;
	public static String formatCollection(String collectionString){
		return collectionString.replace(", ", "").replace("[", "").replace("]", "").replace("{", "").replace("}", "").replace("=", " = ");
	}
	
	public static void output(String string){
		System.out.println(string);
	}
	
	public static void main(String[] args) {
		
		RentalSystem.createCarFleet(20,10);
		
		output(RentalSystem.availableCars("Large"));	
		output(RentalSystem.availableCars("Small"));
		
		DrivingLicence licence1 = RentalSystem.createDrivingLicence("Jonah", "Robinson", 1990, 9, 7, 2015, 4, 28, true);
		DrivingLicence licence2 = RentalSystem.createDrivingLicence("Jonah", "Robinson", 1985, 9, 7, 2009, 4, 28, true);
		
		output(RentalSystem.issueCar(licence1,"Small"));
		output(RentalSystem.issueCar(licence1,"Small"));
		output(RentalSystem.issueCar(licence2,"Large"));
		
		output(formatCollection(RentalSystem.smallCars.toString()));
		output(formatCollection(RentalSystem.largeCars.toString()));
		
		output(formatCollection(RentalSystem.rentedCars.toString()));
		
		RentalSystem.attemptToDrive(licence1,1500);
		RentalSystem.attemptToDrive(licence1,1500);
		RentalSystem.terminateRental(licence1);
		
		RentalSystem.attemptToDrive(licence2,1500);
		
		RentalSystem.terminateRental(licence2);
		
		RentalSystem.smallCars.get(3).driveCar(100);
		
		output(formatCollection(RentalSystem.rentedCars.toString()));
		output(formatCollection(RentalSystem.smallCars.toString()));
	}
}