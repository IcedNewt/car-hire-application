package uk.ac.ncl.project.car_hire_application;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTestClass {
	RentalSystem rentalSystem = RentalSystem.getInstance();
	
	@Test
	public void testLargeCarMaxFuel() { // Testing that the max fuel of a small car is 65.
		int largeCarMaxFuel = LargeCar.createLargeCar().getMaxFuel();
		int expectedMaxFuel = 65;
		assertEquals(largeCarMaxFuel, expectedMaxFuel);
	}
	
	@Test
	public void testSmallCarMaxFuel() { // Testing that the max fuel of a small car is 45.
		int smallCarMaxFuel = SmallCar.createSmallCar().getMaxFuel();
		int expectedMaxFuel = 45;
		assertEquals(smallCarMaxFuel, expectedMaxFuel);
	}
	
	@Test
	public void testLargeCarDrive() {
		DrivingLicence licence1 = rentalSystem.createDrivingLicence("Jonah", "Robinson", 1990, 9, 7, 2010, 4, 28, true);
		rentalSystem.issueCar(licence1,"Large");
		rentalSystem.attemptToDrive(licence1,700);
		
		
		int fuelused = rentalSystem.getCar(licence1).calculateFuelUsed();
		assertEquals(fuelused, 37);
	}
	
	@Test
	public void testSmallCarDrive() {
		DrivingLicence licence1 = rentalSystem.createDrivingLicence("Jonah", "Robinson", 1990, 9, 7, 2015, 4, 28, true);
		rentalSystem.issueCar(licence1,"Small");
		rentalSystem.attemptToDrive(licence1,700);
		
		int fuelused = rentalSystem.getCar(licence1).calculateFuelUsed();
		assertEquals(fuelused, 28);
	}
	
	@Test
	public void testLargeCarAddFuel() {
		DrivingLicence licence1 = rentalSystem.createDrivingLicence("Jonah", "Robinson", 1990, 9, 7, 2010, 4, 28, true);
		rentalSystem.issueCar(licence1,"Large");
		rentalSystem.attemptToDrive(licence1,700);
		
		
		rentalSystem.getCar(licence1).addFuel(5);
		int fuelused = rentalSystem.getCar(licence1).calculateFuelUsed();
		System.out.println(fuelused);
		assertEquals(fuelused, 32);
	}
	
	@Test
	public void testSmallCarAddFuel() {
		DrivingLicence licence1 = rentalSystem.createDrivingLicence("Jonah", "Robinson", 1990, 9, 7, 2015, 4, 28, true);
		rentalSystem.issueCar(licence1,"Small");
		rentalSystem.attemptToDrive(licence1,700);
		
		rentalSystem.getCar(licence1).addFuel(5);
		int fuelused = rentalSystem.getCar(licence1).calculateFuelUsed();
		System.out.println(fuelused);
		assertEquals(fuelused, 23);
	}

}
