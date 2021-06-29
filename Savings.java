package bankaccountapp;

public class Savings extends Account {

    //savings-specific properties
    private int safetyCode;
    private int safetyPass;

    //savings constructor
    public Savings(String name, String SSN, double balance) {
        super(name, SSN, balance, 1);
        this.safetyCode = generateSafety();
        this.safetyPass = generatePass();

    }


    //savings-specific methods
    public int generateSafety() {
        int boxNum = (int) (Math.random() * Math.pow(10,3));
        return boxNum;
    }
    public int generatePass() {
        int password = (int) (Math.random() * Math.pow(10,4));
        return password;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Safety Deposit Box Number: " + safetyCode +
                "\nSafety Deposit Code: " + safetyPass);
    }
    @Override
    public void setRate() {
        rate = getBaseRate() - 0.25;
    }
}
