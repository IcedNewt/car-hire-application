package uk.ac.ncl.project.car_hire_application;

public class TestClass {
	
	// Formats any collection, so that it will display better when output.
	public static String formatCollection(String collectionString){
		return collectionString.replace(", ", "").replace("[", "").replace("]", "").replace("{", "").replace("}", "").replace("=", " = ");
	}
	
	// Removes duplication of System.out.println().
	public static void output(String string){
		System.out.println(string);
	}
	
	public static void main(String[] args) {
		
		RentalSystem rentalSystem = RentalSystem.getInstance();
		
		RentalSystem secondRentalSystem = RentalSystem.getInstance();
		
		output(rentalSystem.availableCars("Large"));	
		output(rentalSystem.availableCars("Small"));
		
		DrivingLicence licence1 = rentalSystem.createDrivingLicence("Jonah", "Robinson", 1990, 9, 7, 2015, 4, 28, true);
		DrivingLicence licence2 = rentalSystem.createDrivingLicence("Jonah", "Robinson", 1985, 9, 7, 2009, 4, 28, true);
		
		output(rentalSystem.issueCar(licence1,"Small"));
		output(rentalSystem.issueCar(licence1,"Small"));
		output(rentalSystem.issueCar(licence2,"Large"));
		
		for(int i = 0;i<10;i++){
			output(rentalSystem.issueCar(rentalSystem.createDrivingLicence("Jonah", "Robinson", 1985, 9, 7, 2009, 4, 28, true),"Large"));
		}
		
		output(formatCollection(rentalSystem.getSmallcars().toString()));
		output(formatCollection(rentalSystem.getLargecars().toString()));
		
		output(formatCollection(rentalSystem.getRentedCars().toString()));
		
		rentalSystem.attemptToDrive(licence1,1500);
		rentalSystem.attemptToDrive(licence1,1500);
		rentalSystem.terminateRental(licence1);
		
		rentalSystem.attemptToDrive(licence2,1500);
		
		rentalSystem.terminateRental(licence2);
		
		rentalSystem.getSmallcars().get(3).driveCar(100);
		
		output(formatCollection(rentalSystem.getRentedCars().toString()));
		output(formatCollection(rentalSystem.getSmallcars().toString()));
		output(formatCollection(rentalSystem.getLargecars().toString()));
	}
}