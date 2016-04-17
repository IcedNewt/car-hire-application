package uk.ac.ncl.project.car_hire_application;

public abstract class AbstractCar implements Car{
	
	private final String CAR_REGISTRATION;
	private final int maxFuel;
	private int currentFuel;
	private boolean rented;
	
	
	AbstractCar(String firstComponent, String secondComponent,int maxFuel){
		this.CAR_REGISTRATION = createCarRegistration(firstComponent,secondComponent);
		this.maxFuel = maxFuel;
		this.currentFuel = maxFuel;
		this.rented = false;
	}
	
	private String createCarRegistration(String firstComponent, String secondComponent){
		String temp;
		try{
			temp = CarRegistration.getInstance(firstComponent,secondComponent).getREGISTRATION_NUMBER();
		}catch(NullPointerException e){
			temp = null;
		}
		return temp;
	}
	
	public String getCAR_REGISTRATION(){
		return CAR_REGISTRATION;
	}
	
	public int getMaxFuel(){
		return maxFuel;
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
