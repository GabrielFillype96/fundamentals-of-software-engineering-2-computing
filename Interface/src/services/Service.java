// Class to process the services (register, search, etc)

// Packages
package services;

// Externals imports
import java.util.Scanner;

// Internal imports
import payment.BankPayment;
import payment.CreditPayment;
import payment.CryptocurrencyPayment;
import payment.DebitPayment;
import payment.EWalletPayment;
import payment.Payment;
import payment.PixPayment;

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

    public void displayAllAvailableServices() {
        System.out.println("\n=================================");
        System.out.println("     ALL AVAILABLE SERVICES      ");
        System.out.println("=================================");
        
        // Display fixed background catalog
        System.out.println("--- System Default Catalog ---");
        for (int i = 0; i < ServiceCatalog.getServiceNames().size(); i++) {
            System.out.println((i + 1) + ". " + ServiceCatalog.getServiceNames().get(i) + 
                               " - $" + ServiceCatalog.getServiceValues().get(i));
        }

        // Display user's custom registered services
        if (!this.getNewServiceName().isEmpty()) {
            System.out.println("\n--- Custom Registered Services ---");
            for (int i = 0; i < this.getNewServiceName().size(); i++) {
                System.out.println((i + 1 + ServiceCatalog.getServiceNames().size()) + ". " + 
                                   this.getNewServiceName().get(i) + 
                                   " - $" + this.getNewServiceValue().get(i));
            }
        }
        System.out.println("=================================\n");
    }

    public void handleServiceOrdering() {
        System.out.println("\nEnter the exact name of the service you want to purchase: ");
        String chosenServiceName = sc.nextLine().trim();

        String serviceName = "";
        float serviceValue = 0f;
        boolean found = false;

        // Check local dynamic entries first
        int index = this.getNewServiceName().indexOf(chosenServiceName);
        if (index != -1) {
            serviceName = this.getNewServiceName().get(index);
            serviceValue = this.getNewServiceValue().get(index);
            found = true;
        } else {
            // Check fixed default catalog entries
            int catalogIndex = ServiceCatalog.getServiceNames().indexOf(chosenServiceName);
            if (catalogIndex != -1) {
                serviceName = ServiceCatalog.getServiceNames().get(catalogIndex);
                serviceValue = ServiceCatalog.getServiceValues().get(catalogIndex);
                found = true;
            }
        }

        if (!found) {
            System.out.println("\nError: Service not found. Cannot place an order.\n");
            return;
        }

        // Service found! Now pick up the Client's details
        System.out.println("\nEnter your name: ");
        String clientName = sc.nextLine().trim();
        if (clientName.isEmpty()) {
            System.out.println("Invalid name. Transaction canceled.");
            return;
        }

        // Pick up Payment Method Selection
        System.out.println("\nSelect a payment method:");
        System.out.println("1. PIX (10% Discount)");
        System.out.println("2. Credit Card (Up to 3x, 5% Fee)");
        System.out.println("3. Bank Slip");
        System.out.println("4. Cryptocurrency (2.5% fee)");
        System.out.println("5. E-wallet (1.5% fee)");
        System.out.println("6. Debit Card (1% fee)");
        System.out.print("Choice: ");
        String paymentChoice = sc.nextLine().trim();

        Payment paymentProcessor = null;

        switch (paymentChoice) {
            case "1":
                paymentProcessor = new PixPayment(clientName, serviceName, serviceValue);
                break;

            case "2":
                paymentProcessor = new CreditPayment(clientName, serviceName, serviceValue, sc);
                break;

            case "3":
                paymentProcessor = new BankPayment(clientName, serviceName, serviceValue, sc);
                break;
            
            case "4":
                paymentProcessor = new CryptocurrencyPayment(clientName, serviceName, serviceValue);
                break;
            
            case "5":
                paymentProcessor = new EWalletPayment(clientName, serviceName, serviceValue);
                break;
            
            case "6":
                paymentProcessor = new DebitPayment(clientName, serviceName, serviceValue);
                break;
            
            default:
                System.out.println("\nInvalid payment method selected. Transaction aborted.\n");
                return;
        }

        
        if (paymentProcessor != null) {
            paymentProcessor.paymentDetails();      // Displays specific platform terms
            paymentProcessor.paymentCalc();         // Adjusts for discounts/fines/fees
            paymentProcessor.displayPaymentOrder(); // Generates receipt confirmation
        }
    }
}