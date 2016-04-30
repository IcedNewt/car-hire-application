package uk.ac.ncl.project.car_hire_application;

public abstract class AbstractCar implements Car{
	
	private final String CAR_REGISTRATION;
	private final int MAX_FUEL;
	private int currentFuel;
	private boolean rented;
	
	
	// Constructor, protected so that it can only be called via the subclass factory method, not globally.
	protected AbstractCar(int maxFuel, String carRegistration){
		this.CAR_REGISTRATION = carRegistration;
		this.MAX_FUEL = maxFuel;
		this.currentFuel = maxFuel;
		this.rented = false;
	}
	
	// A method to ensure that a NullPointerException does not cause the program to crash.
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
	
	public boolean getRented(){
		return rented;
	}
		
	public void setCurrentFuel(int currentFuel) {
		this.currentFuel = currentFuel;
	}
	
	public void setRented(boolean rented){
		this.rented = rented;
	}
	
	// Calculates the fuel that has been used after driving the car.
	public int calculateFuelUsed(){
		return (getMaxFuel() - getCurrentFuel());
	}
	
	// Method that adds a passed integer to the fuel tank, up to its maximum.
	public int addFuel(int fuelToAdd){
		if((getRented()==true)&&(getCurrentFuel()!=getMaxFuel())){ //If the car is NOT rented AND The tank is full, return 0.
			int fuelNeeded = (getMaxFuel() - calculateFuelUsed()); // Calculating the fuel needed to fill the tank. (Can be more that the max).
			
			if(fuelNeeded > getMaxFuel()){ // If the car has negative fuel, return the max fuel.
				setCurrentFuel(getMaxFuel());
				return getMaxFuel();
			}
			
			if(fuelToAdd >= fuelNeeded){ // If the added fuel is more than max fuel, return max fuel.
				setCurrentFuel(getMaxFuel());
				return fuelNeeded;
			}
			else{ // If the added fuel is valid, return the amount of fuel added.
				setCurrentFuel(getCurrentFuel()+fuelToAdd);
				return fuelToAdd;
			}
		}
		return 0; // If the car is full of fuel, return 0.
	}	
	
	// Indicates whether the car's fuel tank is full or not
	public void isTankFull() {
		if(calculateFuelUsed() == 0){
			output("The tank is currently full.");
		}
		else{
			output("The tank is currently NOT full.");
		}
	}	
	
	// Indicates whether the car is rented or not
	public void isCarRented() {
		if(getRented() == true ){
			output("The car is currently being rented.");
		}
		else{
			output("The car is NOT currently being rented.");
		}
	}
	
	// Removes duplication of System.out.println().
	public static void output(String string){
		System.out.println(string);
	}
	
	// Overrides the toString class for any Car objects.
	public String toString(){
		String typeOfCar;
		// Determines the type of car from the MAX_FUEL of the object.
		if(MAX_FUEL == 65){
			typeOfCar = "Large";
		}
		else{
			typeOfCar = "Small";
		}
		return "Registration: "+getCAR_REGISTRATION()+" - Car Type: "+typeOfCar+" - Current Fuel: "+getCurrentFuel()+" - Is Rented? "+getRented()+System.lineSeparator();
	}
}
