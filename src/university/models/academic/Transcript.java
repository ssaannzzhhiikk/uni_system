package university.models.academic;

import university.models.users.Student;
import java.util.Map;

public class Transcript {

    private Student student;
    private double gpa;

    public Transcript(Student student) {
        this.student = student;
        this.gpa = 0.0;
    }

    public void update() { this.gpa = student.getGpa(); }

    public void print() {
        System.out.println("===== TRANSCRIPT =====");
        System.out.println("Student: " + student.getFullName());
        System.out.println("Year: " + student.getYear());
        System.out.println("GPA: " + String.format("%.2f", gpa));
        System.out.println("Courses:");
        for (Map.Entry<Course, Mark> entry : student.getMarks().entrySet()) {
            System.out.println("  " + entry.getKey().getName()
                    + " -> " + entry.getValue().getLetterGrade()
                    + " (" + entry.getValue().getTotal() + ")");
        }
        System.out.println("======================");
    }

    public double getGpa() { return gpa; }
    public Student getStudent() { return student; }
}
