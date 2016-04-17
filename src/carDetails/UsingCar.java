package carDetails;

public class UsingCar {
	
	//Proof that I can upload for MAIN
	//Proof that i can download and upload from LAP
	
	public static void main(String[] args) {
		Car carA = new LargeCar("Large");
		Car carB = new SmallCar("Small");
		System.out.println(carA.driveCar(50));
		System.out.println(carA.getCurrentFuel());
		
		System.out.println(carB.driveCar(2500));
		System.out.println(carB.getCurrentFuel());
		
	}

}
