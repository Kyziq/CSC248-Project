import java.io.PrintStream;

public class Payment {
    private double totalPayment; 
    private String ticketType;
    private String dateTicket;
    private String datePurchased; 

    // Default Constructor
    public Payment() {
        totalPayment = -1;
        ticketType = "";
        dateTicket = "";
        datePurchased = "";
    }
    // Normal Constructor
    public Payment(double totalPayment, String ticketType, String dateTicket, String datePurchased) {
        this.totalPayment = totalPayment;
        this.ticketType = ticketType;
        this.dateTicket = dateTicket;
        this.datePurchased = datePurchased;
    }
    
    // Group Setter
    public void setPayment(double totalPayment, String ticketType, String dateTicket, String datePurchased) {
        this.totalPayment = totalPayment;
        this.ticketType = ticketType;
        this.dateTicket = dateTicket;
        this.datePurchased = datePurchased;
    }
    // Getter Constructor
    public double getTotalPayment() {return totalPayment;}
    public String getTicketType () {return ticketType;}
    public String getDateTicket () {return dateTicket;}
    public String getDatePurchased () {return datePurchased;}
    
    // Setter Constructor
    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    public void setDateTicket(String dateTicket) {
        this.dateTicket = dateTicket;
    }
    public void setDatePurchased(String datePurchased) {
        this.datePurchased = datePurchased;
    }

    // Printer
    public PrintStream PaymentPrint() {
        return System.out.printf("Total Payment: RM%.2f | Ticket Type: %S | Date Ticket: %s | Date Purchased: %s %n", totalPayment, ticketType, dateTicket, datePurchased);
    }
}
