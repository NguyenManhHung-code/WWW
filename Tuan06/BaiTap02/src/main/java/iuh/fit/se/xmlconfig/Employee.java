package iuh.fit.se.xmlconfig;

public class Employee {
    private int id;
    private String name;
    private Address address;

    public Employee() {}

    // Constructor Injection
    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Setter Injection
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAddress(Address address) { this.address = address; }

    public void showInfo() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
    }
}
