
import java.util.Scanner;
import services.Service;

public class Menu {
    // Single persistent instance of your service engine
    private Service serviceManager = new Service();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        boolean exit = false;

        while (!exit) {
            System.out.println("=================================");
            System.out.println("            MAIN MENU            ");
            System.out.println("=================================");
            System.out.println("1. Display all services");
            System.out.println("2. Register a service");
            System.out.println("3. Search for a service");
            System.out.println("4. Order a service");
            System.out.println("5. Leave");
            System.out.println("=================================");
            System.out.print("Choose an option: ");

            String option = sc.nextLine().trim();

            switch (option) {
                case "1":
                    // Calls the updated method inside Service.java
                    serviceManager.displayAllAvailableServices(); 
                    break;
                case "2":
                    // Calls the registration engine inside Service.java
                    serviceManager.enterNewService(); 
                    break;
                case "3":
                    // Calls the search engine inside Service.java
                    serviceManager.displayAndSearchServices(); 
                    break;
                case "4":
                    // Calls the full 6-method checkout system inside Service.java
                    serviceManager.handleServiceOrdering(); 
                    break;
                case "5":
                    System.out.println("\nThank you for using our system. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("\nInvalid option! Please try again.\n");
            }
        }
    }
}