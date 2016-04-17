package uk.ac.ncl.project.car_hire_application;

public class SmallCar extends AbstractCar{
	
	SmallCar(){
		super(45);
	}	
	
	public int driveCar(int kilometers){
		int fuelUsed = 0;
		fuelUsed = ((int) Math.ceil((double)kilometers/25.0));
		setCurrentFuel(getCurrentFuel()-fuelUsed);

		return fuelUsed;
	}
}
