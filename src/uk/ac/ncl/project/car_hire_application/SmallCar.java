package uk.ac.ncl.project.car_hire_application;

public class SmallCar extends AbstractCar{
	
	SmallCar(String carRegistration){
		super(45,carRegistration);
	}	
	
	public static AbstractCar createSmallCar(){
		String carRegistration = createCarRegistration();
		if(carRegistration != null){
			return new SmallCar(carRegistration);
		}
		return null;
	}	
	
	public int driveCar(int kilometers){
		int fuelUsed = 0;
		fuelUsed = ((int) Math.ceil((double)kilometers/25.0));
		setCurrentFuel(getCurrentFuel()-fuelUsed);

		return fuelUsed;
	}
}
