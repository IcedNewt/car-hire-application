package uk.ac.ncl.project.car_hire_application;

public class LargeCar extends AbstractCar {
	
	// Constructor that calls the AbstractCar constructor, passing the registration number and the max fuel of the car.
	private LargeCar(String carRegistration){
		super(65,carRegistration);
	}	
	
	// Static factory method for creating a LargeCar object.
	public static AbstractCar createLargeCar(){
		String carRegistration = createCarRegistration();
		if(carRegistration != null){
			return new LargeCar(carRegistration);
		}
		return null;
	}	
	
	// Method which drives the car, fuel usage is calculated using the correct algorithm for a large car, and the result is output.
	public int driveCar(int kilometres){
		int fuelUsed = 0;
		if(getRented()==false){
			output("Car "+getCAR_REGISTRATION()+" has not been rented, no journey is undertaken"+System.lineSeparator());
			return 0;
		}
		if(getCurrentFuel() <= 0){
			output("This car has no fuel, no journey is undertaken"+System.lineSeparator());
		}
		else{
		if(kilometres<=50){
			fuelUsed = ((int) Math.ceil((double)kilometres/15));
		}
		else{
			int kilometresNew =kilometres- 50;
			fuelUsed = 4;
			fuelUsed += ((int) Math.ceil((double)kilometresNew/20));
		}
		setCurrentFuel(getCurrentFuel()-fuelUsed);
		output("Car "+getCAR_REGISTRATION()+" has undertook a journey of "+kilometres+" kilometres, which has consumed "+fuelUsed+" litres"+System.lineSeparator());
		}
		return fuelUsed;
	}
}
