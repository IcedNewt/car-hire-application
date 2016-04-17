package uk.ac.ncl.project.car_hire_application;

public class LargeCar extends AbstractCar {
	
	LargeCar(String firstComponent, String secondComponent){
		super(firstComponent,secondComponent,65);
	}	
	
	public int driveCar(int kilometers){
		int fuelUsed = 0;
		if(kilometers<=50){
			fuelUsed = ((int) Math.ceil((double)kilometers/15));
		}
		else{
			kilometers -= 50;
			fuelUsed = 4;
			fuelUsed += ((int) Math.ceil((double)kilometers/20));
		}
		setCurrentFuel(getCurrentFuel()-fuelUsed);
		return fuelUsed;
	}
}
