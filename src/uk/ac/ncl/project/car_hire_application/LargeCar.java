package uk.ac.ncl.project.car_hire_application;

public class LargeCar extends AbstractCar {
	
	LargeCar(String carRegistration){
		super(65,carRegistration);
	}	
	
	public static AbstractCar createLargeCar(){
		String carRegistration = createCarRegistration();
		if(carRegistration != null){
			return new LargeCar(carRegistration);
		}
		return null;
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
