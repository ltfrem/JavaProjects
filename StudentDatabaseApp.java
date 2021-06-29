package studentdatabase;


import java.util.ArrayList;
import java.util.Scanner;

public class StudentDatabaseApp {

    public static void main(String[] args) {

        //how many new students to add?
        System.out.println("Enter number of students to enroll:");
        Scanner input = new Scanner(System.in);
        int numOfStudents = input.nextInt();
       Student[] students = new Student[numOfStudents];

        for (int i = 0; i < numOfStudents; i++) {
            students[i] = new Student();
            students[i].enroll();
            students[i].dropCourse();
            System.out.println(students[i].showInfo());
        }
    }
}
