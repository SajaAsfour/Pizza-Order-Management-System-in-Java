package application;
//saja asfour
//1210737
//lab sec 7
import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
public class Driver extends Application{
	public static void main(String[] args) {
		//this method launches the JavaFX runtime and my JavaFX application.
		
		launch(args);
	}
	@Override
	public void start(Stage arg) {
		//here i make a welcome stage 
		Stage welcome=new Stage();
		GridPane g=new GridPane();//The GridPane Divides the screen into grid 
		Label wel=new Label("Welcome\n\nTo the order system\n\nplease press OK \n\nto fill out the order");
		wel.setFont(Font.font("Times New Roman", FontWeight.LIGHT, 30));//this to manage the text inside the label
		g.add(wel,0,0);//add the label to the GridPane and set his position 
		Button button=new Button("OK");
		g.add(button,5,4);//add the button to the GridPane and set Her position
		Scene welc=new Scene(g,300,300);//create Scene include the GridPane g with width=300 and length =300
		welcome.setScene(welc);//set the scene in the stage
		welcome.setTitle("Welcome Message");//set title for the stage
		welcome.show();//this to make stage appear when run the program
	    Stage separate =new Stage();//this stage to print the Orders information
	    //when we click the button make this:
	    button.setOnAction(e->{/*This is Lambda Expressions
	    it is a block of code which takes parameter(e) and returns this value:
	    */
	    welcome.close();//This to close the welcome stage (to open the order stage)
		GridPane p=new GridPane();
		p.setHgap(15);//The horizontal spacing between the components in the GridPane because it is 0 by default 
		p.setVgap(15);//The vertical spacing between the components in the GridPane because it is 0 by default 

		Label customerNameLabel=new Label("  Customer Name:");
		customerNameLabel.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
		p.add(customerNameLabel, 0, 0);
		TextField customerNameText=new TextField();
		p.add(customerNameText, 1, 0);
		Label orderTypeLabel=new Label("  Order Type:");
		orderTypeLabel.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
		p.add(orderTypeLabel, 0, 1);
		ComboBox<String> orderType =new ComboBox<String>();/*ComboBox which shows a list of items
		                                                     out of which user can select at most one item
		                                                     it inherits the class ComboBoxBase
		                                                     here i create default empty comboBox
		                                                     */
		orderType.getItems().addAll("ToGo","Delivery","Seated");/*getItem() method returns the items of ComboBox
																 then add the item
		                                                        */
		orderType.setValue("ToGo");//the default value of the comboBox
		p.add(orderType, 1, 1);//add the comboBox in the position(1,1)
		Label orderSizeLabel=new Label("  Oreder Size: ");
		orderSizeLabel.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
		p.add(orderSizeLabel, 0, 2);
		ToggleGroup tg=new ToggleGroup();/*create a Toggle Button which is a 
										  control having the ability to be selected
										  only one ToggleButton at a time within that group can be selected
		 								 */
		//RadioButtons are mainly used to create a series of items where only one can be selected:
		RadioButton bt1=new RadioButton("SMALL");
		RadioButton bt2=new RadioButton("MEDIUM");
		RadioButton bt3=new RadioButton("LARGE");
		bt1.setSelected(true);//set the default value true in bt1 so it is false in other
		//add  RadioButtons to Toggle Group so that the user cannot select more than one item:
		bt1.setToggleGroup(tg);
		bt2.setToggleGroup(tg);
		bt3.setToggleGroup(tg);
		//add the RadioButtons to the GridPane
		p.getChildren().add(bt1);
		p.getChildren().add(bt2);
		p.getChildren().add(bt3);
        //make HBox which is a component positions all its child nodes(components)in a horizontal row
		HBox h=new HBox(5);//set the spacing between the controls in the HBox layout component to 5
		h.getChildren().addAll(bt1,bt2,bt3);//add the three radioButton to the HBox
		p.add(h, 1, 2);//add HBox to the GridPane
		Label chooseToppingsLabel=new Label("  Choose Toppings: ");
		chooseToppingsLabel.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
		p.add(chooseToppingsLabel, 0, 3);
		//here i create a 4 check box which is a box with a tick on it when selected and empty when not selected
		//we can select multiple options at the same time
		CheckBox cb1=new CheckBox("Onions");
		CheckBox cb2=new CheckBox("Olives");
		CheckBox cb3=new CheckBox("Green Peppers");
		CheckBox cb4=new CheckBox("Hot sauce");
		//create HBox with default spacing (0) between the controls
		HBox hb=new HBox();
		hb.getChildren().addAll(cb1,cb2,cb3,cb4);//Add the CheckBoxs to the HBox
		hb.setSpacing(10);//set the space between the CheckBoxs to 10
		p.add(hb, 1, 3);//add the HBox to the GridPane
		Label toppingPriceLabel=new Label("  Topping Price: ");
		toppingPriceLabel.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
		p.add(toppingPriceLabel, 0, 4);
		TextField toppingPriceText=new TextField("10");//set the default value of the textFeild to 10
		p.add(toppingPriceText, 1, 4);
		Label tripRateLabel=new Label("  Trip Rate: ");
		tripRateLabel.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
		p.add(tripRateLabel, 0, 5);
		TextField tripRateText=new TextField();
		p.add(tripRateText, 1, 5);
		Label zoneLabel=new Label("  Zone: ");
		zoneLabel.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
		p.add(zoneLabel, 0, 6);
		TextField zoneText=new TextField();
		p.add(zoneText, 1, 6);
		/*I hide this label and textField because the default value for the comboBox is ToGo
		 *  so we does not need them in this Step:
		 */
		tripRateLabel.setVisible(false);
		tripRateText.setVisible(false);
		zoneLabel.setVisible(false);
		zoneText.setVisible(false);
		Label serviceChargeLabel =new Label("  Service Charge: ");
		serviceChargeLabel.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
		p.add(serviceChargeLabel, 0, 5);
		TextField serviceChargeText =new TextField();	
		p.add(serviceChargeText, 1, 5);
		Label numberOfPeopleLabel=new Label ("  Number Of People: ");
		numberOfPeopleLabel.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
		TextField numberOfPeopleText=new TextField();
		p.add(numberOfPeopleLabel, 0, 6);
		p.add(numberOfPeopleText, 1, 6);
		/*I hide this label and textField because the default value for the comboBox is ToGo
		 *  so we does not need them in this Step:
		 */
		serviceChargeLabel.setVisible(false);
		serviceChargeText.setVisible(false);
		numberOfPeopleLabel.setVisible(false);
		numberOfPeopleText.setVisible(false);
		Label orderPriceLabel=new Label("  Order Price: ");
		orderPriceLabel.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
		Label orderPrice=new Label("0.0");//set the default value for orderPrice to 0.0
		Button processOrder =new Button("Process Order");//creates a button with the specified text as its label
		Button printOrders=new Button ("Print Orders");//creates a button with the specified text as its label
		Button reset =new Button("Reset");//creates a button with the specified text as its label
		p.add(orderPriceLabel, 0, 7);
		p.add(orderPrice, 1, 7);
	    HBox buttonBox=new HBox();
	    buttonBox.getChildren().addAll(processOrder,printOrders,reset);
	    buttonBox.setSpacing(10);
	    p.add(buttonBox, 0, 8);
	    ArrayList<PizzaOrder>orders =new ArrayList<>();//create ArrayList from type PizzaOrder
	    //Here the Action of the ComboBox,i use Lambda Expressions with parameter called event
	    //When we selected any of ComboBox item this will happen:
		orderType.setOnAction(event->{
			if(orderType.getValue()=="ToGo") {//This is the default case
			serviceChargeLabel.setVisible(false);
			serviceChargeText.setVisible(false);
			numberOfPeopleLabel.setVisible(false);
			numberOfPeopleText.setVisible(false);
			tripRateLabel.setVisible(false);
			tripRateText.setVisible(false);
			zoneLabel.setVisible(false);
			zoneText.setVisible(false);	
			}
			else if(orderType.getValue()=="Delivery") {//This case happen when user selected Delivery
				serviceChargeLabel.setVisible(false);
				serviceChargeText.setVisible(false);
				numberOfPeopleLabel.setVisible(false);
				numberOfPeopleText.setVisible(false);
				//The below Labels and TextFeild True because we need it to calculate the order price
				tripRateLabel.setVisible(true);
				tripRateText.setVisible(true);
				zoneLabel.setVisible(true);
				zoneText.setVisible(true);
			}
		  else if(orderType.getValue()=="Seated") {//This case happen when user selected Seated
			  //The below Labels and TextFeild True because we need it to calculate the order price
			    serviceChargeLabel.setVisible(true);
			    serviceChargeText.setVisible(true);
				numberOfPeopleLabel.setVisible(true);
				numberOfPeopleText.setVisible(true);
				//The below Labels and TextFeild false because we don't need it to calculate the order price
				tripRateLabel.setVisible(false);
				tripRateText.setVisible(false);
				zoneLabel.setVisible(false);
				zoneText.setVisible(false);
		  }
		});
		//when  user click the button processOrder :
		/*
		 * create an appropriate object based on the pizza order type selected ( ToGo, Delivery, or Seated)
		 *  using the data provided by the user in the arg stage
		 *  Add the created pizza order object to an ArrayList of type PizzaOrder called orders
		 *  and then use the created object to calculate the orderPrice and display it 
		 */
		processOrder.setOnAction(event->{ 
			//get the value of customer name that enter by a user:
			String customerName =customerNameText.getText();
			int size=0;//this variable use to change the string name in check box to int to use in calculation
			if (bt1.isSelected())
				size=1;//This mean SMALL
			else if (bt2.isSelected())
				size=2;//This mean MEDUIM
			else if (bt3.isSelected())
				size=3;//This mean Large
		    int numberOfCheckBox=0;//this variable to calculate the number of Toppings to use in calculate the Toppingprice
			//when we press any check box the number of topping increment by 1
		    if(cb1.isSelected())
				numberOfCheckBox++;
			if(cb2.isSelected())
				numberOfCheckBox++;
			if(cb3.isSelected())
				numberOfCheckBox++;
			if(cb4.isSelected())
				numberOfCheckBox++;
			double topPriceTextField=0;
			if(toppingPriceText.getText()==null)
				topPriceTextField=10;
			else
				//convert the String in the TextField to Double to use it for calculate the orderprice
				topPriceTextField=Double.parseDouble(toppingPriceText.getText());
			double triprate=0,service=0;
			int zone=0,num=0;
			if(orderType.getValue()=="ToGo") {
				//add to ArrayList instance from ToGo class
				orders.add(new ToGo(customerName,size,numberOfCheckBox,topPriceTextField));
				
			}
			else if(orderType.getValue()=="Delivery") {//if the user select Delivery in the ComboBox
				//below i checked if the two TextField that content the zone and trip rate is empty or not
				if(tripRateText.getText()!=null && zoneText.getText()!=null) {
					//if it is not empty:
					//convert the Sting into the trip rate  TextField to double
					triprate=Double.parseDouble(tripRateText.getText());
					//convert the String into the zone TextField to integer
					zone=Integer.parseInt(zoneText.getText());
					//add to ArrayList instance from Delivery class
					 orders.add(new Delivery(customerName,size,numberOfCheckBox,topPriceTextField,triprate,zone)) ;
				}
				}
			else if(orderType.getValue()=="Seated") {//if the user select Seated in the ComboBox
				//below i checked if the two TextField that content the serviceCharge and numberOfPeople is empty or not
				if(serviceChargeText.getText()!=null && numberOfPeopleText.getText()!=null) {
					//if it is not empty:
					//convert the Sting into the serviceCharge TextField to Double
					service=Double.parseDouble(serviceChargeText.getText());
					//convert the String into the numberOfPeople TextField to integer
					num=Integer.parseInt(numberOfPeopleText.getText());
					//add to ArrayList instance from Seated class
					 orders.add(new Seated(customerName,size,numberOfCheckBox,topPriceTextField,service,num)) ;
				}	
			}
			 for(PizzaOrder x: orders) {
				 /*loop to set the text in order price label to the order price
				  that calculate from the method in the subclasses
				  */
				 orderPrice.setText(String.valueOf(x.calculateOrderPrice()));
				// System.out.println(x.toString());
				 
			 }
		});
		//when the user click the button printOrders :
		/*
		 a new stage will open to print a list of customer names and order prices for orders saved in ArrayList orders to a separate stage 
		 */
		printOrders.setOnAction(event->{
			//sort the ArrayList(orders)ascending  by the order price 
			 Collections.sort(orders);
			 //create a new GridPane
			 GridPane pane=new GridPane();
			 //for loop to fill the label to print 
			 for(int x=0;x<orders.size();x++) {
				 Label name=new Label();
				 name.setText(orders.get(x).getCustomerName()+" " + orders.get(x).calculateOrderPrice());
				 pane.add(name, 0, x);
			 }
			 //create scene to put the pane in it
			 Scene s2=new Scene(pane,250,200);
			 separate.setScene(s2);
			 separate.setTitle("Restaurant bill");
			 separate.show();
		});
		//when user click the reset button:
		/*
		 * should reset ALL items and fields to their default values 
		 * as well as remove all the orders from the ArrayList orders
		 * */
		reset.setOnAction(event->{
			customerNameText.clear();//clear the text in the customer Name TextField
			orderType.setValue("ToGo");//set the combo box to it's default value
			bt1.setSelected(true);//set the RadioButtons to it's default value
			//set the check boxes to the default value
			cb1.setSelected(false);
			cb2.setSelected(false);
			cb3.setSelected(false);
			cb4.setSelected(false);
			//set the value in the toppingprice TextField to it's default value
			toppingPriceText.setText("10");
			//set the value in the orderPrice to 0.0(it's default value)
			orderPrice.setText("0.0");
			//clear the text in the TextField of triprate,zone,servixeCharge,numberOfPeople
			tripRateText.clear();
			zoneText.clear();
			serviceChargeText.clear();
			numberOfPeopleText.clear();
			//clear the orders from the ArrayList orders
			orders.clear();
			//close the separate that use to print the information on it
			separate.close();
		});
		Scene s=new Scene(p,700,400);
		arg.setTitle("Order list");
		arg.setScene(s);
		arg.show();
	}
	    		);}
}