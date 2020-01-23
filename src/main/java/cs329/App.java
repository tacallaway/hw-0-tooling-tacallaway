package cs329;

import java.util.Scanner;

/**
 *
 * @author tylercallaway
 */
public class App {

    public static void main(String[] args) {
        Scanner oiScan = new Scanner(System.in);
        Scanner osScan = new Scanner(System.in);
        Scanner odScan = new Scanner(System.in);

        System.out.println("How many students?");
        int numStudents = oiScan.nextInt();

        Student[] stdList = new Student[numStudents];

        System.out.println("How many courses will each student have?");
        int numClasses = oiScan.nextInt();

        /*
        Increments through array, puts in student objects and adds values.
        */
        for (int i = 0; i < numStudents; i++) {
            System.out.println("What is the student's first name?");
            String fName = osScan.nextLine();
            System.out.println("What is the student's name?");
            String lName = osScan.nextLine();
            Student student = new Student(numClasses, fName, lName);
            System.out.println("What is the student's GPA?");
            student.setGpa(odScan.nextDouble());
            stdList[i] = student;

            /*
            increments through course array, adds values.
            */
            for (int j = 0; j < student.getCourses().length; j++) {

                System.out.println("What is the name of the course " + (j + 1) + "?");
                String stdCourse = osScan.nextLine();
                student.courses[j] = new Course(stdCourse);
            }
        }
        // Iterates over both arrays, outputting the first and last names, as well as GPA and course title.
        for (int i = 0; i < numStudents; i++) {
            Student student = stdList[i];
            System.out.println(stdList[i].getFirstName() + " " + stdList[i].getLastName());
            System.out.println("GPA: " + stdList[i].getGpa());

            for (int j = 0; j < student.courses.length; j++) {
                System.out.println("Course: " + student.courses[j].getCourseTitle());
            }
        }

    }

}

class Person {
    protected String lastName;
    protected String firstName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}

class Student extends Person {

    private double gpa;
    protected Course[] courses;

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Course[] getCourses() {
        return courses;
    }

    public Student(int i, String firstName, String lastName) {
        super(firstName, lastName);
        courses = new Course[i];
    }
}

class Course {
    private String courseTitle;

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public Course(String courseTitle) {
        this.courseTitle = courseTitle;
    }

}
