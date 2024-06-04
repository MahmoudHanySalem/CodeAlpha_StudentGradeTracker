package studentgradetracker;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Mahmoud
 */
public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean loggedIn = false;
        // Authentication loop
        while (loggedIn == false) {
            System.out.print("Enter Name:");//Professor name=Mahmoud<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            String name = input.next();
            System.out.print("Enter password:");//Professor password=123<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            String password = input.next();
            if (name.equalsIgnoreCase("Mahmoud") && password.equals("123")) {
                loggedIn = true;
                System.out.println("Logged into student Management System Successfully");
                boolean continuing = true;
                // Main menu loop
                while (continuing) {
                    System.out.println("Choose action:\n(0)Exit\n(1)Create new student.\n(2)Delete a student using ID.\n(3)Change the name of a student using ID.\n(4)Modifay a student ID.\n(5)Modifay a student grade using ID.\n(6)See lowest score.\n(7)See highest score.\n(8)The average of scores.");
                    int choice = input.nextInt();
                    switch (choice) {
                        case 0 ->
                            continuing = false;
                        case 1 -> {
                            // Create a new student
                            System.out.println("Enter student name");
                            input.nextLine();// Clear the newline character
                            String sName = input.nextLine();
                            boolean validID = true;
                            int sid1 = 0;
                            double sGrade1 = -1;
                            while (validID) {
                                System.out.println("Enter student ID");
                                try {
                                    sid1 = input.nextInt();
                                    validID = false;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid value<<must be an integer>>");
                                    // Clear the invalid input from the scanner buffer
                                    input.nextLine();
                                }
                            }
                            boolean validGrade = true;
                            while (validGrade) {
                                System.out.println("Enter student grade");
                                try {
                                    sGrade1 = input.nextDouble();
                                    if (sGrade1 >= 0 && sGrade1 <= 100) {
                                        validGrade = false;
                                    } else {
                                        System.out.println("Invalid value<<must be a number between 0 and 100 Inclusive>>");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid value<<must be an number>>");
                                    input.nextLine();
                                }
                            }
                            Student s = new Student(sName, sid1, sGrade1);
                            System.out.println(s);
                        }
                        case 2 -> {
                            boolean validID = true;
                            int sid = 0;
                            while (validID) {
                                System.out.println("Enter student ID:");
                                try {
                                    sid = input.nextInt();
                                    validID = false;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid value<<must be an integer between>>");
                                    // Clear the invalid input from the scanner buffer
                                    input.nextLine();
                                }
                            }
                            boolean found = false;
                            for (Student currentStudent : Student.students) {
                                if (currentStudent.getId() == sid) {
                                    found = true;
                                    Student.students.remove(currentStudent);
                                    System.out.println("Student record deleted");
                                    break;
                                }
                            }
                            if (found == false) {
                                System.out.println("No student with this ID");
                            }
                        }
                        case 3 -> {
                            int sid2 = 0;
                            boolean validID = true;
                            while (validID) {
                                System.out.println("Enter student ID");
                                try {
                                    sid2 = input.nextInt();
                                    validID = false;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid value<<must be an integer>>");
                                    input.nextLine();
                                }
                            }
                            System.out.println("Enter student new name");
                            input.nextLine();// Clear the newline character
                            String newName = input.nextLine();
                            boolean found = false;
                            for (Student currentStudent : Student.students) {
                                if (currentStudent.getId() == sid2) {
                                    found = true;
                                    currentStudent.setName(newName);
                                    System.out.println("Student information after update:");
                                    System.out.println(currentStudent);
                                    break;
                                }
                            }
                            if (found == false) {
                                System.out.println("No student with this ID");
                            }
                        }
                        case 4 -> {
                            int oldID = 0;
                            boolean validID = true;
                            while (validID) {
                                System.out.println("Enter student old ID");
                                try {
                                    oldID = input.nextInt();
                                    validID = false;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid value<<must be an integer>>");
                                    input.nextLine();// Clear the invalid input
                                }
                            }
                            int newID = 0;
                            boolean validIDn = true;
                            while (validIDn) {
                                System.out.println("Enter student new ID:");
                                try {
                                    newID = input.nextInt();
                                    validIDn = false;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid value<<must be an integer>>");
                                    input.nextLine();
                                }
                            }
                            boolean valid = true;
                            for (Student currentStudent : Student.students) {
                                if (currentStudent.getId() == newID) {
                                    System.out.println("there exist a student with this id already");
                                    valid = false;
                                    break;
                                }
                            }
                            if (valid) {
                                boolean found = false;
                                for (Student currentStudent : Student.students) {
                                    if (currentStudent.getId() == oldID) {
                                        found = true;
                                        currentStudent.setId(newID);
                                        System.out.println("Student information after update:");
                                        System.out.println(currentStudent);
                                        break;
                                    }
                                }
                                if (found == false) {
                                    System.out.println("No student with this ID");
                                }
                            }
                        }
                        case 5 -> {
                            int id1 = 0;
                            boolean validID = true;
                            while (validID) {
                                System.out.println("Enter student ID");
                                try {
                                    id1 = input.nextInt();
                                    validID = false;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid value<<must be an integer>>");
                                    input.nextLine();// Clear the invalid input
                                }
                            }
                            double newGrade = -1;
                            boolean validGrade = true;
                            while (validGrade) {
                                System.out.println("Enter student grade");
                                try {
                                    newGrade = input.nextDouble();
                                    if (newGrade >= 0 && newGrade <= 100) {
                                        validGrade = false;
                                    } else {
                                        System.out.println("Invalid value<<must be a number between 0 and 100 Inclusive>>");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid value<<must be an number>>");
                                    input.nextLine();
                                }
                            }
                            boolean found = false;
                            for (Student currentStudent : Student.students) {
                                if (currentStudent.getId() == id1) {
                                    found = true;
                                    currentStudent.setGrade(newGrade);
                                    System.out.println("Student information after update:");
                                    System.out.println(currentStudent);
                                    break;
                                }
                            }
                            if (found == false) {
                                System.out.println("No student with this ID");
                            }
                        }
                        case 6 -> {
                            double min = Double.MAX_VALUE;
                            for (Student currentStudent : Student.students) {
                                if (currentStudent.getGrade() < min) {
                                    min = currentStudent.getGrade();
                                }
                            }
                            System.out.println("lowest Grade = " + min);
                        }
                        case 7 -> {
                            double max = Double.MIN_VALUE;
                            for (Student currentStudent : Student.students) {
                                if (currentStudent.getGrade() > max) {
                                    max = currentStudent.getGrade();
                                }
                            }
                            System.out.println("highest Grade = " + max);
                        }
                        case 8 -> {
                            double sum = 0;
                            for (Student currentStudent : Student.students) {
                                sum += currentStudent.getGrade();
                            }
                            System.out.println("average of Grades = " + (sum / Student.students.size()));
                        }
                        default ->
                            System.out.println("Invalid choice");
                    }
                }
            } else {
                System.out.println("Authentication failed. Please try again.");
            }
        }
    }

}
