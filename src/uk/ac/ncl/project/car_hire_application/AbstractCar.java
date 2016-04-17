package uk.ac.ncl.project.car_hire_application;

public abstract class AbstractCar implements Car{
	
	private final String CAR_REGISTRATION;
	private final int MAX_FUEL;
	private int currentFuel;
	private boolean rented;
	
	
	AbstractCar(int maxFuel){
		this.CAR_REGISTRATION = createCarRegistration();
		this.MAX_FUEL = maxFuel;
		this.currentFuel = maxFuel;
		this.rented = false;
	}
	
	private String createCarRegistration(){
		String temp;
		try{
			temp = CarRegistration.getInstance().getREGISTRATION_NUMBER();
		}catch(NullPointerException n){
			temp = null;
		}
		return temp;
	}
	
	public String getCAR_REGISTRATION(){
		return CAR_REGISTRATION;
	}
	
	public int getMaxFuel(){
		return MAX_FUEL;
	}
	
	public int getCurrentFuel(){
		return currentFuel;
	}
	
	public void setCurrentFuel(int currentFuel) {
		this.currentFuel = currentFuel;
	}
	
	public boolean getRented(){
		return rented;
	}
	
	public int calculateFuelUsed(){
		return (getMaxFuel() - getCurrentFuel());
	}
	
	public void isTankFull() {
		if(calculateFuelUsed() == 0){
			System.out.println("The tank is full.");
		}
	}

	public void isCarRented() {
		if(getRented() == true ){
			System.out.println("The car is currently being rented.");
		}
	}

}
