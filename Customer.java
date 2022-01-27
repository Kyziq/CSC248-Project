// Customer Info

public class Customer {
    private int icNum; 
    private String name; 
    private int age; // Baby - <2 years, Children - 2-17years, Adult - 18-59years, Senior Adult - 60+years

    // Default Constructor
    public Customer() {
        icNum = -1;
        name = "";
        age = -1;
    }
    // Normal Constructor
    public Customer(int icNum, String name, int age) {
        this.icNum = icNum;
        this.name = name;
        this.age = age;
    }
    // Group Setter
    public void setCustomer(int icNum, String name, int age) {
        this.icNum = icNum;
        this.name = name;
        this.age = age;
    }
    // Getters
    public int getIC() {
        return this.icNum;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    // Setters
    public void setIC(int newICNum) {
        this.icNum = newICNum;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    public void setAge(int newAge) {
        this.age = newAge;
    }
    // Printer
    public String toString() { 
        return("");
    }
}