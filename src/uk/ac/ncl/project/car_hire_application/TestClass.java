package uk.ac.ncl.project.car_hire_application;

import java.util.Calendar;

public class TestClass {
	
	public static void main(String[] args) {
		
		RentalSystem.createCarFleet(20,10);
		
		System.out.println(RentalSystem.availableCars("Large"));
		
	}
}
