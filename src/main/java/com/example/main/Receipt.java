package com.example.main;

import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private final List<Item> items;

    public Receipt() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public String getItemTotalPrice(Item item) {
        double totalProductPrice = item.getPrice() + item.getSalesTax();
        return String.format("%.2f", totalProductPrice);
    }

    public double calculateTotalSalesTax() {
        return items.stream().mapToDouble(Item::getSalesTax).sum();
    }

    public double calculateTotalPrice() {
        return items.stream().mapToDouble(Item::getTotalPrice).sum();
    }

    @Override
    public String toString() {
        StringBuilder receipt = new StringBuilder();
        for (Item item : items) {
            String parsedString = item.toString().split(" at ")[0] + " : " + getItemTotalPrice(item);
            receipt.append(parsedString).append("\n");
        }
        receipt.append(String.format("Sales Taxes: %.2f\n", calculateTotalSalesTax()));
        receipt.append(String.format("Total: %.2f\n", calculateTotalPrice()));
        return receipt.toString();
    }
}
