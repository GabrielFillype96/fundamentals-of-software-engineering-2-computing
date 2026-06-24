package payment;

public class CryptocurrencyPayment implements Payment {
    
    private String clientName;
    private String serviceName;
    private float originalValue;
    private float taxAmount;
    private float finalValue;

    // Default constructor
    public CryptocurrencyPayment() {}

    // Constructor to receive details from the Menu selection
    public CryptocurrencyPayment(String clientName, String serviceName, float serviceValue) {
        this.clientName = clientName;
        this.serviceName = serviceName;
        this.originalValue = serviceValue;
    }

    @Override
    public void paymentDetails() {
        System.out.println("\n=================================");
        System.out.println("    CRYPTOCURRENCY RULES        ");
        System.out.println("=================================");
        System.out.println("* All crypto transactions incur a 2.5% network processing tax.");
        System.out.println("* Payments are non-reversible once confirmed on the blockchain.");
        System.out.println("* The exchange rate is locked for up to 15 minutes.");
        System.out.println("=================================");
    }

    @Override
    public void paymentCalc() {
        // Apply the 2.5% cryptocurrency transaction tax
        this.taxAmount = this.originalValue * 0.025f;
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
        System.out.println("Payment Method: CRYPTOCURRENCY");
        System.out.println("Crypto Tax(2.5%):$" + String.format("%.2f", this.taxAmount));
        System.out.println("---------------------------------");
        System.out.println("Final Value:    $" + String.format("%.2f", this.finalValue));
        System.out.println("=================================");
        System.out.println("        Order Successful!        ");
        System.out.println("=================================\n");
    }
}