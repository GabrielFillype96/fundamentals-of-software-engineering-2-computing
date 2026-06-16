package services;

import java.util.ArrayList;
import java.util.List;

public class ServiceCatalog {
    // Fixed service catalog
    private static ArrayList<String> serviceNames = new ArrayList<>(List.of(
        "Data Science", 
        "Data Engineer", 
        "Data Analyst"
    ));
    private static ArrayList<String> serviceDescriptions = new ArrayList<>(List.of(
        "Transform raw, complex data into actionable insights and predictive models", 
        "Design and build the infrastructure to collect, clean, and store raw data", 
        "Transform raw business information into actionable insights"
    ));
    private static ArrayList<Float> serviceValues = new ArrayList<>(List.of(
        2500.00f, 
        3000.00f, 
        1500.00f
    ));

    // Dynamic catalog
    private ArrayList<String> newServiceName = new ArrayList<>();
    private ArrayList<String> newDescriptionService = new ArrayList<>();
    private ArrayList<Float> newServiceValue = new ArrayList<>();

    // Fixed catalog getters
    public static ArrayList<String> getServiceNames() {
        return serviceNames; 
    }

    public static ArrayList<String> getServiceDescriptions() {
        return serviceDescriptions;
    }

    public static ArrayList<Float> getServiceValues() {
        return serviceValues;
    }

    // Dynamic catalog getters and setters
    public ArrayList<String> getNewServiceName() {
        return newServiceName;
    }

    public void setNewServiceName(ArrayList<String> newServiceName) {
        this.newServiceName = newServiceName;
    }

    public ArrayList<String> getNewDescriptionService() {
        return newDescriptionService;
    }

    public void setNewDescriptionService(ArrayList<String> newDescriptionService) {
        this.newDescriptionService = newDescriptionService;
    }

    public ArrayList<Float> getNewServiceValue() {
        return newServiceValue;
    }

    public void setNewServiceValue(ArrayList<Float> newServiceValue) {
        this.newServiceValue = newServiceValue;
    }
    
}