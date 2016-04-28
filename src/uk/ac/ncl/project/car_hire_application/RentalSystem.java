package uk.ac.ncl.project.car_hire_application;

import java.util.*;

public class RentalSystem {	
	
	static Map<DrivingLicence, Car> rentedCars = new HashMap<DrivingLicence, Car>();
	final static List<Car> smallCars = new ArrayList<Car>();
	final static List<Car> largeCars = new ArrayList<Car>();
	
	public static List<Car> determineType(String typeOfCar){
		if(typeOfCar == "Small"){
			return smallCars;
		}
		else if(typeOfCar == "Large"){
			return largeCars;
		}
		return null;
	}
	
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
		return Integer.toString(numberOfAvailableCars);
	}
	
	public Map<DrivingLicence, Car> getRentedCars(){
		return rentedCars;
	}
	
	public Car getCar(DrivingLicence drivingLicence){
		if(rentedCars.containsKey(drivingLicence)){
			return rentedCars.get(drivingLicence);
		}
		return null;
	}
	
	public static String issueCar(DrivingLicence drivingLicence, String typeOfCar){
		List<Car> listOfTypeOfCar = determineType(typeOfCar);
		
		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.setTime(drivingLicence.getDateOfBirth());
		
		Calendar today = Calendar.getInstance();
		today.add(Calendar.MONTH, 1); //Issue with calandar, the month created is out by one, 1 must be added to the month to make it the current time/date.
		int userAge = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
		if (today.get(Calendar.DAY_OF_YEAR) <= dateOfBirth.get(Calendar.DAY_OF_YEAR)){
			userAge-=1;
		}
		
		Calendar dateOfIssue = Calendar.getInstance();
		dateOfIssue.setTime(drivingLicence.getDateOfIssue());
		
		int licenceAge = today.get(Calendar.YEAR) - dateOfIssue.get(Calendar.YEAR);
		if (today.get(Calendar.DAY_OF_YEAR) <= dateOfIssue.get(Calendar.DAY_OF_YEAR)){
			licenceAge-=1;
		}
		
		if(typeOfCar == "Small"){
			if((userAge < 21) || (licenceAge<1)){
				return "A car cannot be issued to you, sorry.";
			}
		}
		
		if(typeOfCar == "Large"){
			if((licenceAge < 25) || (licenceAge<5)){
				return "A car cannot be issued to you, sorry.";
			}
		}
		
		if(drivingLicence.getIsFullLicence()==false){
			return "A car cannot be issued to you, sorry.";
		}
		
		if(rentedCars.containsKey(drivingLicence)){
			return "A car cannot be issued to you, sorry.";
		}	
		
		for (int i = 0; i < listOfTypeOfCar.size(); i++) {
			if(!(rentedCars.containsValue(listOfTypeOfCar.get(i)))){
				
				rentedCars.put(drivingLicence, listOfTypeOfCar.get(i));
				return drivingLicence.getLICENCE_NUMBER()+" has been issued a car, its registration is: "+listOfTypeOfCar.get(i).getCAR_REGISTRATION();
				
			}
		}
		
		return "Null";
		
	}
		

	
	public void terminateRental(DrivingLicence drivingLicence){
		
	}
	
	public static DrivingLicence createDrivingLicence(String firstName, String lastName, int yearOfBirth, 
	int monthOfBirth, int dayOfBirth, int yearOfIssue, int monthOfIssue, int dayOfIssue, boolean isFullLicence){
		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.set(yearOfBirth,monthOfBirth,dayOfBirth);
		
		Calendar dateOfIssue = Calendar.getInstance();
		dateOfIssue.set(yearOfIssue,monthOfIssue,dayOfIssue);	
		
		return DrivingLicence.createInstance(firstName, lastName, dateOfBirth, dateOfIssue, isFullLicence);
		
	}
	
	public static void createCarFleet (int numberOfSmall, int numberOfLarge){
		while(CarRegistration.getREGISTRATION_NUMBERS().size()!=numberOfSmall){
			smallCars.add(new SmallCar());
		}
		while(CarRegistration.getREGISTRATION_NUMBERS().size()!=(numberOfSmall+numberOfLarge)){
			largeCars.add(new LargeCar());
		}
	}
	
}
