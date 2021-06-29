package bankaccountapp;

import java.math.BigDecimal;

public class Checking extends Account {

    //checking-specific properties
    private String debitNum;
    private int debitPin;

    //constructor for checking
    public Checking(String name, String SSN, double balance) {
        super(name, SSN, balance, 2);
        this.debitNum = new BigDecimal(generateDebit()).toPlainString();
        this.debitPin = generatePin();
    }

    //checking-specific methods
    private double generateDebit() {
        double debit = Math.round(Math.random() * Math.pow(10, 12));
        return debit;
    }
    private int generatePin() {
        int pin = (int) (Math.random() * Math.pow(10,4));
        return pin;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Checking account debit number: " + debitNum +
                "\nChecking account pin number: " + debitPin);
    }
    @Override
    public void setRate() {
        rate = getBaseRate() * 0.15;
    }
}
