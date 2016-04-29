package uk.ac.ncl.project.car_hire_application;

import java.util.*;

public final class CarRegistration {
		
	private final char FIRSTCOMPONENT;
	private final String SECONDCOMPONENT;
	private final String REGISTRATION_NUMBER;
	private final static Map<String, CarRegistration> REGISTRATION_NUMBERS = new HashMap<String, CarRegistration>();
	
	private CarRegistration(char firstComponent, String secondComponent,String registrationNumber){
		this.FIRSTCOMPONENT = firstComponent;
		this.SECONDCOMPONENT = secondComponent;
		this.REGISTRATION_NUMBER = registrationNumber;
	}
	
	protected final static CarRegistration getInstance(){
		String alphabet= "abcdefghijklmnopqrstuvwxyz";
		char firstComponent = alphabet.charAt((int)(Math.random()*26));
		String secondComponent = "";
		for(int i = 0; i < 3;i++){
		secondComponent += String.valueOf((int)(Math.random()*9)+1);}
		final String K = firstComponent+secondComponent;
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
