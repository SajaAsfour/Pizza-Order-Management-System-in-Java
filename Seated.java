package application;

//saja asfour
//1210737
//lab sec 7

public class Seated extends PizzaOrder{//Seated class is a subclass from PizzaOrder class
	private double serviceCharge  ;
	private int    numberOfPeople ;
	public Seated() {
		super();
	}
	
	public double getServiceCharge() {
		return serviceCharge;
	}
	public void setServiceCharge(double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	//non-default constructor
	public Seated(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice, double serviceCharge,
			int numberOfPeople) {
		super(customerName, pizzaSize, numberOfToppings, toppingPrice);
		this.serviceCharge = serviceCharge;
		this.numberOfPeople = numberOfPeople;
	}
	@Override
	public String toString() {
		return super.toString()
				+" serviceCharge=" + serviceCharge
				+ "\n numberOfPeople=" 
				+ numberOfPeople ;
	}
	@Override//method which overrides the method in PizzaOrder and  adds the ( serviceCharge * numberOfPeople ) to the price
	public double calculateOrderPrice() {
		return (super.calculateOrderPrice()+(serviceCharge*numberOfPeople));
	}
}

