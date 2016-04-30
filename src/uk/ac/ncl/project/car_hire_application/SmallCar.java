package uk.ac.ncl.project.car_hire_application;

public class SmallCar extends AbstractCar{

	// Constructor that calls the AbstractCar constructor, passing the registration number and the max fuel of the car.
	private SmallCar(String carRegistration){
		super(45,carRegistration);
	}	

	// Static factory method for creating a SmallCar object.	
	public static AbstractCar createSmallCar(){
		String carRegistration = createCarRegistration();
		if(carRegistration != null){
			return new SmallCar(carRegistration);
		}
		return null;
	}	

	// Method which drives the car, fuel usage is calculated using the correct algorithm for a small car, and the result is output.
	public int driveCar(int kilometres){
		int fuelUsed = 0;
		if(getRented()==false){
			output("Car "+getCAR_REGISTRATION()+" has not been rented, no journey is undertaken"+System.lineSeparator());
			return 0;
		}
		if(getCurrentFuel() <= 0){
			output("Car "+getCAR_REGISTRATION()+" has no fuel, no journey is undertaken"+System.lineSeparator());
		}	
		else{
		fuelUsed = ((int) Math.ceil((double)kilometres/25.0));
		setCurrentFuel(getCurrentFuel()-fuelUsed);
		output("Car "+getCAR_REGISTRATION()+" has undertook a journey of "+kilometres+" kilometres has consumed "+fuelUsed+" litres"+System.lineSeparator());
		}
		return fuelUsed;
	}
}
