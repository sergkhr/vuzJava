package Prac31and32;

public final class Customer {
    private String firstName;
    private String secondName;
    private int age;
    private Address address;
    private static final Customer MATURE_UNKNOWN_CUSTOMER = new Customer("Unknown", "Unknown", 18, Address.EMPTY_ADDRESS);
    private static final Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer("Unknown", "Unknown", 17, Address.EMPTY_ADDRESS);

    public Customer(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getSecondName() {
        return secondName;
    }
    public int getAge() {
        return age;
    }
    public Address getAddress() {
        return address;
    }

    public boolean isMature() {
        return age >= 18;
    }

    public boolean equals(Customer customer) {
        return (this.firstName.equals(customer.firstName) && this.secondName.equals(customer.secondName) && this.age == customer.age && this.address.equals(customer.address));
    }
}
