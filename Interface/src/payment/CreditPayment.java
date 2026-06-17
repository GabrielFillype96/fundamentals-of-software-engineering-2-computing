package payment;

public class CreditPayment implements Payment {
    
    private String clientName;
    private String serviceName;
    private float originalValue;
    private float feeAmount;
    private float finalValue;
    private int installments;
    private final static float CREDIT_FEE = 0.05f;

    // Default constructor
    public CreditPayment() {}

    // Constructor to receive details from the Menu selection
    public CreditPayment(String clientName, String serviceName, float serviceValue, int installments) {
        this.clientName = clientName;
        this.serviceName = serviceName;
        this.originalValue = serviceValue;
        
        
        if (installments < 1) {
            this.installments = 1;
        } else if (installments > 3) {
            this.installments = 3;
            System.out.println("Notice: Maximum allowed installments is 3x. Setting to 3x.");
        } else {
            this.installments = installments;
        }
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
        // Credit card payment adds a 5% administrative/processing fee
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