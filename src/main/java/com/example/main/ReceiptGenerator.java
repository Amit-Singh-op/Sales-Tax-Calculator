package com.example.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReceiptGenerator {

    private final List<Item> items;
    private final String[] foods;
    private final String[] medical_products;

    public ReceiptGenerator() {
        this.items = new ArrayList<>();
        this.foods = new String[]{"chocolates"};
        this.medical_products = new String[]{"headache pills"};
    }

    public void addItem(String description) {
        boolean isImported = description.toLowerCase().contains("imported");
        double price = Double.parseDouble(description.split("at ")[1]);
        int quantity = Integer.parseInt(description.split(" ")[0]);
        boolean isExempt = description.toLowerCase().contains("book")
                || description.toLowerCase().contains("food")
                || description.toLowerCase().contains("medical")
                || Arrays.stream(this.foods).anyMatch(food -> description.toLowerCase().contains(food.toLowerCase()))
                || Arrays.stream(this.medical_products).anyMatch(product -> description.toLowerCase().contains(product.toLowerCase()));

        Item item = new Item(description, price, isImported, isExempt, quantity);
        items.add(item);
    }

    public Receipt generateReceipt() {
        Receipt receipt = new Receipt();
        for (Item item : items) {
            receipt.addItem(item);
        }
        return receipt;
    }
}
