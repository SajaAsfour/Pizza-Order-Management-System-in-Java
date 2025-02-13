package application;
//saja asfour
//1210737
//lab sec 7
import java.util.Date;
public class PizzaOrder implements Comparable <PizzaOrder>{
	//the attributes ,i put it private because we have setter and getter to access the attribute
	private String customerName ;
	private Date dateOrdered ;
	private int pizzaSize ;
	private int numberOfToppings ;
	private double toppingPrice ;
	//the final keyword used to keep the value constant
	final static int MEDIUM=2;
	final static int LARGE=3;
	final static int SMALL=1;
	//arg constructor 
	public PizzaOrder(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice) {
		dateOrdered=new Date();//to set the todays state 
		this.customerName = customerName;
		this.pizzaSize = pizzaSize;
		this.numberOfToppings = numberOfToppings;
		this.toppingPrice = toppingPrice;
	}
	//no-arg constructor
	public PizzaOrder() {
		dateOrdered=new Date();
	}
	//method to get customerName
	public String getCustomerName() {
		return customerName;
	}
	//from this method we can set any name for customer
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	//getter for toppingPrice
	public double getToppingPrice() {
		return toppingPrice;
	}
	//setter for toppingPrice
	public void setToppingPrice(double toppingPrice) {
		this.toppingPrice = toppingPrice;
	}
	//getter for number of topping
	public int getNumberOfToppings() {
		return numberOfToppings;
	}
	//setter for number of topping
	public void setNumberOfToppings(int numberOfToppings) {
		this.numberOfToppings = numberOfToppings;
	}
	//method to get the size of pizza
	public int getPizzaSize() {
		return pizzaSize;
	}
	//method to set any size of pizza
	public void setPizzaSize(int pizzaSize) {
		this.pizzaSize = pizzaSize;
	}

	public static int getMedium() {
		return MEDIUM;
	}

	public static int getLarge() {
		return LARGE;
	}

	public static int getSmall() {
		return SMALL;
	}
	//this method  calculates the price of the pizza order as follows:
	public double calculateOrderPrice() {
		return ( numberOfToppings * toppingPrice  * pizzaSize);
	}
	//method to print only the customer’s name and the calculated order price on one line to the screen
	public void printOrderInfo () {
		System.out.println(customerName+"    "+calculateOrderPrice());
	}
	@Override//use if we have override method in super and sub class
	public String toString() {
		String sizeToPrint="";//use it to convert the pizza size from integer to string
		if(pizzaSize==1)
			sizeToPrint="small";
		else if(pizzaSize==2)
			sizeToPrint="medium";
		if(pizzaSize==3)
			sizeToPrint="large";
		return " customerName=" + customerName 
			    + "\n dateOrdered=" + dateOrdered 
				+ "\n pizzaSize=" + sizeToPrint//the variable which i put it above
				+ "\n numberOfToppings=" + numberOfToppings 
				+ "\n toppingPrice=" + toppingPrice ;
	}

	@Override//this method use to compare the original order price with the order price to any object in main class(Driver)
	public int compareTo(PizzaOrder op) {
		if(calculateOrderPrice() > op.calculateOrderPrice())
		return 1;
		else if(calculateOrderPrice()< op.calculateOrderPrice())
			return -1;
		else
			return 0;
	}
	
}

