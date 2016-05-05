package uk.ac.ncl.project.car_hire_application;

public class TestClass {
	
	// Formats any collection, so that it will display better when output.
	public static String formatCollection(String collectionString){
		return collectionString.replace(", ", "").replace("[", "").replace("]", "").replace("{", "").replace("}", "").replace("=", " = ");
	}
	
	// Removes duplication of System.out.println().
	public static void outputln(String string){
		System.out.println(string);
	}
	
	// Removes duplication of System.out.print().
		public static void output(String string){
			System.out.print(string);
		}
		
	
	public static void main(String[] args) {
		
		// Test 1 - tests the RentalSystem class.
		// Test 2 - tests the availableCars() method.
		// Test 3 - tests the issueCar() method.
		// Test 4 - tests the getCar() method.
		// Test 5 - tests the getRentedCars() method.
		// Test 6 - tests the drive() method.
		// Test 7 - tests the terminateRental() method.
		
		RentalSystem rentalSystem = RentalSystem.getInstance(); // Creating the rental system
		
		RentalSystem secondRentalSystem = RentalSystem.getInstance(); // Test 1: To show that the RentalSystem class has the singleton property.
		
		output("Should print the number of large cars, which is 10 || ");outputln(rentalSystem.availableCars("Large")); // Test 2: This method should return the number of cars of a specified type that are available to rent.
		output("Should print the number of small cars, which is 20 || ");outputln(rentalSystem.availableCars("Small")); // "" ""
		
		output("Should print the number of large cars, which is 10 || ");outputln(secondRentalSystem.availableCars("Large")); // Test 1-1: Proof that the RentalSystem class has the singleton property.
		
		DrivingLicence licence1 = rentalSystem.createDrivingLicence("Jonah", "Robinson", 1990, 9, 7, 2015, 4, 28, true);
		DrivingLicence licence2 = rentalSystem.createDrivingLicence("Jonah", "Robinson", 1985, 9, 7, 2009, 4, 28, true);
		
		output("Should print the issue message || ");outputln(rentalSystem.issueCar(licence1,"Small")); // Test 3: This method should correctly issue a small car to a licence, as defined in the specification.
		
		output("Should print the same car information as the car above ^ || ");outputln(rentalSystem.getCar(licence1).toString()); // Test 4: The getCar() method should return the car issued to "licence1", and by use of the toString() method, display the relevant information.
		
		output("Should print the ERROR issue message || ");outputln(rentalSystem.issueCar(licence1,"Small")); // Test 3-1: The licence "licence1" should not be issued a car, as it has already been assigned one.
		output("Should print the issue message || ");outputln(rentalSystem.issueCar(licence2,"Large")); // Test 3: This method should correctly issue a large car to a licence, as defined in the specification.
		
		for(int i = 0;i<10;i++){
			output("Should print the issue message || ");outputln(rentalSystem.issueCar(rentalSystem.createDrivingLicence("Jonah", "Robinson", 1985, 9, 7, 2009, 4, 28, true),"Large"));
		}
		
		output("Should print the ERROR issue message || ");outputln(rentalSystem.issueCar(rentalSystem.createDrivingLicence("Jonah", "Robinson", 1985, 9, 7, 2009, 4, 28, true),"Large")); // Test 3-2: The licence should not be issued a car, as there are no more large cars to be rented.
		
		outputln("Should display all large cars in the system, and they should all be rented out || ");outputln(formatCollection(rentalSystem.getLargecars().toString())); // This will show all large cars in the system.
		
		outputln("Should display all the rented cars in the system, there should be 1 small car and 10 large cars || ");outputln(formatCollection(rentalSystem.getRentedCars().toString())); // Test 5: This method should correctly show all rented cars, as defined in the specification.
		
		output("Should display the drive message, should state 60 litres have been consumed || ");rentalSystem.attemptToDrive(licence1,1500); // Test 6: This method should drive the small car for the specified distance, correctly calculating the fuel used.
		output("Should display the ERROR drive message || ");rentalSystem.attemptToDrive(licence1,1500); // Test 6-1: The car should not be driven, as it currently has no fuel.
		
		outputln("Should display the termination message, and the number of litres needed to fill the tank || ");outputln(Integer.toString(rentalSystem.terminateRental(licence1))); // Test 7: This method should terminate "licence1"'s rental, and return the number of litres needed to fill the tank.

		outputln("Should display all the rented cars in the system, there should be 0 small cars and 10 large cars || ");outputln(formatCollection(rentalSystem.getRentedCars().toString())); // Test 5-1: Should correctly showed the updated rented cars.
		
		output("Should display the drive message, should state 77 litres have been consumed || ");rentalSystem.attemptToDrive(licence2,1500); // Test 6-2: This method should drive the large car for the specified distance, correctly calculating the fuel used.
		
		outputln("Should display the termination message, and the number of litres needed to fill the tank || ");outputln(Integer.toString(rentalSystem.terminateRental(licence2))); // Test 7: This method should terminate "licence2"'s rental, and return the number of litres needed to fill the tank.
		
		DrivingLicence licence3 = rentalSystem.createDrivingLicence("Jonah", "Robinson", 1990, 9, 7, 2015, 4, 28, true);
		
		output("Should print the ERROR issue message || ");outputln(rentalSystem.issueCar(licence3,"Large")); // Test 3-3: The licence "licence3" should not be issued a car, as it has not held there licence for 5 years, which is required for a large car rental.
		
		licence3 = rentalSystem.createDrivingLicence("Jonah", "Robinson", 1990, 9, 7, 2016, 4, 28, true);
		
		output("Should print the ERROR issue message || ");outputln(rentalSystem.issueCar(licence3,"Small")); // Test 3-4: The licence "licence3" should not be issued a car, as it has not held there licence for 1 year, which is required for a small car rental.
		
		licence3 = rentalSystem.createDrivingLicence("Jonah", "Robinson", 1990, 9, 7, 2015, 4, 28, false);
		
		output("Should print the ERROR issue message || ");outputln(rentalSystem.issueCar(licence3,"Small")); // Test 3-5: The licence "licence3" should not be issued a car, as it is not a full licence, which is required for a car rental.
		
		output("should display the ERROR drive message || ");rentalSystem.getSmallcars().get(10).driveCar(100); // Test 6-3: The car should not be driven, it is currently not rented out.
	}
}