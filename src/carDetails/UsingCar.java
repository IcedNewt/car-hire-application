package carDetails;

public class UsingCar {

	public static void main(String[] args) {
		Car carA = new LargeCar("Large");
		Car carB = new SmallCar("Small");
		System.out.println(carA.driveCar(50));
		System.out.println(carA.getCurrentFuel());
	}

}
