package uk.ac.ncl.project.car_hire_application;

public class UsingCar {
	
	public static void main(String[] args) {
		Car carA = new LargeCar("a","123");
		Car carB;carB = new SmallCar("a","123");
		Car carC = new LargeCar("a","124");
		
		System.out.println(carA.getCAR_REGISTRATION());
		System.out.println(carA.driveCar(3000));
		System.out.println(carA.getCurrentFuel());
		
		//You need to add a method which tests if this is null before outputting the value.
		System.out.println(carB.getCAR_REGISTRATION());
		System.out.println(carB.driveCar(50));
		System.out.println(carB.getCurrentFuel());
		
		System.out.println(carC.getCAR_REGISTRATION());
		
		System.out.println();
		CarRegistration.getRegistrationNumbers();
	}

}
