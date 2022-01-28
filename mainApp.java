

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

If the total fee exceeds RM200, a 17% discount will be applied to the total fee. Otherwise, a 10% discount will be applied to the total fee
because of school holiday.

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
    public static void main(String[] args) 
    {
        // Variable
        String ticketType=""; 
        String dateTicket="";
        String datePurchased="";
        double totalPayment=0.00;
        
        // Count age list
        int countChildren=0, countAdult=0;

        // Price Tickets
        final int childrenPriceNormal = 45;
        final int adultPriceNormal = 55;
        final int childrenPriceExpress = 70;
        final int adultPriceExpress = 80;

        // Linked Lists
        LinkedList normalTicketInfo = new LinkedList();
        LinkedList expressTicketInfo = new LinkedList();
        LinkedList paymentInfo = new LinkedList();

        Scanner input = new Scanner(System.in);
        
        while(true) {
            displayMenu(1); // Intro display

            int choice = input.nextInt();

            if (choice == 1) // Add ticket
            {
                if (ticketType.isEmpty()) {
                    System.out.println("Do you prefer to buy (normal) ticket or (express) ticket");
                    ticketType = input.next();
                }
                if (dateTicket.isEmpty()) {
                    System.out.println("Input date of ticket (YYYY-MM-DD): ");
                    dateTicket = input.next();
                }
                if (datePurchased.isEmpty()) {
                    System.out.println("Input date of ticket purchased (YYYY-MM-DD): ");
                    datePurchased = input.next();
                }
 
                System.out.println("Input identification number (XXXXXX-XX-XXXX): ");
                String icNum = input.next();

                System.out.println("Input the name: ");
                String name = input.next();

                System.out.println("Input the age: ");
                int age = input.nextInt();

                if (age >= 2 && age < 18) {
                    countChildren++;
                }
                else if(age >= 18 && age < 60) {
                    countAdult++;
                }

                Customer cust = new Customer (icNum, name, age);
                if(ticketType.equalsIgnoreCase("Normal"))
                {
                    normalTicketInfo.insertAtFront(cust);
                }
                else if(ticketType.equalsIgnoreCase("Express"))
                {
                    expressTicketInfo.insertAtFront(cust);
                }
                Payment pay = new Payment (totalPayment, ticketType, dateTicket, datePurchased);
                paymentInfo.insertAtFront(pay);
                
                continue;
            }
            else if (choice == 2) // Remove
            {
                continue;
            }
            else if (choice == 3) // Display
            {
                /* Calculate Payment....

                if(ticketType.equalsIgnoreCase("Normal"))
                {
                    totalPayment = (countChildren * childrenPriceNormal ) + ( countAdult * adultPriceNormal );

                    if (totalPayment >= 2)
                }
                else if(ticketType.equalsIgnoreCase("Express"))
                {
                    totalPayment = (countChildren * childrenPriceExpress ) + ( countAdult * adultPriceExpress );
                }
                

                */


                System.out.println("Display");
                Customer Cus = null;
                Payment Pay = null;

                System.out.println("List tickets");
                Object dataNormal  = normalTicketInfo.getFirst();
                Object dataExpress = expressTicketInfo.getFirst();
                Object dataPayment = paymentInfo.getFirst();
                
                //
                if (!normalTicketInfo.isEmpty()) // For normal tickets
                {
                    while (dataNormal != null)
                    {
                        Cus = (Customer) dataNormal;
                        System.out.println("Ticket ID: "+GenerateRandom()+" | "+Cus.toStringCust());
                        dataNormal= normalTicketInfo.getNext();
                    }
                }
                else if (!expressTicketInfo.isEmpty()) // For express tickets
                {
                    while (dataExpress != null)
                    {
                        Cus = (Customer) dataExpress;
                        System.out.println("Ticket ID: "+GenerateRandom()+" | "+Cus.toStringCust());
                        dataExpress= expressTicketInfo.getNext();
                    }
                }

                //
                System.out.println("Payment Info ");
                while (dataPayment != null) // For payment informations
                {
                    Pay = (Payment) dataPayment;
                    System.out.println(Pay.toStringPayment());
                    dataPayment = paymentInfo.getNext();
                }

                break; // Out from loop
            }
            else if (choice == 4) {
                // Exit
                System.out.println("Thank you!");

                break; // Out from loop
            }
            displayMenu(2); // Continue display

            choice = input.nextInt();
        }
        input.close();
        
    }
    private static void displayMenu(int menu) {
        if (menu == 1) {
            System.out.println("Welcome to Genting SkyWorlds Theme Park!");
            System.out.println("Main Menu");
            System.out.println("1- Add ticket");
            System.out.println("2- Remove ticket");
            System.out.println("3- Display data");
            System.out.println("4- Exit program");
            System.out.println("Input either 1, 2, 3 or 4");
            System.out.println("------------------");
        }
        else if (menu == 2) {
            System.out.println("Do you want to do anything else?");
            System.out.println("Main Menu");
            System.out.println("1- Add ticket");
            System.out.println("2- Remove ticket");
            System.out.println("3- Display data");
            System.out.println("4- Exit program");
            System.out.println("Input either 1, 2, 3 or 4");
            System.out.println("------------------");
        }
    }

    // Random number for ticket ids.
    private static int GenerateRandom () {
        int min = 1;
        int max = 1000;

        //Generate random int value from 1 to 100 0
        int random = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random;
    }
}