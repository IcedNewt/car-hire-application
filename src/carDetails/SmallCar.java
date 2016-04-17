package carDetails;

public class SmallCar extends AbstractCar{
	
	SmallCar(String regNumber){
		super(regNumber,45);
	}	
	
	public int driveCar(int kilometers){
		int fuelUsed = 0;
		fuelUsed = ((int) Math.ceil((double)kilometers/25.0));
		setCurrentFuel(getCurrentFuel()-fuelUsed);
		return fuelUsed;
	}
}
