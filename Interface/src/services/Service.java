// Class to process the services (register, search, etc)

// Packages
package services;

// Externals imports
import java.util.Scanner;

public class Service extends ServiceCatalog {
    private boolean again = true;
    private Scanner sc = new Scanner(System.in);
    
    public Service(){}

    public void enterNewService() {
        do {
            System.out.println("Enter the name of the service: ");
            String newServiceName = sc.nextLine();

            if (newServiceName == null || newServiceName.isEmpty()) {
                System.out.println("\nInvalid name! Restarting...");
                continue; 
            }
            
            System.out.println("Enter the description of the service: ");
            String newDescriptionService = sc.nextLine();

            if (newDescriptionService == null || newDescriptionService.isEmpty()) {
                System.out.println("\nInvalid description! Restarting...");
                continue; 
            }

            System.out.println("Enter the value of the service: ");
            float newServiceValueAmount = 0;
            try {
                newServiceValueAmount = Float.parseFloat(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid number format! Restarting...");
                continue;
            }

    
            this.getNewServiceName().add(newServiceName);
            this.getNewDescriptionService().add(newDescriptionService);
            this.getNewServiceValue().add(newServiceValueAmount);
            
            System.out.println("\nService '" + newServiceName + "' registered with success!");

            System.out.println("\nWant to register another service? Y/N");
            String againAnswer = sc.nextLine().trim();

            if (againAnswer.equalsIgnoreCase("N")) {
                again = false;
            }

        } while (again);
    }

    public void displayAndSearchServices() {
        boolean searchAgain = true;
        do {
            System.out.println("Enter the name of the service you want to search: ");
            String nameServiceSearched = sc.nextLine().trim();

            if (nameServiceSearched == null || nameServiceSearched.isEmpty()) {
                System.out.println("\nInvalid name!");
                continue;
            }

            int index = this.getNewServiceName().indexOf(nameServiceSearched);

            if (index != -1) {
                System.out.println("\n--- Service Found (Custom Registry) ---");
                System.out.println("Name:        " + this.getNewServiceName().get(index));
                System.out.println("Description: " + this.getNewDescriptionService().get(index));
                System.out.println("Value:       $" + this.getNewServiceValue().get(index));
            } else {
                int catalogIndex = ServiceCatalog.getServiceNames().indexOf(nameServiceSearched);
                if (catalogIndex != -1) {
                    System.out.println("\n--- Service Found (Default Catalog) ---");
                    System.out.println("Name:        " + ServiceCatalog.getServiceNames().get(catalogIndex));
                    System.out.println("Description: " + ServiceCatalog.getServiceDescriptions().get(catalogIndex));
                    System.out.println("Value:       $" + ServiceCatalog.getServiceValues().get(catalogIndex));
                } else {
                    System.out.println("\nService '" + nameServiceSearched + "' not found.");
                }
            }

            System.out.println("\nWant to search another service? Y/N");
            String answer = sc.nextLine().trim();
            if (answer.equalsIgnoreCase("N")) {
                searchAgain = false;
            }
        } while (searchAgain);
    }
}