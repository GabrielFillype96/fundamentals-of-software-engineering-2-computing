package services;

import services.ServiceCatalog;

import java.util.ArrayList;
import java.util.Scanner;

public class Service extends ServiceCatalog{
    // private ArrayList<String> serviceNames = new ArrayList<>();
    // private ArrayList<String> serviceDescriptions = new ArrayList<>();
    // private ArrayList<Float> serviceValues = new ArrayList<>();
    private boolean again = true;
    private Scanner sc = new Scanner(System.in);
    
    public Service(){}

    // public Service(ArrayList<String> serviceNames, ArrayList<String> serviceDescriptions, ArrayList<Float> serviceValues){
    //     this.serviceNames = serviceNames;
    //     this.serviceDescriptions = serviceDescriptions;
    //     this.serviceValues = serviceValues;
    // }

    public void enterNewService() {
        
        do {
            System.out.println(
                "Enter the name of the service: "
            );
            String newServiceName = sc.nextLine();

            // Validate Name
            if (newServiceName == null || newServiceName.isEmpty()) {
                System.out.println(
                    "\nInvalid name! Restarting service entry..."
                );
                continue; // Skips the rest of the loop iteration and tries again
            }
            
            System.out.println(
                "Enter the description of the service: "
            );
            String newDescriptionService = sc.nextLine();

            // Validate Description
            if (newDescriptionService == null || newDescriptionService.isEmpty()) {
                System.out.println(
                    "\nInvalid description! Restarting service entry..."
                );
                continue; 
            }

            System.out.println(
                "Enter the value of the service: "
            );
            float newServiceValue = 0;
            try {
                // Read as line and parse to avoid the scanner skipping issue!
                newServiceValue = Float.parseFloat(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(
                    "\nInvalid number format! Restarting service entry..."
                );
                continue;
            }

            // Validate Value amount
            if (newServiceValue <= 0) {
                System.out.println(
                    "\nInvalid value! Please insert a positive value. Restarting service entry..."
                );
                continue;
            }

            // Only add to the lists IF all three inputs passed validation successfully
            //this.serviceNames.add(newServiceName);
            ServiceCatalog.setNewServiceName(newServiceName);
            this.serviceDescriptions.add(newDescriptionService);
            this.serviceValues.add(newServiceValue);
            System.out.println(
                "\nService '" + newServiceName + "' registered with success!"
            );

            // Prompting for another entry
            System.out.println(
                "\nWant to register another service? Y/N"
            );
            String againAnswer = sc.nextLine().trim(); // .trim() removes accidental spaces

            if (againAnswer.equalsIgnoreCase("N")) {
                again = false;
            }

        } while (again);

        // Print Results
        System.out.println("\n=================================");
        System.out.println("       REGISTERED SERVICES       ");
        System.out.println("=================================");

        if (serviceNames.isEmpty()) {
            System.out.println(
                "No services were registered."
            );
        } else {
            for (int i = 0; i < serviceNames.size(); i++) {
                System.out.println("Service #" + (i + 1));
                System.out.println("Name:        " + serviceNames.get(i));
                System.out.println("Description: " + serviceDescriptions.get(i));
                System.out.println("Value:       $" + serviceValues.get(i));
                System.out.println("---------------------------------");
            }
        }
    }

    // Method to 
    public void displayAndSearchServices() {
        boolean searchAgain = true;
        do {
            System.out.println(
                "Enter the name of the service you want to search: "
            );
            String nameServiceSearched = sc.nextLine().trim(); // .trim() removes accidental spaces

            // Validate Name
            if (nameServiceSearched == null || nameServiceSearched.isEmpty()) {
                System.out.println(
                    "\nInvalid name! Restarting the service searching..."
                );
                continue; // Skips the rest of the loop iteration and tries again
            }

            // 1. Search the user's custom registered services list
        int index = serviceNames.indexOf(nameServiceSearched);

        if (index != -1) {
            // Found in custom list
            System.out.println("\n--- Service Found (Custom Registry) ---");
            System.out.println("Name:        " + serviceNames.get(index));
            System.out.println("Description: " + serviceDescriptions.get(index));
            System.out.println("Value:       $" + serviceValues.get(index));
            System.out.println("---------------------------------------");
        } else {
            // 2. Not found in custom list, check the static catalog
            int catalogIndex = ServiceCatalog.getServiceNames().indexOf(nameServiceSearched);
            
            if (catalogIndex != -1) {
                // Found in the default Catalog!
                System.out.println("\n--- Service Found (Default Catalog) ---");
                System.out.println("Name:        " + ServiceCatalog.getServiceNames().get(catalogIndex));
                System.out.println("Description: " + ServiceCatalog.getServiceDescriptions().get(catalogIndex));
                System.out.println("Value:       $" + ServiceCatalog.getServiceValues().get(catalogIndex));
                System.out.println("---------------------------------------");
            } else {
                // Not found anywhere
                System.out.println("\nService '" + nameServiceSearched + "' not found in our registry or catalog.");
            }
        }

            // Ask user if they want to search for something else
            System.out.println(
                "\nWant to search another service? Y/N"
            );
            String answer = sc.nextLine().trim();

            if (answer.equalsIgnoreCase("N")) {
                searchAgain = false;
            }

        } while (searchAgain);

    }
}