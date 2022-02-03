import java.io.PrintStream;

// Customer Info
public class Customer {
    private String icNum; 
    private String name; 
    private int age; // Baby - <2 years, Children - 2-17years, Adult - 18-59years, Senior Adult - 60+years
    private int ticketID;

    // Default Constructor
    public Customer() {
        icNum = "";
        name = "";
        age = -1;
        ticketID = -1;
    }
    // Normal Constructor
    public Customer(String icNum, String name, int age, int ticketID) {
        this.icNum = icNum;
        this.name = name;
        this.age = age;
        this.ticketID = ticketID;
    }
    // Group Setter
    public void setCustomer(String icNum, String name, int age, int ticketID) {
        this.icNum = icNum;
        this.name = name;
        this.age = age;
        this.ticketID = ticketID;
    }
    // Getters
    public String getIC() {
        return this.icNum;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public int getTicketID(){
        return this.ticketID;
    }
    // Setters
    public void setIC(String newICNum) {
        this.icNum = newICNum;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    public void setAge(int newAge) {
        this.age = newAge;
    }
    public void setTicketID(int newTicketID){
        this.ticketID = newTicketID;
    }
    // Printer
    public PrintStream CustomerPrint() {
        return System.out.printf("Ticket ID: %d | IC Number: %-20s | Name: %-20S | Age: %d %n", ticketID, icNum, name, age);
    }
}