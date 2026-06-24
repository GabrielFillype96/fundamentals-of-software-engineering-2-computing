package payment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class BankPayment implements Payment {
    
    private String clientName;
    private String serviceName;
    private float originalValue;
    private float finalValue;
    private float fineAmount; 
    
    private LocalDate dueDate;
    private LocalDate paymentDate;
    
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Construtor padrão
    public BankPayment() {}

    // Novo construtor adaptado para capturar as datas internamente
    public BankPayment(String clientName, String serviceName, float serviceValue, Scanner sc) {
        this.clientName = clientName;
        this.serviceName = serviceName;
        this.originalValue = serviceValue;
        
        System.out.print("Enter due date (dd/mm/yyyy): ");
        String dueDateStr = sc.nextLine().trim();
        System.out.print("Enter actual payment date (dd/mm/yyyy): ");
        String paymentDateStr = sc.nextLine().trim();
        
        // Faz o parse com try-catch interno para evitar quebras no menu principal
        try {
            this.dueDate = LocalDate.parse(dueDateStr, FORMATTER);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid due date format! Defaulting to today.");
            this.dueDate = LocalDate.now();
        }

        try {
            this.paymentDate = LocalDate.parse(paymentDateStr, FORMATTER);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid payment date format! Defaulting to today.");
            this.paymentDate = LocalDate.now();
        }
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
        if (paymentDate.isAfter(dueDate)) {
            long daysLate = ChronoUnit.DAYS.between(dueDate, paymentDate);
            
            float flatFine = this.originalValue * 0.02f;
            float dailyInterest = this.originalValue * (0.001f * daysLate);
            
            this.fineAmount = flatFine + dailyInterest;
            this.finalValue = this.originalValue + this.fineAmount;
            
            System.out.println("Notice: Payment is " + daysLate + " day(s) late. Fees applied.");
        } else {
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