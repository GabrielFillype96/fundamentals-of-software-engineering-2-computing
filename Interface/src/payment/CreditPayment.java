package payment;

import java.util.Scanner;

public class CreditPayment implements Payment {
    
    private String clientName;
    private String serviceName;
    private float originalValue;
    private float feeAmount;
    private float finalValue;
    private int installments;
    private final static float CREDIT_FEE = 0.05f;

    // Construtor padrão
    public CreditPayment() {}

    // Construtor corrigido com Validação Estrita (do-while)
    public CreditPayment(String clientName, String serviceName, float serviceValue, Scanner sc) {
        this.clientName = clientName;
        this.serviceName = serviceName;
        this.originalValue = serviceValue;
        
        boolean valid = false;
        do {
            System.out.print("Enter number of installments (1 to 3): ");
            try {
                int input = Integer.parseInt(sc.nextLine());
                if (input >= 1 && input <= 3) {
                    this.installments = input;
                    valid = true; // Define como verdadeiro para sair do laço
                } else {
                    System.out.println("Error: The number of installments must be between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid format! Please enter a valid number.");
            }
        } while (!valid); 
    }

    @Override
    public void paymentDetails() {
        System.out.println("\n=================================");
        System.out.println("      CREDIT PAYMENT RULES       ");
        System.out.println("=================================");
        System.out.println("* All credit transactions incur a mandatory 5% administrative fee.");
        System.out.println("* Purchases can be split into up to 3 installments (3x maximum).");
        System.out.println("* Installments are processed monthly without additional compounding interest.");
        System.out.println("=================================");
    }

    @Override
    public void paymentCalc() {
        this.feeAmount = this.originalValue * CREDIT_FEE;
        this.finalValue = this.originalValue + this.feeAmount;
    }

    @Override
    public void displayPaymentOrder() {
        float installmentValue = this.finalValue / this.installments;

        System.out.println("\n=================================");
        System.out.println("          PAYMENT ORDER          ");
        System.out.println("=================================");
        System.out.println("Client Name:    " + this.clientName);
        System.out.println("Service:        " + this.serviceName);
        System.out.println("Original Value: $" + String.format("%.2f", this.originalValue));
        System.out.println("Payment Method: CREDIT CARD (" + this.installments + "x)");
        System.out.println("Admin Fee (5%): $" + String.format("%.2f", this.feeAmount));
        System.out.println("---------------------------------");
        System.out.println("Final Value:    $" + String.format("%.2f", this.finalValue));
        
        if (this.installments > 1) {
            System.out.println("Installments:   " + this.installments + " monthly payments of $" + String.format("%.2f", installmentValue));
        }
        
        System.out.println("=================================");
        System.out.println("        Order Successful!        ");
        System.out.println("=================================\n");
    }
}