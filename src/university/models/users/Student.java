package university.models.users;

import university.enums.Faculty;
import university.exceptions.MaxCreditsException;
import university.exceptions.MaxFailsException;
import university.interfaces.Researcher;
import university.models.academic.Course;
import university.models.academic.Mark;
import university.models.academic.Transcript;

import java.util.*;

public class Student extends User implements Comparable<Student> {

    private static final int MAX_CREDITS = 21;
    private static final int MAX_FAILS = 3;

    private int studentId;
    private int year;
    private Faculty faculty;
    private int totalCredits;
    private int failCount;
    private List<Course> registeredCourses;
    private Map<Course, Mark> marks;
    private Transcript transcript;
    private Researcher supervisor;
    private Researcher researcherRole;

    public Student(String firstName, String lastName, String login,
                   String password, String email, int studentId, int year, Faculty faculty) {
        super(firstName, lastName, login, password, email);
        this.studentId = studentId;
        this.year = year;
        this.faculty = faculty;
        this.totalCredits = 0;
        this.failCount = 0;
        this.registeredCourses = new ArrayList<>();
        this.marks = new HashMap<>();
        this.transcript = new Transcript(this);
    }

    public void registerCourse(Course course) throws MaxCreditsException {
        if (totalCredits + course.getCredits() > MAX_CREDITS) {
            throw new MaxCreditsException(MAX_CREDITS);
        }
        registeredCourses.add(course);
        totalCredits += course.getCredits();
    }

    public void addMark(Course course, Mark mark) throws MaxFailsException {
        if (mark.isFailed()) {
            failCount++;
            if (failCount > MAX_FAILS) throw new MaxFailsException();
        }
        marks.put(course, mark);
        transcript.update();
    }

    public double getGpa() {
        if (marks.isEmpty()) return 0.0;
        double total = 0;
        for (Mark m : marks.values()) total += m.getGradePoint();
        return total / marks.size();
    }

    @Override
    public String getRole() { return "Student"; }

    @Override
    public int compareTo(Student other) {
        return Double.compare(other.getGpa(), this.getGpa());
    }

    public int getStudentId() { return studentId; }
    public int getYear() { return year; }
    public Faculty getFaculty() { return faculty; }
    public int getTotalCredits() { return totalCredits; }
    public int getFailCount() { return failCount; }
    public List<Course> getRegisteredCourses() { return registeredCourses; }
    public Map<Course, Mark> getMarks() { return marks; }
    public Transcript getTranscript() { return transcript; }
    public Researcher getSupervisor() { return supervisor; }
    public void setSupervisor(Researcher supervisor) { this.supervisor = supervisor; }
    public Researcher getResearcherRole() { return researcherRole; }
    public void setResearcherRole(Researcher role) { this.researcherRole = role; }
    public boolean isResearcher() { return researcherRole != null; }
}
