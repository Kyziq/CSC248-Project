// Customer Info
public class Customer {
    private String icNum; 
    private String name; 
    private int age; // Baby - <2 years, Children - 2-17years, Adult - 18-59years, Senior Adult - 60+years
    private int index;

    // Default Constructor
    public Customer() {
        icNum = "";
        name = "";
        age = -1;
        index = 1;
    }
    // Normal Constructor
    public Customer(String icNum, String name, int age, int index) {
        this.icNum = icNum;
        this.name = name;
        this.age = age;
        this.index = index;
    }
    // Group Setter
    public void setCustomer(String icNum, String name, int age, int index) {
        this.icNum = icNum;
        this.name = name;
        this.age = age;
        this.index = index;
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
    public int getIndex(){
        return this.index;
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
    public void setIndex(int newIndex){
        this.index = newIndex;
    }
    // Printer
    public String toStringCust() { 
        return( "No " + index +" | IC Number: "+icNum+" | Name: "+name+" | Age: "+age);
    }
}