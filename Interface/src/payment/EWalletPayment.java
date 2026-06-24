package payment;

public class EWalletPayment implements Payment {
    
    private String clientName;
    private String serviceName;
    private float originalValue;
    private float taxAmount;
    private float finalValue;

    // Default constructor
    public EWalletPayment() {}

    // Constructor to receive details from the Menu selection
    public EWalletPayment(String clientName, String serviceName, float serviceValue) {
        this.clientName = clientName;
        this.serviceName = serviceName;
        this.originalValue = serviceValue;
    }

    @Override
    public void paymentDetails() {
        System.out.println("\n=================================");
        System.out.println("      E-WALLET PAYMENT RULES     ");
        System.out.println("=================================");
        System.out.println("* All digital wallet transactions incur a 1.5% processing service tax.");
        System.out.println("* Offers quick one-tap verification and checkout.");
        System.out.println("* Safe and secured via tokenized credentials.");
        System.out.println("=================================");
    }

    @Override
    public void paymentCalc() {
        // Apply the 1.5% e-wallet service tax
        this.taxAmount = this.originalValue * 0.015f;
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
        System.out.println("Payment Method: E-WALLET");
        System.out.println("Service Tax(1.5%):$" + String.format("%.2f", this.taxAmount));
        System.out.println("---------------------------------");
        System.out.println("Final Value:    $" + String.format("%.2f", this.finalValue));
        System.out.println("=================================");
        System.out.println("        Order Successful!        ");
        System.out.println("=================================\n");
    }
}