

/*
Genting SkyWorlds Theme Park offers great discount for entrance ticket during the school holiday.
 They provide two types of tickets, namely normal and express tickets. The advantage of 
 purchasing an express ticket is that visitors will not have to wait in the same line as 
 normal queue but instead queueing in their exclusive lane to experience all the theme park's 
 attractions. However, the express ticket is somewhat more expensive than the regular one. 
 The following are the price and discount given for normal and express ticket.

Ticket Type	    Age	            Normal Price (RM)
Normal (N)	    Children(C)	    45
	            Adult(A)	    55
Express (E)	    Children(C)	    70
	            Adult(A)	    80

If the total fee exceeds RM200, a 17 % discount will be applied to the total fee. Otherwise, a 15% discount will be applied to the total fee.


The data from user will be read into a LinkedList to decide which discount will be given to the visitor. The software will 
process data in the Queue, where all visitors' information will be saved in different sequential lists. The following 
information will be displayed at the end of the programme:

a	The name of customers and their identity number
b	The quantity of ticket bought by customer, listed according to type of ticket
c	The date of the purchase and the date of the ticket purchased by customer
d	The total amount to be paid after discount

*/

import java.util.Scanner;

public class mainApp {
    public static void main(String[] args) {

        LinkedList userInfo = new LinkedList();
        Scanner input = new Scanner(System.in);

        while(true) {
            displayMenu(1);
            int choice = input.nextInt();
            int adib;
            if (choice == 1) 
            {
                // Add
                System.out.println("Input identification number (IC): ");
                int icNum = input.nextInt();

                System.out.println("Input the name: ");
                String name = input.next();

                System.out.println("Input the age: ");
                int age = input.nextInt();

                Customer cust = new Customer (icNum, name, age);
                userInfo.insertAtFront(cust);

                continue;
            }
            else if (choice == 2) {
                // Remove

            }
            else if (choice == 3) {
                // Display

            }
            else if (choice == 4) {
                // Exit
                System.out.println("Thank you!");
                break;
            }
            displayMenu(2);
            choice = input.nextInt();

        }
    }
    private static void displayMenu(int menu) {
        if (menu == 1) {
            System.out.println("Welcome to Genting SkyWorlds Theme Park!");
            System.out.println("Main Menu");
            System.out.println("1) Add");
            System.out.println("2) Remove");
            System.out.println("3) Display");
            System.out.println("4) Exit");
            System.out.println("Input either 1, 2, 3 or 4");
            System.out.println("------------------");
        }
        else if (menu == 2) {
            System.out.println("Do you want to do anything else?");
            System.out.println("Main Menu");
            System.out.println("1) Add");
            System.out.println("2) Remove");
            System.out.println("3) Display");
            System.out.println("4) Exit");
            System.out.println("Input either 1, 2, 3 or 4");
            System.out.println("------------------");
        }
    }
}