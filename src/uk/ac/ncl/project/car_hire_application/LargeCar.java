package uk.ac.ncl.project.car_hire_application;

public class LargeCar extends AbstractCar {
	
	private LargeCar(String carRegistration){
		super(65,carRegistration);
	}	
	
	public static AbstractCar createLargeCar(){
		String carRegistration = createCarRegistration();
		if(carRegistration != null){
			return new LargeCar(carRegistration);
		}
		return null;
	}	
	
	public int driveCar(int kilometres){
		int fuelUsed = 0;
		if(getRented()==false){
			System.out.println("Car "+getCAR_REGISTRATION()+" has not been rented, no journey is undertaken"+System.lineSeparator());
			return 0;
		}
		if(getCurrentFuel() <= 0){
			System.out.println("This car has no fuel, no journey is undertaken"+System.lineSeparator());
		}
		else{
		if(kilometres<=50){
			fuelUsed = ((int) Math.ceil((double)kilometres/15));
		}
		else{
			kilometres -= 50;
			fuelUsed = 4;
			fuelUsed += ((int) Math.ceil((double)kilometres/20));
		}
		setCurrentFuel(getCurrentFuel()-fuelUsed);
		System.out.println("The journey of "+kilometres+" kilometres has consumed "+fuelUsed+" litres"+System.lineSeparator());
		}
		return fuelUsed;
	}
}
