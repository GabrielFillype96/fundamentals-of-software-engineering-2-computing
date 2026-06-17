package payment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class BankPayment implements Payment {
    
    private String clientName;
    private String serviceName;
    private float originalValue;
    private float finalValue;
    private float fineAmount; 
    
    private LocalDate dueDate;
    private LocalDate paymentDate;
    
    
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Default constructor
    public BankPayment() {}

    // Constructor to receive details from the Menu selection
    public BankPayment(String clientName, String serviceName, float serviceValue, String dueDateStr, String paymentDateStr) {
        this.clientName = clientName;
        this.serviceName = serviceName;
        this.originalValue = serviceValue;
        
        
        this.dueDate = LocalDate.parse(dueDateStr, FORMATTER);
        this.paymentDate = LocalDate.parse(paymentDateStr, FORMATTER);
    }

    @Override
    public void paymentDetails() {
        System.out.println("\n=================================");
        System.out.println("       BANK PAYMENT RULES        ");
        System.out.println("=================================");
        System.out.println("* Payments made on or before the due date face no additional charges.");
        System.out.println("* Late payments incur a flat 2% fine + 0.1% interest per day delayed.");
        System.out.println("=================================");
    }

    @Override
    public void paymentCalc() {
        // Check if the payment date is after the due date
        if (paymentDate.isAfter(dueDate)) {
            // Calculate how many days late it is
            long daysLate = ChronoUnit.DAYS.between(dueDate, paymentDate);
            
            // Calculate 2% flat fine + 0.1% per day interest
            float flatFine = this.originalValue * 0.02f;
            float dailyInterest = this.originalValue * (0.001f * daysLate);
            
            this.fineAmount = flatFine + dailyInterest;
            this.finalValue = this.originalValue + this.fineAmount;
            
            System.out.println("Notice: Payment is " + daysLate + " day(s) late. Fees applied.");
        } else {
            // No fines if paid on time
            this.fineAmount = 0.00f;
            this.finalValue = this.originalValue;
        }
    }

    @Override
    public void displayPaymentOrder() {
        System.out.println("\n=================================");
        System.out.println("          PAYMENT ORDER          ");
        System.out.println("=================================");
        System.out.println("Client Name:    " + this.clientName);
        System.out.println("Service:        " + this.serviceName);
        System.out.println("Original Value: $" + String.format("%.2f", this.originalValue));
        System.out.println("Payment Method: BANK SLIP");
        System.out.println("Due Date:       " + this.dueDate.format(FORMATTER));
        System.out.println("Payment Date:   " + this.paymentDate.format(FORMATTER));
        
        if (this.fineAmount > 0) {
            System.out.println("Late Fees/Fine: $" + String.format("%.2f", this.fineAmount));
        } else {
            System.out.println("Late Fees/Fine: $0.00 (Paid on time!)");
        }
        
        System.out.println("---------------------------------");
        System.out.println("Final Value:    $" + String.format("%.2f", this.finalValue));
        System.out.println("=================================");
        System.out.println("        Order Successful!        ");
        System.out.println("=================================\n");
    }
}