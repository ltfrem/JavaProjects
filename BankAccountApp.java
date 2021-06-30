package bankaccountapp;

import java.util.ArrayList;
import java.util.List;

public class BankAccountApp {

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<Account>();



        String file = "C:\\Users\\Desktop\\NewBankAccounts.csv";
        List<String[]> newAccountHolder = utilities.CSV.read(file);
        for (String[] accountHolder : newAccountHolder) {
            String name = accountHolder[0];
            String SSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            System.out.println(name + " " + SSN + " " + accountType + " " + initDeposit);

            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, SSN, initDeposit));
                System.out.println("SAVINGS");
            } else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, SSN, initDeposit));
                System.out.println("CHECKING");
            } else {
                System.out.println("Error");
            }
        }
        System.out.println(accounts.toString());
    }
}
