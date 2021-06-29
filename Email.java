package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 8;
    private String alternateEmail;
    private static final String suffix = "company.com";

    //constructor
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Creating new employee profile for: " + this.firstName + " " + this.lastName);

        this.department = setDepartment(); //call method
        System.out.println("Department assignment:" + this.department);

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("System-generated password: " + this.password);

        this.email = emailConst();
        System.out.println("Email is configured as: " + this.email);

    }
    //get input - department
    private String setDepartment() {
        System.out.println("Available department codes: \n1 for Sales \n2 for Development \n3 for Accounting \n4 for Other \n\n Enter code: ");
        Scanner dept = new Scanner(System.in);
        int choice = dept.nextInt();
        if (choice == 1) {
            return "Sales";
        } else if (choice == 2) {
            return "Development";
        } else if (choice == 3) {
            return "Accounting";
        } else {
            System.out.println("Manually enter department name:");
            Scanner alternate = new Scanner(System.in);
            String alt = alternate.next();
            return alt;
        }
    }

    //generate random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^";
        char[] password = new char[length];
        for (int i=0; i < length; i++) {
            //generate a random num within scope of passwordSet:
            int rand = (int) (Math.random() * passwordSet.length());
            //take a char at a random point in passwordSet and pass it in 1 at a time
            password[i] = passwordSet.charAt(rand);
        }
        //need to clarify it's a new string, since it is essentially a list of characters
        return new String(password);
    }

    //combine elements to generate email
    private String emailConst () {
            String email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase() + "." + suffix;
            return email;
    }
    //set mailbox capacity
    public void setCapacity (int capacity) {
        this.mailboxCapacity = capacity;
        System.out.println("New mailbox capacity: " + capacity);
    }

    //set alternate email
    public void setAltEmail (String email) {
        this.alternateEmail = email;
        System.out.println("New email: " + email);
    }

    //change the password
    public void changePassword (String password) {
        this.password = password;
        System.out.println("New password: " + password);
    }

    //getters:
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }
    public String getAlternateEmail() {
        return alternateEmail;
    }
    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "Display name: " + firstName + " " + lastName +
                "\nCompany email: " + email +
                "\nMailbox capacity: " + mailboxCapacity + " emails";
    }
}

