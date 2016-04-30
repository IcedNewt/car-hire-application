package uk.ac.ncl.project.car_hire_application;

import java.util.*;

public class RentalSystem {	
	
	static Map<DrivingLicence, Car> rentedCars = new HashMap<DrivingLicence, Car>(); // HashMap holds all the cars that are currently rented out.
	final private static List<Car> SMALLCARS = new ArrayList<Car>(); // ArrayList that holds cars of type SMALL.
	final private static List<Car> LARGECARS = new ArrayList<Car>(); // ArrayList that holds cars of type LARGE.
	
	// Removes duplication of System.out.println().
	public static void output(String string){
		System.out.println(string);
	}
	
	// Determines what type of car is being requested, and if the type is valid.
	public static List<Car> determineType(String typeOfCar){
		if(typeOfCar == "Small"){
			return getSmallcars();
		}
		else if(typeOfCar == "Large"){
			return getLargecars();
		}
		return null;
	}
	
	// Returns the number of available cars, of the passed type.
	public static String availableCars(String typeOfCar){
		List<Car> listOfTypeOfCar = determineType(typeOfCar);

		if (listOfTypeOfCar == null){
			return "That is not a valid type of car, please choose: Small/Large";
		}
		
		int numberOfAvailableCars = listOfTypeOfCar.size();
		for (Car value : rentedCars.values()) {
			for (int i = 0; i < listOfTypeOfCar.size(); i++) {
				if(value.equals(listOfTypeOfCar.get(i))){
					numberOfAvailableCars -= 1;
				}
			}
		}	
		return "Number of cars of type: "+typeOfCar+" = "+Integer.toString(numberOfAvailableCars)+System.lineSeparator();
	}
	
	// If used, ensures that driveCar() is not called on null objects (The specification requires driveCar() to be public, I believe this to be an oversight, 
	// it would be preferable to make it private and force driveCar() to be called through this method, thus eliminating the risk of a null pointer error).
	public static void attemptToDrive(DrivingLicence drivingLicence,int kilometres){
		if(getCar(drivingLicence)!=null){
			getCar(drivingLicence).driveCar(kilometres);
		}
		else{
			output(drivingLicence+" = HAS NO CAR ISSUED TO THEM"+System.lineSeparator());
		}
	}
	
	public static String issueCar(DrivingLicence drivingLicence, String typeOfCar){
		List<Car> listOfTypeOfCar = determineType(typeOfCar);
		
		String invalid = drivingLicence+" = CANNOT BE ISSUED A CAR "+System.lineSeparator(); // Message if the driving licence cannot be assigned a car.
		
		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.setTime(drivingLicence.getDateOfBirth());
		
		Calendar today = Calendar.getInstance();
		today.add(Calendar.MONTH, 1); //Issue with calandar, the month created is out by one, 1 must be added to the month to make it the current time/date.
		
		// Calculates the age of the user.
		int userAge = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
		if (today.get(Calendar.DAY_OF_YEAR) <= dateOfBirth.get(Calendar.DAY_OF_YEAR)){
			userAge-=1;
		}
		
		Calendar dateOfIssue = Calendar.getInstance();
		dateOfIssue.setTime(drivingLicence.getDateOfIssue());
		
		// Calculates the age of licence.
		int licenceAge = today.get(Calendar.YEAR) - dateOfIssue.get(Calendar.YEAR);
		if (today.get(Calendar.DAY_OF_YEAR) <= dateOfIssue.get(Calendar.DAY_OF_YEAR)){
			licenceAge-=1;
		}
		
		// Ensures the driving licence meets the requirements of renting a small car.
		if(typeOfCar == "Small"){
			if((userAge < 21) || (licenceAge<1)){
				return invalid;
			}
		}
		
		// Ensures the driving licence meets the requirements of renting a large car.		
		if(typeOfCar == "Large"){
			if((userAge < 25) || (licenceAge<5)){
				return invalid;
			}
		}
		
		// Ensures the driving licence is a "full licence".
		if(drivingLicence.getIsFullLicence()==false){
			return invalid;
		}
		
		// Checks to see if the driving licence already has a car assigned to it.
		if(rentedCars.containsKey(drivingLicence)){
			return invalid;
		}	
		
		// Checks to see if all the cars of the type requested are already rented.
		boolean allRented = true;
		for(int i = 0; i < listOfTypeOfCar.size(); i++){
			if (listOfTypeOfCar.get(i).getRented() == false){
				allRented = false;
			}
		}
		if(allRented == true){
			return invalid;
		}
		
		for (int i = 0; i < listOfTypeOfCar.size(); i++) {
			if(!(rentedCars.containsValue(listOfTypeOfCar.get(i)))){
				
				rentedCars.put(drivingLicence, listOfTypeOfCar.get(i));
				listOfTypeOfCar.get(i).setRented(true);
				return drivingLicence+" = HAS BEEN ISSUED A CAR = "+listOfTypeOfCar.get(i);
				
			}
		}
		
		return "null";
		
	}	
	
	// Method which terminates the rental of a car.
	public static int terminateRental(DrivingLicence drivingLicence){
		if(rentedCars.containsKey(drivingLicence)){
			rentedCars.get(drivingLicence).setRented(false);
			int fuelUsed = rentedCars.get(drivingLicence).calculateFuelUsed(); // fuelUsed = the fuel used by the car.
			int maxFuel = rentedCars.get(drivingLicence).getMaxFuel(); // maxFuel = the max amount of fuel the car can hold.
			int fuelNeeded = (maxFuel - (maxFuel - fuelUsed)); // Calculate the fuelNeeded to fill the tank.
			rentedCars.get(drivingLicence).setCurrentFuel(rentedCars.get(drivingLicence).getMaxFuel());
			if(fuelNeeded < 0){ // If the car has used more fuel that the max, return the amount of fuel to fill tank from 0, not the negative number.
				output(drivingLicence+" = CAR RENTAL HAS BEEN TERMINATED = "+rentedCars.get(drivingLicence)+" = THE FUEL REQUIRE TO FILL UP THE TANK IS: "+maxFuel+" LITRES"+System.lineSeparator());
				rentedCars.remove(drivingLicence);
				return maxFuel;
			}
			// Return the amount of fuel needed to fill the tank after being driven.
			output(drivingLicence+" = CAR RENTAL HAS BEEN TERMINATED = "+rentedCars.get(drivingLicence)+" = THE FUEL REQUIRE TO FILL UP THE TANK IS: "+(maxFuel - fuelNeeded)+" LITRES"+System.lineSeparator());
			rentedCars.remove(drivingLicence);
			return fuelNeeded;
		}
		return -1; // Returns -1 if the car has not been rented.
	}
	
	// Creates the Calendar objects for the driving licence, then calls the correct factory method in the DrivingLicence class.
	public static DrivingLicence createDrivingLicence(String firstName, String lastName, int yearOfBirth, 
	int monthOfBirth, int dayOfBirth, int yearOfIssue, int monthOfIssue, int dayOfIssue, boolean isFullLicence){
		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.set(yearOfBirth,monthOfBirth,dayOfBirth);
		
		Calendar dateOfIssue = Calendar.getInstance();
		dateOfIssue.set(yearOfIssue,monthOfIssue,dayOfIssue);	
		
		// Creates a new DrivingLicence object.
		return DrivingLicence.createInstance(firstName, lastName, dateOfBirth, dateOfIssue, isFullLicence);
		
	}
	
	// Creates all required car objects and stores them in the correct collection: SMALLCARS/LARGECARS .
	public static void createCarFleet (int numberOfSmall, int numberOfLarge){
		// For loop that ensures that the correct number of objects are stored.
		while(CarRegistration.getREGISTRATION_NUMBERS().size()!=numberOfSmall){
			Car temp = SmallCar.createSmallCar();
			if (temp != null){ // Ensures that no null objects are added to the collection of SMALLCARS.
			getSmallcars().add(temp);}
		}
		// For loop that ensures that the correct number of objects are stored.
		while(CarRegistration.getREGISTRATION_NUMBERS().size()!=(numberOfSmall+numberOfLarge)){
			Car temp = LargeCar.createLargeCar();
			if (temp != null){ // Ensures that no null objects are added to the collection of LARGECARS.
			getLargecars().add(temp);}
		}
	}

	public static List<Car> getSmallcars() {
		return SMALLCARS;
	}

	public static List<Car> getLargecars() {
		return LARGECARS;
	}
	
	public Map<DrivingLicence, Car> getRentedCars(){
		return rentedCars;
	}
	
	// Returns the car assigned to a driving licence, if there is none, then it returns null.
	public static Car getCar(DrivingLicence drivingLicence){
		if(rentedCars.containsKey(drivingLicence)){
			return rentedCars.get(drivingLicence);
		}
		return null;
	}
	
}
