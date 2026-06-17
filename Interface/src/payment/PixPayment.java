package payment;

public class PixPayment implements Payment {
    
    private String clientName;
    private String serviceName;
    private float originalValue;
    private float discountAmount;
    private float finalValue;

    // Default constructor
    public PixPayment() {}

    // Constructor to receive all the required details from the Menu selection
    public PixPayment(String clientName, String serviceName, float serviceValue) {
        this.clientName = clientName;
        this.serviceName = serviceName;
        this.originalValue = serviceValue;
    }

    @Override
    public void paymentDetails() {
        System.out.println("\n=================================");
        System.out.println("        PIX PAYMENT RULES        ");
        System.out.println("=================================");
        System.out.println("* All PIX payments grant an immediate 10% discount on the total amount.");
        System.out.println("* Transactions are processed instantly, 24/7.");
        System.out.println("* Please ensure you have sufficient balance before approving the transfer.");
        System.out.println("=================================");
    }

    @Override
    public void paymentCalc() {
        // Calculate a 10% discount
        this.discountAmount = this.originalValue * 0.10f;
        this.finalValue = this.originalValue - this.discountAmount;
    }

    @Override
    public void displayPaymentOrder() {
        System.out.println("\n=================================");
        System.out.println("          PAYMENT ORDER          ");
        System.out.println("=================================");
        System.out.println("Client Name:    " + this.clientName);
        System.out.println("Service:        " + this.serviceName);
        System.out.println("Original Value: $" + String.format("%.2f", this.originalValue));
        System.out.println("Payment Method: PIX");
        System.out.println("Discount (10%): $" + String.format("%.2f", this.discountAmount));
        System.out.println("---------------------------------");
        System.out.println("Final Value:    $" + String.format("%.2f", this.finalValue));
        System.out.println("=================================");
        System.out.println("        Order Successful!        ");
        System.out.println("=================================\n");
    }
}