package studentdatabase;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int year;
    private String className;
    private String id;
    private ArrayList<String> courses = new ArrayList<>();
    private int balance = 0; //balance to be paid
    private static int courseCost = 600;
    private static int studentCode = 1000;

    //constructor - getting info through scanner
    public Student () {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter student first name: ");
        this.firstName = input.nextLine();

        System.out.println("Enter student last name: ");
        this.lastName = input.nextLine();

        System.out.println("1: Freshman \n2: Sophomore \n3: Junior \n4: Senior " +
                "\nEnter student grade level: ");
        this.year = input.nextInt();

        generateId();
        setClassName();
        System.out.println(firstName + " " + lastName + " has a student id of " + this.id + " and Class level of " + this.className);

    }

    //id generator
    private void generateId() {
        this.id = year + "" + studentCode++;
    }

    //set classname
    public void setClassName() {
        if (this.year == 1) {
            this.className = "Freshman";
        } else if (this.year == 2) {
            this.className = "Sophomore";
        } else if (this.year == 3) {
            this.className = "Junior";
        } else if (this.year == 4) {
            this.className = "Senior";
        } else {
            this.className = "Unavailable";
        }
    }

    //enrollment
    public void enroll() {
        Scanner input = new Scanner(System.in);
        String course = "";
        while (!course.equals("Q") || !course.equals("q")) {
            System.out.println("Enter course name to enroll (or Q to quit):");
            course = input.next();
            if (course.equals("Q") || course.equals("q")) {
                break;
            } else {
                courses.add(course);
                System.out.println(courses);
                balance += courseCost;
                System.out.println("Now enrolled in: " + course);
                System.out.println("Tuition balance: " + balance);
            }
        }
        System.out.println("Courses student is enrolled in: " + courses.toString());
    }
    public void dropCourse() {
        Scanner input = new Scanner(System.in);
        System.out.println("What course would you like to drop?");
        String drop = input.next();
        if (courses.contains(drop)) {
            courses.remove(drop);
            System.out.println(drop + " has been dropped.");
            System.out.println(courses.toString());
        } else {
            System.out.println("Could not drop " + drop + ". Student is not enrolled.");
        }
    }

    public int viewBalance() {
        return balance;
    }

    public void payTuition() {
        Scanner input = new Scanner(System.in);
        System.out.println("How much would you like to apply towards tuition balance?");
        int payment = input.nextInt();
        System.out.println("Old balance: " + viewBalance());
        balance -= payment;
        System.out.println("Payment of " + payment + " received! New balance: " + viewBalance());

    }

    public String showInfo() {
        return "Name: " + firstName + " " + lastName +
                "\nCourses enrolled: " + courses.toString() +
                "\nBalance: $" + balance;
    }
}
