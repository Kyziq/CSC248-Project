// Customer Info
public class Customer {
    private String icNum; 
    private String name; 
    private int age; // Baby - <2 years, Children - 2-17years, Adult - 18-59years, Senior Adult - 60+years

    // Default Constructor
    public Customer() {
        icNum = "";
        name = "";
        age = -1;
    }
    // Normal Constructor
    public Customer(String icNum, String name, int age) {
        this.icNum = icNum;
        this.name = name;
        this.age = age;
    }
    // Group Setter
    public void setCustomer(String icNum, String name, int age) {
        this.icNum = icNum;
        this.name = name;
        this.age = age;
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
    // Printer
    public String toStringCust() { 
        return("IC Number: "+icNum+" | Name: "+name+" | Age: "+age);
    }
}