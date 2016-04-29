package uk.ac.ncl.project.car_hire_application;

public abstract class AbstractCar implements Car{
	
	private final String CAR_REGISTRATION;
	private final int MAX_FUEL;
	private int currentFuel;
	private boolean rented;
	
	
	protected AbstractCar(int maxFuel, String carRegistration){
		this.CAR_REGISTRATION = carRegistration;
		this.MAX_FUEL = maxFuel;
		this.currentFuel = maxFuel;
		this.rented = false;
	}
	
	protected static String createCarRegistration(){
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
	
	public void setRented(boolean rented){
		this.rented = rented;
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

	public String toString(){
		String typeOfCar;
		if(MAX_FUEL == 65){
			typeOfCar = "Large";
		}
		else{
			typeOfCar = "Small";
		}
		return "Registration: "+getCAR_REGISTRATION()+" - Car Type: "+typeOfCar+" - Current Fuel: "+getCurrentFuel()+" - Is Rented? "+getRented()+System.lineSeparator();
	}
	
	public void isCarRented() {
		if(getRented() == true ){
			System.out.println("The car is currently being rented.");
		}
	}

}
