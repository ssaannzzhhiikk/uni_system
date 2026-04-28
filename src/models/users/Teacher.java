package university.models.users;

import university.enums.Faculty;
import university.enums.TeacherTitle;
import university.interfaces.Ratable;
import university.interfaces.Researcher;
import university.models.academic.Course;
import university.models.academic.Mark;
import university.models.communication.Complaint;

import java.util.*;

public class Teacher extends Employee implements Ratable, Comparable<Teacher> {

    private TeacherTitle title;
    private Faculty faculty;
    private List<Course> courses;
    private List<Double> ratings;
    private List<Complaint> complaints;
    private Researcher researcherRole;

    public Teacher(String firstName, String lastName, String login, String password,
                   String email, int employeeId, double salary,
                   TeacherTitle title, Faculty faculty) {
        super(firstName, lastName, login, password, email, employeeId, salary);
        this.title = title;
        this.faculty = faculty;
        this.courses = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.complaints = new ArrayList<>();
    }

    public void assignCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addTeacher(this);
        }
    }

    public void putMark(Student student, Course course, Mark mark) throws Exception {
        if (!courses.contains(course)) {
            throw new Exception("Teacher is not assigned to this course.");
        }
        student.addMark(course, mark);
    }

    public void sendComplaint(Employee target, String text) {
        Complaint complaint = new Complaint(this, target, text);
        complaints.add(complaint);
    }

    public boolean isProfessor() { return title == TeacherTitle.PROFESSOR; }

    @Override
    public void addRating(double rating) { ratings.add(rating); }

    @Override
    public double getAverageRating() {
        if (ratings.isEmpty()) return 0.0;
        return ratings.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    @Override
    public String getRole() { return "Teacher"; }

    @Override
    public int compareTo(Teacher other) {
        return this.getFullName().compareTo(other.getFullName());
    }

    public TeacherTitle getTitle() { return title; }
    public void setTitle(TeacherTitle title) { this.title = title; }
    public Faculty getFaculty() { return faculty; }
    public List<Course> getCourses() { return courses; }
    public List<Complaint> getComplaints() { return complaints; }
    public Researcher getResearcherRole() { return researcherRole; }
    public void setResearcherRole(Researcher role) { this.researcherRole = role; }
    public boolean isResearcher() { return researcherRole != null || isProfessor(); }
}
