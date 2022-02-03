
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

Show insert, modify, delete, and display data.

*/

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class mainApp {
    // Global Variable
    static int menuListCount=1;
    static String menuChoice2; static int menuChoice;
    // Input
    static JFrame f = new JFrame();   
    static Scanner input = new Scanner(System.in);

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

        // Discount
        double discount;

        // Linked Lists
        LinkedList normalTicketInfo = new LinkedList();
        LinkedList expressTicketInfo = new LinkedList();
        LinkedList tempList = new LinkedList();

        // Queue 
        Queue paymentNormalQueue = new Queue();
        Queue paymentExpressQueue = new Queue();

        while(true) {
            displayMenu(); // Intro display, menu 1

            if (menuChoice == 1) // Add ticket
            {
                if (ticketType.isEmpty()) {
                    do {
                        ticketType = JOptionPane.showInputDialog(f,"Do you prefer to buy (Normal) ticket or (Express) ticket?");     
        
                        if (!ticketType.equalsIgnoreCase("Normal") && !ticketType.equalsIgnoreCase("Express")) {
                            System.out.println("Invalid!");
                        }
                    }
                    while (!ticketType.equalsIgnoreCase("Normal") && !ticketType.equalsIgnoreCase("Express"));
                }

                if (dateTicket.isEmpty()) {
                    dateTicket = JOptionPane.showInputDialog(f,"Input date of ticket (YYYY-MM-DD): ");      
                }

                if (datePurchased.isEmpty()) {
                    datePurchased = JOptionPane.showInputDialog(f,"Input date of ticket purchased (YYYY-MM-DD): ");      
                }

                String icNum = JOptionPane.showInputDialog(f,"Input identification number (XXXXXX-XX-XXXX): ");   

                String name = JOptionPane.showInputDialog(f,"Input the name: ");   

                String age2 = JOptionPane.showInputDialog(f,"Input the age: ");   
                int age = Integer.parseInt(age2);

                int ticketID = GenerateRandom();

                // Add headcount for easier calculation
                if (age >= 2 && age < 18) {
                    countChildren++;
                }
                else if(age >= 18 && age < 60) {
                    countAdult++;
                }

                // LinkedList data structure
                Customer cust = new Customer (icNum, name, age, ticketID);
                if(ticketType.equalsIgnoreCase("Normal")) {
                    normalTicketInfo.insertAtBack(cust);
                }
                else if(ticketType.equalsIgnoreCase("Express")) {
                    expressTicketInfo.insertAtBack(cust);
                }

                // Queue data structure
                Payment pay = new Payment (totalPayment, ticketType, dateTicket, datePurchased);
                if(ticketType.equalsIgnoreCase("Normal")) {
                    paymentNormalQueue.enqueue(pay);
                }
                else if(ticketType.equalsIgnoreCase("Express")) {
                    paymentExpressQueue.enqueue(pay);
                }
                menuListCount++;
                continue; // Continue loop
            }
            else if (menuChoice == 2) // Remove
            {
                Customer Cus = null;
                Object dataNormal  = normalTicketInfo.getFirst();
                Object dataExpress = expressTicketInfo.getFirst();

                // Show the ticket data to remove which ticketID
                if (!normalTicketInfo.isEmpty()) // For normal tickets
                {
                    while (dataNormal != null)
                    {
                        Cus = (Customer) dataNormal;
                        Cus.CustomerPrint();
                        dataNormal= normalTicketInfo.getNext();
                    }
                }
                else if (!expressTicketInfo.isEmpty()) // For express tickets
                {
                    while (dataExpress != null)
                    {
                        Cus = (Customer) dataExpress;
                        Cus.CustomerPrint();
                        dataExpress= expressTicketInfo.getNext();
                    }
                }
                String del2 = JOptionPane.showInputDialog(f,"Which data you want to delete? Insert the ticket ID (????): ");   
                int del = Integer.parseInt(del2);

                // Delete stuff (linked list)
                if (ticketType.equalsIgnoreCase("Normal")) // For normal tickets
                {
                    Customer custdelete = (Customer) normalTicketInfo.getFirst();

                    // USER WANT (Insert linked list front)
                    while(custdelete.getTicketID() != del)
                        custdelete = (Customer) normalTicketInfo.getNext();
                    tempList.insertAtFront(custdelete);

                    // Delete the count head (calculation) for USER WANT delete
                    if (custdelete.getAge() >= 2 && custdelete.getAge() < 18) 
                        countChildren--;
                    else if(custdelete.getAge() >= 18 && custdelete.getAge() < 60) 
                        countAdult--;
                    
                    // Other than USER WANT (After front, 2nd, 3rd, ...)
                    Customer tempTransfer = (Customer) normalTicketInfo.getFirst();
                    while (tempTransfer != null)  // To transfer elements from original linkedList to temporary linkedList
                    {
                        if (tempTransfer.getTicketID() == del) // Except USER WANT
                            tempTransfer = (Customer) normalTicketInfo.getNext();
                        else
                        {
                            tempList.insertAtBack(tempTransfer);
                            tempTransfer = (Customer) normalTicketInfo.getNext();
                        }
                    }
                    tempList.removeFromFront(); // Remove USER WANT

                    // To clear original linked list
                    normalTicketInfo.getFirst();
                    while(!normalTicketInfo.isEmpty())
                        normalTicketInfo.removeFromFront();

                    // To transfer from temporary to original
                    Customer custprint = (Customer) tempList.getFirst();
                    while(custprint != null)
                    {
                        normalTicketInfo.insertAtBack(custprint);
                        custprint = (Customer) tempList.getNext();
                    }

                    // Clear temporary linked list
                    while(!tempList.isEmpty())
                        tempList.removeFromFront();
                }
                else if (ticketType.equalsIgnoreCase("Express")) // For express tickets
                {
                    Customer custdelete = (Customer) expressTicketInfo.getFirst();

                    // USER WANT (Insert linked list front)
                    while(custdelete.getTicketID() != del)
                        custdelete = (Customer) expressTicketInfo.getNext();
                    tempList.insertAtFront(custdelete);
                    
                    // Delete the count head (calculation) for USER WANT delete
                    if (custdelete.getAge() >= 2 && custdelete.getAge() < 18) 
                        countChildren--;
                    else if(custdelete.getAge() >= 18 && custdelete.getAge() < 60) 
                        countAdult--;

                    // Other than USER WANT (After front, 2nd, 3rd, ...)
                    Customer tempTransfer = (Customer) expressTicketInfo.getFirst();
                    while (tempTransfer != null)  // To transfer elements from original linkedList to temporary linkedList
                    {
                        if (tempTransfer.getTicketID() == del) // Except USER WANT
                            tempTransfer = (Customer) expressTicketInfo.getNext();
                        else
                        {
                            tempList.insertAtBack(tempTransfer);
                            tempTransfer = (Customer) expressTicketInfo.getNext();
                        }
                    }
                    tempList.removeFromFront(); // Remove USER WANT

                    // To clear original linked list
                    expressTicketInfo.getFirst();
                    while(!expressTicketInfo.isEmpty())
                    expressTicketInfo.removeFromFront();

                    // To transfer from temporary to original
                    Customer custprint = (Customer) tempList.getFirst();
                    while(custprint != null)
                    {
                        expressTicketInfo.insertAtBack(custprint);
                        custprint = (Customer) tempList.getNext();
                    }

                    // Clear temporary linked list
                    while(!tempList.isEmpty())
                        tempList.removeFromFront();
                }
                continue;
            }
            else if (menuChoice == 3) // Modify datas
            { 
                // Modify data
                Customer Cus = null;
                Object dataNormal  = normalTicketInfo.getFirst();
                Object dataExpress = expressTicketInfo.getFirst();
        
                // Show the datas
                if (!normalTicketInfo.isEmpty()) // For normal tickets
                {
                    while (dataNormal != null)
                    {
                        Cus = (Customer) dataNormal;
                        Cus.CustomerPrint();
                        dataNormal= normalTicketInfo.getNext();
                    }
                }
                else if (!expressTicketInfo.isEmpty()) // For express tickets
                {
                    while (dataExpress != null)
                    {
                        Cus = (Customer) dataExpress;
                        Cus.CustomerPrint();
                        dataExpress= expressTicketInfo.getNext();
                    }
                }

                // Input
                String modify2 = JOptionPane.showInputDialog(f,"Which ticket do you want to modify? Insert the ticket ID (????): ");   
                int modify = Integer.parseInt(modify2);

                Customer modifyCustNormal = (Customer) normalTicketInfo.getFirst();
                Customer modifyCustExpress = (Customer) normalTicketInfo.getFirst();

                // Edit normal ticket type
                if (ticketType.equalsIgnoreCase("Normal"))
                {
                    while(modifyCustNormal.getTicketID() != modify)
                        modifyCustNormal = (Customer) normalTicketInfo.getNext();

                    // Delete the count head (calculation) before 
                    if (modifyCustNormal.getAge() >= 2 && modifyCustNormal.getAge() < 18)
                        countChildren--;
                    else if(modifyCustNormal.getAge() >= 18 && modifyCustNormal.getAge() < 60)
                        countAdult--;
                
                    String icNum= JOptionPane.showInputDialog(f,"Input new identification number (XXXXXX-XX-XXXX): ");   
                    modifyCustNormal.setIC(icNum);

                    String name= JOptionPane.showInputDialog(f,"Input new name: ");  
                    modifyCustNormal.setName(name);
    
                    String age2= JOptionPane.showInputDialog(f,"Input new age: ");  
                    int age = Integer.parseInt(age2);
                    modifyCustNormal.setAge(age);

                    // Add the count head (calculation) after modified
                    if (modifyCustNormal.getAge() >= 2 && modifyCustNormal.getAge() < 18) 
                        countChildren++;
                    else if(modifyCustNormal.getAge() >= 18 && modifyCustNormal.getAge() < 60) 
                        countAdult++;
                }
                // Edit express ticket type
                else if(ticketType.equalsIgnoreCase("Express"))
                {
                    while(modifyCustExpress.getTicketID() != modify)
                        modifyCustExpress = (Customer) expressTicketInfo.getNext();

                    // Delete the count head (calculation) before 
                    if (modifyCustExpress.getAge() >= 2 && modifyCustExpress.getAge() < 18)
                        countChildren--;
                    else if(modifyCustExpress.getAge() >= 18 && modifyCustExpress.getAge() < 60)
                        countAdult--;

                    String icNum= JOptionPane.showInputDialog(f,"Input new identification number (XXXXXX-XX-XXXX): ");   
                    modifyCustExpress.setIC(icNum);

                    String name= JOptionPane.showInputDialog(f,"Input new name: ");  
                    modifyCustExpress.setName(name);
    
                    String age2= JOptionPane.showInputDialog(f,"Input new age: ");  
                    int age = Integer.parseInt(age2);
                    modifyCustExpress.setAge(age);

                    // Add the count head (calculation) after modified
                    if (modifyCustExpress.getAge() >= 2 && modifyCustExpress.getAge() < 18) 
                        countChildren++;
                    else if(modifyCustExpress.getAge() >= 18 && modifyCustExpress.getAge() < 60) 
                        countAdult++;
                }
                continue; // Continue loop
            }
            else if (menuChoice == 4) // Display
            {
                // Calculate Payment....
                if(ticketType.equalsIgnoreCase("Normal"))
                {
                    // Total heads
                    totalPayment = (countChildren * childrenPriceNormal) + (countAdult * adultPriceNormal);

                    // Discount
                    if (totalPayment > 200)
                        discount = 0.17;
                    else
                        discount = 0.10;
                    totalPayment = totalPayment * (1 - discount);

                    // Insert data
                    Payment pay = (Payment) paymentNormalQueue.getFront(); // Get normal queue
                    pay.setTotalPayment(totalPayment);
                }
                else if(ticketType.equalsIgnoreCase("Express"))
                {
                    // Total heads
                    totalPayment = (countChildren * childrenPriceExpress) + (countAdult * adultPriceExpress);

                    // Discount
                    if (totalPayment > 200)
                        discount = 0.17;
                    else
                        discount = 0.10;
                    totalPayment = totalPayment * (1 - discount);

                    Payment pay = (Payment) paymentExpressQueue.getFront(); // Get express queue
                    pay.setTotalPayment(totalPayment);
                }
                System.out.printf("");
                System.out.println("----------------------------------------------------------------------------------------------------");
                System.out.println("\t\t\tGenting SkyWorlds Theme Park Ticket List");
                System.out.printf("----------------------------------------------------------------------------------------------------\n");
                
                Customer Cus = null;
                Object dataNormal  = normalTicketInfo.getFirst();
                Object dataExpress = expressTicketInfo.getFirst();
                // Show Customer tickets.
                if (!normalTicketInfo.isEmpty()) // For normal tickets
                {
                    while (dataNormal != null)
                    {
                        Cus = (Customer) dataNormal;
                        Cus.CustomerPrint();
                        dataNormal= normalTicketInfo.getNext();
                    }
                }
                else if (!expressTicketInfo.isEmpty()) // For express tickets
                {
                    while (dataExpress != null)
                    {
                        Cus = (Customer) dataExpress;
                        Cus.CustomerPrint();
                        dataExpress= expressTicketInfo.getNext();
                    }
                }

                // Show Payment datas.
                Payment PayN = null;
                Payment PayQ = null;
                Object dataPaymentN = paymentNormalQueue.getFront();
                Object dataPaymentQ = paymentExpressQueue.getFront();

                System.out.println("");
                System.out.println("----------------------------------------------------------------------------------------------------");
                System.out.print("\n\t\t\t\t\tPayment Info\n");
                System.out.println("----------------------------------------------------------------------------------------------------");
        
                PayN = (Payment) dataPaymentN;
                PayQ = (Payment) dataPaymentQ;

                if (!paymentNormalQueue.isEmpty()) // For normal tickets
                {
                    PayN.PaymentPrint();
                }
                else if (!expressTicketInfo.isEmpty()) // For express tickets
                {
                    PayQ.PaymentPrint();
                }
                System.out.println("----------------------------------------------------------------------------------------------------\n");
                System.out.println("Thank you for using this program!\n");
                break; // Out from loop
            }
            else if (menuChoice == 5) {
                // Exit program
                System.out.println("Thank you for using this program!\n");
                break; // Out from loop
            }
            displayMenu(); // Continue display
        }
        input.close();
    }



    // functions
    private static void displayMenu() {
        if (menuListCount == 1) 
        {
            menuChoice2= JOptionPane.showInputDialog(null,
            "Main Menu\n"+
            "1- Add ticket\n"+
            "2- Remove ticket\n"+
            "3- Modify ticket\n"+
            "4- Display ticket\n"+
            "5- Exit program\n"+
            "Input either 1, 2, 3, 4 or 5", "Welcome to Genting SkyWorlds Theme Park!", JOptionPane.QUESTION_MESSAGE);
            menuChoice = Integer.parseInt(menuChoice2);
        }
        else if (menuListCount >= 2) 
        {
            menuChoice2= JOptionPane.showInputDialog(null,
            "Main Menu\n"+
            "1- Add ticket\n"+
            "2- Remove ticket\n"+
            "3- Modify ticket\n"+
            "4- Display ticket\n"+
            "5- Exit program\n"+
            "Input either 1, 2, 3, 4 or 5", "Do you want to do anything else?", JOptionPane.QUESTION_MESSAGE);
            menuChoice = Integer.parseInt(menuChoice2);
        }
    }

    // Random number for ticket ids.
    private static int GenerateRandom () {
        int min = 1000;
        int max = 9999;

        //Generate random int value from 1000 to 9999
        int random = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random;
    }
}