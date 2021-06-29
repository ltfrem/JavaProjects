package bankaccountapp;

public abstract class Account implements IntBaseRate {
    //common properties of both savings and checking
    private String name;
    private String SSN;
    protected String acctNum;
    private double balance;
    protected double rate;
    private int acctType;
    private static int index = 10000;

    //constructor
    public Account(String name, String SSN, double initDeposit, int acctType) {
        this.name = name;
        this.SSN = SSN;
        this.balance = initDeposit;
        this.acctType = acctType;
        this.acctNum = generateId();
        setRate();
        System.out.println("New account generated for: " + name + " with initial deposit of $" + initDeposit);
        System.out.println("Account id: " + acctNum);
    }

    public abstract void setRate();

    //common methods for savings and checking
    private String generateId() {
        //last 2 of SSN
        String digits = SSN.substring(SSN.length() - 2);
        //unique 5 digits
        index++;
        //random 3 digits
        //math pow 10^3 makes it 3 digits
        int random = (int) (Math.random() * Math.pow(10,3));
        return acctType + digits + index + random;
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + ". Balance is now $" + balance);
    }

    public void withdraw(int amount) {
        balance -= amount;
        System.out.println("Withdrew $" + amount + ". Balance is now $" + balance);
    }

    public void transfer(int amount, String endLocation) {
        balance -= amount;
        System.out.println("Transferring $" + amount + " to " + endLocation);
    }
    public void getBalance() {
        System.out.println("Current balance: $" + balance);
    }
    public void compound() {
        double accruedInterest = balance * (rate/100);
        System.out.println("Accrued interest: $" + accruedInterest);
        balance += accruedInterest;
        System.out.println("New balance: $" + balance);

    }

    public void showInfo() {
        System.out.println("Name: " + name +
                "\nAccount number: " + acctNum +
                "\nCurrent balance: $" + balance);
    }
}
