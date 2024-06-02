package studentgradetracker;

import java.util.ArrayList;

/**
 *
 * @author Mahmoud
 */
public class Student {

    private String name;
    private int id;
    private double grade;
    static int idCount = 20241;
    static ArrayList<Student> students = new ArrayList<>();

    public Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
        students.add(this);
    }

    public Student(String name, double grade) {
        this.name = name;
        this.id = idCount;
        idCount++;
        this.grade = grade;
        students.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        if (0 <= grade && grade <= 100) {
            this.grade = grade;
        } else {
            System.out.println("Invalid grade");
        }
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Name=" + name + ", ID=" + id + ", Grade=" + grade;
    }

}
