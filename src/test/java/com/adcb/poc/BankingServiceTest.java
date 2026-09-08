package com.adcb.poc;

import org.junit.Test;
import static org.junit.Assert.*;

public class BankingServiceTest {

    BankingService service = new BankingService();

    @Test
    public void testCalculateInterest() {
        double result = service.calculateInterest(10000, 5, 2);
        assertEquals(1000.0, result, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateInterestInvalidInput() {
        service.calculateInterest(-1000, 5, 2);
    }

    @Test
    public void testLoanEligibility() {
        assertTrue(service.isEligibleForLoan(10000, 3000));
        assertFalse(service.isEligibleForLoan(10000, 5000));
    }

    @Test
    public void testAccountType() {
        assertEquals("PREMIUM", service.getAccountType(150000));
        assertEquals("STANDARD", service.getAccountType(50000));
        assertEquals("BASIC", service.getAccountType(5000));
    }

    @Test
    public void testCreditTransaction() {
        double result = service.applyTransaction(1000, 500, "CREDIT");
        assertEquals(1500.0, result, 0.001);
    }

    @Test
    public void testDebitTransaction() {
        double result = service.applyTransaction(1000, 500, "DEBIT");
        assertEquals(500.0, result, 0.001);
    }

    @Test(expected = IllegalStateException.class)
    public void testInsufficientFunds() {
        service.applyTransaction(100, 500, "DEBIT");
    }
}
