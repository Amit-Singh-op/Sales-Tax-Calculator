package com.example.main;

public class Item {

    private final String name;
    private final double price;
    private final boolean isImported;
    private final boolean isExempt;
    private final int quantity;

    public Item(String name, double price, boolean isImported, boolean isExempt, int quantity) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.isExempt = isExempt;
        this.quantity = quantity;
    }

    public double calculateSalesTax() {
        double basicSalesTax = isExempt ? 0 : 0.10;
        double importDuty = isImported ? 0.05 : 0;
        double totalTaxRate = basicSalesTax + importDuty;
        double salesTax = price * totalTaxRate;
        // Round up to the nearest 0.05
        return (Math.ceil(salesTax / 0.05) * .05) * quantity;
    }

    public double getTotalPrice() {
        return price + calculateSalesTax();
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", name, getTotalPrice());
    }

    public double getPrice() {
        return price;
    }

    public double getSalesTax() {
        return calculateSalesTax();
    }
}
