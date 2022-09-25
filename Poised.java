/*REFERENCES
 * 
 * Reference 1
 * I used edureka resources
 * https://www.edureka.co/community/181113/array-of-string-with-unknown-size
 * I wanted how to create array of unknown size to store my projects
 * 
 * Reference 2
 * I used w3school resources
 * https://www.w3schools.com/java/java_try_catch.asp
 * I wanted to understand how to use try-catch to make the program defensive
 * 
 * Reference 3
 * I used programiz resources
 * https://www.programiz.com/java-programming/library/arraylist/get
 * I was structing to acess elements in the array
 * now I know I can use my object with get() method together with my attribute
 * 
 * Reference 4
 * I used resources from other tasks, L1T23, L2T03 and L2T06
 * */



// Import the Scanner class to take users input
import java.util.Scanner;  

// Import array class
import java.util.ArrayList;


// Class declaration
public class Poised {
	
	public static void main(String[] args) {
		
		// this array will store all newProject instances
		ArrayList<Project> project = new ArrayList<>();
		
		System.out.println("\n++++++++++++++++++++ Welcome to Poised Project Management System ++++++++++++++++++++ \n");
		
		// providing the user with options to choose from 
		while (true) {
			System.out.print("\nSelect one of the following Options below:\n"
					+ "\n1 - Create New projects"
					+ "\n2 - Change Deadline of the project"
					+ "\n3 - Change total amount of the fee paid to date"
					+ "\n4 - Update contractors contact details"
					+ "\n5 - Finalise Project"
					+ "\n0 - Exit:   ");
			
			// requesting the user input
			Scanner input = new Scanner(System.in);
			String option = input.nextLine();
			
			// base on what the user select, an appropriate method is executed
			if (option.equals("1")) {
				newProject(project);
				
			} else if (option.equals("2")) {
				newDeadline(project);
				
			} else if (option.equals("3")) {
				updateFees(project);
				
			} else if (option.equals("4")) {
				newDetails(project);
				
			} else if (option.equals("5")) {
				finaliseProject(project);
				
			} else if (option.equals("0")) {
				System.out.println("\nGoodbye, see you next time around");
				System.exit(0);
			} else {
				System.out.println("\nInvalid Input. Try Again\n");
			}
		}
	  
	}
	
	
	// this method is used to collect information about on all stakeholders
	public static String[] getDetails(String function) {
		Scanner input = new Scanner(System.in);
		
		// collecting all information required for each person involves in a project
		System.out.print("\nWhat is the name of " + function + ": ");
		String name = input.nextLine();
		
		System.out.print("\nWhat is the telephone of " + function + ": ");
		String telephone = input.nextLine();
		
		System.out.print("\nWhat is the email of " + function + ": ");
		String email = input.nextLine();
		
		System.out.print("\nWhat is the physical address of " + function + ": ");
		String physicalAddress = input.nextLine();
		
		// returning a string array with the information collected
		return new String[]{name, telephone, email, physicalAddress};
		
	}
		
	
	
	// this method create all information about new project
	private static void newProject(ArrayList<Project> project) {
		
		// Instantiate objects for each person using the information collected in getDetails
		String[] customerDetails = getDetails("customer");
		Customer customer = new Customer(customerDetails[0], customerDetails[1], customerDetails[2], customerDetails[3]);
		
		String[] architectDetails = getDetails("architect");
		Architect architect = new Architect(architectDetails[0], architectDetails[1], architectDetails[2], architectDetails[3]);
	
		String[] contractorDetails = getDetails("contractor");
		Contractor contractor = new Contractor(contractorDetails[0], contractorDetails[1], contractorDetails[2], contractorDetails[3]);
		
		Scanner input = new Scanner(System.in);
		
		// collecting project number from the user
		// using try-catch to make the program defensive from incorrect user inputs
		int projectNumber = 0;
		while (true) {
			try {
			System.out.print("\nEnter Project Number: ");
			projectNumber = Integer.parseInt(input.nextLine());
			break;
			
			} catch (Exception e) {
				System.out.println("\nPlease enter correct format of project number (e.g 0004)");
			}
		}
		
		
		// collecting project name
		System.out.print("\nEnter Project Name: ");
		String projectName = input.nextLine();
		
		
		// collecting building type
		System.out.print("\nWhat type of building is the project designed for (House, Apartment block or "
				+ "Store, etc): ");
		String buildingType = input.nextLine();

		
		// collecting physical address for the project
		System.out.print("\nWhat is physical address for the project: ");
		String physicalAddress = input.nextLine();
		
		// collecting erf number and use try-catch
		int erfNumber = 0;
		while (true) {
			try {
			System.out.print("\nWhat is ERF Number: ");
			erfNumber = Integer.parseInt(input.nextLine());
			break;
			
			} catch (Exception e) {
				System.out.println("\nPlease enter correct format of ERF (e.g 938)");
			}
		}
		
		
		// collecting total cost of the project
		int totalFee = 0;
		while (true) {
			try {
			System.out.print("\nWhat is the total fee being charged for the project: ");
			totalFee = Integer.parseInt(input.nextLine());
			break;
			
			} catch (Exception e) {
				System.out.println("\nPlease enter correct format of amount (e.g 100)");
			}
		}
		
		
		// collecting amount paid to date
		int totalPaid = 0;
		while (true) {
			try {
			System.out.print("\nWhat is the total amount paid to date: ");
			totalPaid = Integer.parseInt(input.nextLine());
			break;
			
			} catch (Exception e) {
				System.out.println("\nPlease enter correct format of amount (e.g 100)");
			}
		}
		
		
		// asking user to enter due date of the project
		System.out.print("\nWhat is the Deadline for Project (YYY-mm-dd format): ");
        String deadline = input.nextLine();
        
        
        // Instantiate objects of Project using all information 
        Project newProject = new Project(projectNumber, projectName, buildingType, physicalAddress, erfNumber, totalFee,
        		totalPaid, deadline, architect, contractor, customer);
        
        
        // if the user did not provide project name, the project name will be made by
        // combining building type and customer name
        // this is achieved by using setter method: setProjectName
        if (projectName == "") {
        	newProject.setProjectName(buildingType + " " + customer.name );
        }
        
        
        // adding the created object to project array
        project.add(newProject);
        
        
        // once all information is capture, print the information to user screen
        System.out.print("\nProject added sucessfully" + newProject);
        
	}
	
	
	// this method is used to change due date of the project
	private static void newDeadline(ArrayList<Project> project) {
		Scanner input = new Scanner(System.in);
		
		int i = 0;
		try {
		
			// asking the user to enter the index of the project they want to change due date for
			System.out.print("\nEnter project index you want to change deadline for: ");
			i = Integer.parseInt(input.nextLine());
			
			
			// if index is within the size of the project, the next code will be executed
			// if not the user will be told the project is not found
			if (i < project.size()) {
				
				// requesting new date from the user
				System.out.print("\nEnter new deadline (YYY-mm-dd format): ");
				String newdeadline = input.nextLine();
				
				Project updatedProjectDeadline = project.get(i);
				
				// update the project due date using setter: setDeadline
				updatedProjectDeadline.setDeadline(newdeadline);
				
				System.out.print("\nYou have updated the due date\n");
				
			} else {
					System.out.println("\nProject with entered index does not exist");
			}
			
		} catch (Exception e) {
				System.out.println("\nPlease enter correct format of index (e.g 0 - first project)");
		}
	}
	
	// this method update the fees of the project
	private static void updateFees(ArrayList<Project> project) {
		Scanner input1 = new Scanner(System.in);
		
		int j = 0;
		int newFees = 0;
		try {
			
			// asking the user to enter the index of the project they want to update amount paid to date
			System.out.print("\nEnter project index you want to update paid amount for: ");
			j = Integer.parseInt(input1.nextLine());
			
			if (j < project.size()) {
			System.out.print("\nEnter new amount paid to the project: ");
			newFees = Integer.parseInt(input1.nextLine());
			
			// update date using setter: settotalPaid
			Project updateProjectFees = project.get(j);
			updateProjectFees.settotalPaid(newFees);
			
			System.out.print("\nYou have updated the paid fees successfully\n");
			
			} else {
				System.out.println("\nProject with entered index does not exist");
			}
			
		} catch (Exception e) {
			System.out.println("\nEnter correct format of index. Please try again");
		}
	}
	
	
	// this method is used to update contractor information
	private static void newDetails(ArrayList<Project> project) {
		Scanner input3 = new Scanner(System.in);
		
		int t = 0;
		
		try {
			// asking the user to enter the index of the project they want to update contractor details for
			System.out.print("\nEnter project index you want to update contractor contact details for: ");
			t = Integer.parseInt(input3.nextLine());
			
			if (t < project.size()) {
			String[] updatedDetails = getDetails("contractor");
			Contractor updatedContractor = new Contractor(updatedDetails[0], updatedDetails[1], updatedDetails[2], updatedDetails[3]);
				
			//updating contractor using setter: setContractor
			Project newContractor = project.get(t);
			newContractor.setContractor(updatedContractor);
			
			System.out.print("\nYou have updated the Contractor details\n");
			
			} else {
				System.out.println("\nProject with entered index does not exist.");
			}
			
		} catch (Exception e) {
			System.out.println("\nEnter correct format of index. Please try again.");
		}
	}
	
	
	// this method is used to finalize projects
	private static void finaliseProject(ArrayList<Project> project) {
		
		// we need to loop through all the projects
		for (int i = 0; i < project.size(); i++) {
			
			// calculate the balance, the customer need to pay
			// by subtracting: totalFee - totalPaid
			double balance = project.get(i).totalFee - project.get(i).totalPaid;
			
			// if the balance is equal to zero, no invoice will be printed
			if (balance == 0) {
				System.out.println("\nYour balance is 0 so there is no invoice");
				
			// else all invoices will be printed
			} else {
				System.out.println("\nINVOICE\n");
				System.out.println("Customer name: " + project.get(i).customer.name + "\n" + "Contact details: " + project.get(i).customer.telephone
						+ "\nOpening balance:" + project.get(i).totalFee + "\n" + "Paid amount to date: " + project.get(i).totalPaid + "\n" + "\nclosing balance: " + balance + "\n");
			}
		}
	}
}
