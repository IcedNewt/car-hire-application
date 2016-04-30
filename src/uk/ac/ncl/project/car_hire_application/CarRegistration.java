package uk.ac.ncl.project.car_hire_application;

import java.util.*;

public final class CarRegistration {
		
	private final char FIRSTCOMPONENT;
	private final String SECONDCOMPONENT;
	private final String REGISTRATION_NUMBER;
	
	// A HashMap of REGISTRATION_NUMBERS, which is used to ensure that no duplicate registration numbers are created.
	private final static Map<String, CarRegistration> REGISTRATION_NUMBERS = new HashMap<String, CarRegistration>();
	
	private CarRegistration(char firstComponent, String secondComponent,String registrationNumber){
		this.FIRSTCOMPONENT = firstComponent;
		this.SECONDCOMPONENT = secondComponent;
		this.REGISTRATION_NUMBER = registrationNumber;
	}
	
	// Static factory method for creating a CarRegistration object.
	protected final static CarRegistration getInstance(){
		String alphabet= "abcdefghijklmnopqrstuvwxyz";
		char firstComponent = alphabet.charAt((int)(Math.random()*26)); // Generates the first component of the registration number, which is a random char.
		
		String secondComponent = "";
		for(int i = 0; i < 3;i++){
		secondComponent += String.valueOf((int)(Math.random()*9)+1);} // Generates the second component of the registration number, which is 3 random integers.
		final String K = firstComponent+secondComponent; // Concatenates firstComponent and secondComponent to create the registration number.
		
		// Creates a new CarRegistrationNumber if and only if it has a unique registration number, returning the object of a value of null if it in not created.
		if(!REGISTRATION_NUMBERS.containsKey(K)){
			REGISTRATION_NUMBERS.put(K, new CarRegistration(firstComponent,secondComponent,K));	
			return REGISTRATION_NUMBERS.get(K);
		}
		else{
			return null;
		}
		
	}

	public static Map<String, CarRegistration> getREGISTRATION_NUMBERS(){
		return REGISTRATION_NUMBERS;
	}
	
	public char getFIRSTCOMPONENT() {
		return FIRSTCOMPONENT;
	}

	public String getSECONDCOMPONENT() {
		return SECONDCOMPONENT;
	}

	public String getREGISTRATION_NUMBER() {
		
		return REGISTRATION_NUMBER;
	}

}
