import java.util.Scanner;

public class mainApp {
    public static void main(String[] args) {
        LinkedList info = new LinkedList();
        Scanner input = new Scanner(System.in);

        while(true) {
            displayMenu();
            int choice = input.nextInt();

            if (choice == 1) {
                // Add

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
        }
    }
    private static void displayMenu() {
        System.out.println("-\tWelcome to Genting SkyWorlds Theme Park!\t-");
        System.out.println("-\tMain Menu\t-");
        System.out.println("-\t1) Add\t-");
        System.out.println("-\t2) Remove\t-");
        System.out.println("-\t3) Display\t-");
        System.out.println("-\t4) Exit\t-");
        System.out.println("------------------");
    }
}