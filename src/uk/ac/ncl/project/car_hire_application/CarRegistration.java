package uk.ac.ncl.project.car_hire_application;

import java.util.*;

public final class CarRegistration {
		
	private final String FIRSTCOMPONENT;
	private final String SECONDCOMPONENT;
	private final String REGISTRATION_NUMBER;
	private final static Map<String, CarRegistration> registrationNumbers = new HashMap<String, CarRegistration>();
	
	private CarRegistration(String firstComponent, String secondComponent,String registrationNumber){
		this.FIRSTCOMPONENT = firstComponent;
		this.SECONDCOMPONENT = secondComponent;
		this.REGISTRATION_NUMBER = registrationNumber;
	}
	
	public static CarRegistration getInstance(String firstComponent, String secondComponent){
		final String K = firstComponent+secondComponent;
		if(!registrationNumbers.containsKey(K)){
			registrationNumbers.put(K, new CarRegistration(firstComponent,secondComponent,K));	
			return registrationNumbers.get(K);
		}
		else{
			return null;
		}
		
	}
	
	public static void getRegistrationNumbers(){
		for (String key : registrationNumbers.keySet()) {
			System.out.println(key);
		}
	}

	public String getFIRSTCOMPONENT() {
		return FIRSTCOMPONENT;
	}

	public String getSECONDCOMPONENT() {
		return SECONDCOMPONENT;
	}

	public String getREGISTRATION_NUMBER() {
		
		return REGISTRATION_NUMBER;
	}

}
