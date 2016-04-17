package carDetails;

public abstract class AbstractCar implements Car{
	
	private final String regNumber;
	private final int maxFuel;
	private int currentFuel;
	private boolean rented;
	
	AbstractCar(String regNumber,int maxFuel){
		this.regNumber = regNumber;
		this.maxFuel = maxFuel;
		this.currentFuel = maxFuel;
		this.rented = false;
	}

	public String getRegNumber(){
		return regNumber;
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
