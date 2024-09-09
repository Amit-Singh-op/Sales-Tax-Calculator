package com.example.main;

import java.util.Scanner;

public class SalesTaxCalculatorApp {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ReceiptGenerator receiptGenerator = new ReceiptGenerator();

            System.out.println("Enter items. Type 'done' when finished.");
            while (true) {
                System.out.print("Item description: ");
                String description = scanner.nextLine();
                if (description.equalsIgnoreCase("done")) {
                    break;
                }

                receiptGenerator.addItem(description);
            }

            Receipt receipt = receiptGenerator.generateReceipt();

            System.out.println("\nReceipt:");
            System.out.println(receipt);
        } catch (Exception e) {
            System.out.println("Something went wrong " + e);
        }
    }
}
