package com.adcb.poc;

public class BankingService {

    public double calculateInterest(double principal, double rate, int years) {
        if (principal <= 0 || rate <= 0 || years <= 0) {
            throw new IllegalArgumentException("All values must be positive");
        }
        return principal * rate * years / 100;
    }

    public boolean isEligibleForLoan(double income, double existingDebt) {
        if (income <= 0) {
            throw new IllegalArgumentException("Income must be positive");
        }
        double debtToIncomeRatio = existingDebt / income;
        return debtToIncomeRatio < 0.4;
    }

    public String getAccountType(double balance) {
        if (balance >= 100000) {
            return "PREMIUM";
        } else if (balance >= 10000) {
            return "STANDARD";
        } else {
            return "BASIC";
        }
    }

    public double applyTransaction(double balance, double amount, String type) {
        if (type.equals("CREDIT")) {
            return balance + amount;
        } else if (type.equals("DEBIT")) {
            if (amount > balance) {
                throw new IllegalStateException("Insufficient funds");
            }
            return balance - amount;
        }
        throw new IllegalArgumentException("Unknown transaction type: " + type);
    }
}
