
import java.util.Scanner;
import services.Service;
import services.ServiceCatalog;
import payment.*;

public class Menu {
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
                    displayAllAvailableServices();
                    break;
                case "2":
                    serviceManager.enterNewService(); 
                    break;
                case "3":
                    serviceManager.displayAndSearchServices(); 
                    break;
                case "4":
                    handleServiceOrdering();
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

    
    private void displayAllAvailableServices() {
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
        if (!serviceManager.getNewServiceName().isEmpty()) {
            System.out.println("\n--- Custom Registered Services ---");
            for (int i = 0; i < serviceManager.getNewServiceName().size(); i++) {
                System.out.println((i + 1 + ServiceCatalog.getServiceNames().size()) + ". " + 
                                   serviceManager.getNewServiceName().get(i) + 
                                   " - $" + serviceManager.getNewServiceValue().get(i));
            }
        }
        System.out.println("=================================\n");
    }

    
    private void handleServiceOrdering() {
        System.out.println("\nEnter the exact name of the service you want to purchase: ");
        String chosenServiceName = sc.nextLine().trim();

        String serviceName = "";
        float serviceValue = 0f;
        boolean found = false;

        // Check local dynamic entries first
        int index = serviceManager.getNewServiceName().indexOf(chosenServiceName);
        if (index != -1) {
            serviceName = serviceManager.getNewServiceName().get(index);
            serviceValue = serviceManager.getNewServiceValue().get(index);
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
        System.out.print("Choice: ");
        String paymentChoice = sc.nextLine().trim();

        Payment paymentProcessor = null;

        switch (paymentChoice) {
            case "1":
                paymentProcessor = new PixPayment(clientName, serviceName, serviceValue);
                break;

            case "2":
                System.out.print("Enter number of installments (1 to 3): ");
                int installments = 1;
                try {
                    installments = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid format. Defaulting to 1x.");
                }
                paymentProcessor = new CreditPayment(clientName, serviceName, serviceValue, installments);
                break;

            case "3":
                System.out.print("Enter due date (dd/mm/yyyy): ");
                String dueDate = sc.nextLine().trim();
                System.out.print("Enter actual payment date (dd/mm/yyyy): ");
                String paymentDate = sc.nextLine().trim();
                try {
                    paymentProcessor = new BankPayment(clientName, serviceName, serviceValue, dueDate, paymentDate);
                } catch (Exception e) {
                    System.out.println("\nDate parsing failed! Make sure to write exactly as dd/mm/yyyy.");
                    return;
                }
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