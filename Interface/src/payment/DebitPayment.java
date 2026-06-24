package payment;

public class DebitPayment implements Payment {
    
    private String clientName;
    private String serviceName;
    private float originalValue;
    private float taxAmount;
    private float finalValue;

    // Default constructor
    public DebitPayment() {}

    // Constructor to receive details from the Menu selection
    public DebitPayment(String clientName, String serviceName, float serviceValue) {
        this.clientName = clientName;
        this.serviceName = serviceName;
        this.originalValue = serviceValue;
    }

    @Override
    public void paymentDetails() {
        System.out.println("\n=================================");
        System.out.println("       DEBIT PAYMENT RULES       ");
        System.out.println("=================================");
        System.out.println("* All debit card transactions incur a 1.0% processing tax.");
        System.out.println("* Funds are deducted directly and immediately from your bank account.");
        System.out.println("* Please ensure you have an active network connection for authentication.");
        System.out.println("=================================");
    }

    @Override
    public void paymentCalc() {
        // Apply the 1% debit card transaction tax
        this.taxAmount = this.originalValue * 0.01f;
        this.finalValue = this.originalValue + this.taxAmount;
    }

    @Override
    public void displayPaymentOrder() {
        System.out.println("\n=================================");
        System.out.println("          PAYMENT ORDER          ");
        System.out.println("=================================");
        System.out.println("Client Name:    " + this.clientName);
        System.out.println("Service:        " + this.serviceName);
        System.out.println("Original Value: $" + String.format("%.2f", this.originalValue));
        System.out.println("Payment Method: DEBIT CARD");
        System.out.println("Debit Tax (1%): $" + String.format("%.2f", this.taxAmount));
        System.out.println("---------------------------------");
        System.out.println("Final Value:    $" + String.format("%.2f", this.finalValue));
        System.out.println("=================================");
        System.out.println("        Order Successful!        ");
        System.out.println("=================================\n");
    }
}