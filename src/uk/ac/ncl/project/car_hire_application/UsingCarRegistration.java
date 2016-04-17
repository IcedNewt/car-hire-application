package uk.ac.ncl.project.car_hire_application;

public class UsingCarRegistration {

	public static void main(String[] args) {
		
		CarRegistration a = CarRegistration.getInstance("a", "1234");
		
		CarRegistration.getRegistrationNumbers();
	}
	
}
