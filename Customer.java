// Declaring class
public class Customer {
	// Attributes
	String name;
	String telephone;
	String email;
	String physicalAddress;
		
	// Constructor Method
	public Customer(String name, String telephone, String email, String physicalAddress) {
		this.name = name;
		this.telephone = telephone;
		this.email = email;
		this.physicalAddress = physicalAddress;
	}
	
	// getter method to access name
	public String getName() {
	return name;
	}
	
	
	// toString method
    public String toString() {
        String output = "Name: " + name;
        output += "\nTelephone: " + telephone;
        output += "\nEmail Address: " + email;
        output += "\nPhysical Address: " + physicalAddress;

        return output;
    }
}
