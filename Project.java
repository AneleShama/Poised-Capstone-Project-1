public class Project {
	
	// Attributes
	int projectNumber;
	String projectName;
	String buildingType;
	String physicalAddress;
	int erfNumber;
	double totalFee;
	double totalPaid;
	String deadline;
	Architect architect;
    Contractor contractor;
    Customer customer;
	
	
	// Constructor Method
	public Project(int projectNumber, String projectName, String buildingType, String physicalAddress, int erfNumber, double totalFee, double totalPaid, 
			String deadline, Architect architect, Contractor contractor, Customer customer) 
	{
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.buildingType = buildingType;
		this.physicalAddress = physicalAddress;
		this.erfNumber = erfNumber;
		this.totalFee = totalFee;
		this.totalPaid = totalPaid;
		this.deadline = deadline;
		this.architect = architect;
		this.contractor = contractor;
		this.customer = customer;
	}
	
	//Setter to change values in the project
	//change deadline of the project
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	//change total amount paid to date
	public void settotalPaid(int totalPaid) {
		this.totalPaid = totalPaid;
	}
	
	// change contractors details
	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}
	
	// change project name
	public void setProjectName(String projectName) {
		this.projectName = projectName;
		}
	
	// getter to access building type
	public String getbuildingType() {
	return buildingType;
	}
	
	// toString method
    public String toString() {
        String output = "\nProject Number: " + projectNumber;
        output += "\nProject Name: " + projectName;
        output += "\nType of building: " + buildingType;
        output += "\nPhysical Address: " + physicalAddress;
        output += "\nERF Number: " + erfNumber;
        output += "\nTotal fee charged for project: " + totalFee;
        output += "\nTotal amount paid to date: " + totalPaid;
        output += "\nDeadline of the project: " + deadline;
        output += "\n\n============================================\n";
        output += "\nCustomer details:\n" + customer;
        output += "\n\n============================================\n";
        output += "\nArchitect details:\n" + architect;
        output += "\n\n============================================\n";
        output += "\nContractor details:\n" + contractor;
        output += "\n\n============================================\n";
        
        return output;
               
    }

}
