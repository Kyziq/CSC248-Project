public class Payment {
    private int totalPayment; 
    private String datePurchased; 
    private String dateTicket;
    private String ticketType;

    // Default Constructor
    public Payment() {
        totalPayment = -1;
        datePurchased = "";
        dateTicket = "";
        ticketType = "";
    }
    // Normal Constructor
    public Payment(int totalPayment, String datePurchased, String dateTicket, String ticketType) {
        this.totalPayment = totalPayment;
        this.datePurchased = datePurchased;
        this.dateTicket = dateTicket;
        this.ticketType = ticketType;
    }
    
    // Group Setter
    public void setPayment(int totalPayment, String datePurchased, String dateTicket, String ticketType) {
        this.totalPayment = totalPayment;
        this.datePurchased = datePurchased;
        this.dateTicket = dateTicket;
        this.ticketType = ticketType;
    }
    // Getter Constructor
    public int getTotalPayment() {return totalPayment;}
    public String getDatePurchased () {return datePurchased;}
    public String getDateTicket () {return dateTicket;}
    public String getTicketType () {return ticketType;}
    
    // Setter Constructor
    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }
    public void setDatePurchased(String datePurchased) {
        this.datePurchased = datePurchased;
    }
    public void setDateTicket(String dateTicket) {
        this.dateTicket = dateTicket;
    }
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
}
