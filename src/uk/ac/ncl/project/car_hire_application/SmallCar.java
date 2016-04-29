package uk.ac.ncl.project.car_hire_application;

public class SmallCar extends AbstractCar{
	
	private SmallCar(String carRegistration){
		super(45,carRegistration);
	}	
	
	public static AbstractCar createSmallCar(){
		String carRegistration = createCarRegistration();
		if(carRegistration != null){
			return new SmallCar(carRegistration);
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
			System.out.println("Car "+getCAR_REGISTRATION()+" has no fuel, no journey is undertaken"+System.lineSeparator());
		}	
		else{
		fuelUsed = ((int) Math.ceil((double)kilometres/25.0));
		setCurrentFuel(getCurrentFuel()-fuelUsed);
		System.out.println("Car "+getCAR_REGISTRATION()+" has undertook a journey of "+kilometres+" kilometres has consumed "+fuelUsed+" litres"+System.lineSeparator());
		}
		return fuelUsed;
	}
}
