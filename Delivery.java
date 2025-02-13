package application;
//saja asfour
//1210737
//lab sec 7
public class Delivery extends PizzaOrder{//Delivery is a subclass from PizzaOrder class
	//the data which it is private because we have setter and getter
	private double tripRate ;
	private int zone;
	//method to get the tripRate
	public double getTripRate() {
		return tripRate;
	}
	//method use to set any tripRate from user 
	public void setTripRate(double tripRate) {
		this.tripRate = tripRate;
	}
	//method to get the Zone
	public int getZone() {
		return zone;
	}
	//in this method user can set any zone that from 1 to 4 just
	public void setZone(int zone) {
		this.zone = zone;
	}
	//non-default constructor
	public Delivery(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice, double tripRate,
			int zone) {
		super(customerName, pizzaSize, numberOfToppings, toppingPrice);
		this.tripRate = tripRate;
		this.zone = zone;
	}
	//default constructor
	public Delivery() {
		super();
	}
	@Override
	public String toString() {
		return super.toString()+
				"\n tripRate=" + tripRate 
				+ "\n zone=" + zone +"\n";
	}
	@Override//method which overrides the method in PizzaOrder and  adds the ( tripRate/100 * totalprice * zone ) to the price
	public double calculateOrderPrice() {
		return (super.calculateOrderPrice() +((tripRate/100)* super.calculateOrderPrice()*zone));
	}
	
}
