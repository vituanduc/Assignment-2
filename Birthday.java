
import java.util.Random;
import _solution.Toy;
import javax.swing.JOptionPane;

public class Birthday {
	public static void main(String[] args) {
		
		/**Declaration of variable*/
		String name; //child name
		String sAge; //child string age
		String toy;  // toy's type
		String ans;  // variable to hold the answer
		double cost = 0;      //cost of 1 order
		double totalCost = 0; //total cost
		int age;  // child's age in interger
		boolean check = true;  //check if user want to order another time 
		
		/**create the object to Toy class*/
		Toy toyObject = new Toy();
		
		/**Welcome title of program*/
		JOptionPane.showMessageDialog(null, "Welcome to the Toy Company to choose gifts for young children ");

		/**Loop to  ask user if they want to enter another order*/
		while (check)
		{
			/** 	Ask for the name of the child. */
			name = JOptionPane.showInputDialog("Enter the name of the child");
			
			/** Ask for the child's age*/
			sAge = JOptionPane.showInputDialog("How old is the child"); 
			age = Integer.parseInt(sAge);
			toyObject.setAge(age);
			
			/**ask for the toy's type*/
			toy = JOptionPane.showInputDialog("Choose a toy: a plushie, blocks, or a book");
			toyObject.setToy(toy);
			
			/**call the setCost function to set the cost in Toy class*/
			toyObject.setCost(toyObject.getToy());
			
			/**check age appropriation*/
			if (toyObject.ageOK())  //if the age is appropriate
				JOptionPane.showMessageDialog(null, "Good choice");
			else {                  //if the age is inappropriate
				JOptionPane.showMessageDialog(null, "The toy is not age appropriate.");
				ans= JOptionPane.showInputDialog("Do you want to continue?");
				if (ans.equalsIgnoreCase("no")) //if user do not want to continue
				{
					ans = JOptionPane.showInputDialog("Do you want to try another toy? (Yes or No)");
					if (ans.equalsIgnoreCase("yes")) //if user wants to try again
						check = true;  //check that user wants to try again
					else {  //if user wants to stop
						check = false; //check that user wants to stop
						continue; //go back to the beginning of the loop
					}
				}
			}
			
			/** ask if user wants to add a card*/
			ans = JOptionPane.showInputDialog("Do you want a card with the gift? Yes or No");
			/**add the card cost*/
			toyObject.addCard(ans);
			
			/**ask if user wants to add balloon*/
			ans = JOptionPane.showInputDialog("Do you want a balloon with the gift? Yes or No");
			/**add the baloon cost*/
			toyObject.addBalloon(ans);
			
			/**get the total cost for 1 order*/
			cost = toyObject.getCost();
			
			/**update total cost*/
			totalCost+=cost;
			
			/**show information of 1 order*/
			System.out.println( "The gift for " + name + toyObject.toString()); 
			
			/**ask if user wants to place another order*/
			ans = JOptionPane.showInputDialog("Do you want to try another toy? (Yes or No)");
			if (ans.equalsIgnoreCase("yes"))
				check = true;
			else
				check = false;
		}
		System.out.printf("The total cost of your order is %.2f ", totalCost );
		Random ranNum = new Random();
		int orNum = ranNum.nextInt(99999);
		System.out.println("Order number is " + orNum);
		System.out.println("Programmer: Vi Tuan Duc Nguyen");
		System.exit(0);
			 }
		
	}
