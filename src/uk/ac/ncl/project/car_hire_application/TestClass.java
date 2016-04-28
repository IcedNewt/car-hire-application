package uk.ac.ncl.project.car_hire_application;

import java.util.*;

public class TestClass {
	
	public static void main(String[] args) {
		
		RentalSystem.createCarFleet(20,10);
		
		System.out.println(RentalSystem.availableCars("Large"));
		
		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.set(1990,9,7);
		
		Calendar dateOfIssue = Calendar.getInstance();
		dateOfIssue.set(2006,10,10);		
		
		DrivingLicence.printLicences();
		
		
		DrivingLicence licence1 = DrivingLicence.createInstance("Jonah", "Robinson", dateOfBirth, dateOfIssue, true);
		
		System.out.println(licence1.getDateOfBirth());
		
		System.out.println(RentalSystem.issueCar(licence1,"Small"));
		
	}
}