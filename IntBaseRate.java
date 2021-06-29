package bankaccountapp;

public interface IntBaseRate {

    //method that returns base rate
    default double getBaseRate() {
        return 2.5;
    }
}
