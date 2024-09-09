package com.example.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ReceiptGeneratorTest {

    @Test
    void testGenerateReceipt() {
        ReceiptGenerator generator = new ReceiptGenerator();
        generator.addItem("1 imported box of chocolates at 10.00");
        generator.addItem("1 imported bottle of perfume at 47.50");

        Receipt receipt = generator.generateReceipt();

        // Expected values based on calculations
        double expectedTotal = 65.15;

        assertEquals(expectedTotal, receipt.calculateTotalPrice(), 0.01);
    }
}
