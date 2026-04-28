package university.models.academic;

import university.enums.CourseStatus;
import university.enums.Faculty;
import university.models.users.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course implements Comparable<Course> {

    private String courseId;
    private String name;
    private int credits;
    private Faculty faculty;
    private int targetYear;
    private CourseStatus status;
    private List<Teacher> teachers;
    private List<Lesson> lessons;

    public Course(String courseId, String name, int credits, Faculty faculty, int targetYear) {
        this.courseId = courseId;
        this.name = name;
        this.credits = credits;
        this.faculty = faculty;
        this.targetYear = targetYear;
        this.status = CourseStatus.OPEN;
        this.teachers = new ArrayList<>();
        this.lessons = new ArrayList<>();
    }

    public void addTeacher(Teacher teacher) {
        if (!teachers.contains(teacher)) teachers.add(teacher);
    }

    public void addLesson(Lesson lesson) { lessons.add(lesson); }

    @Override public int compareTo(Course other) { return this.name.compareTo(other.name); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        return Objects.equals(courseId, ((Course) o).courseId);
    }

    @Override public int hashCode() { return Objects.hash(courseId); }

    @Override
    public String toString() {
        return "Course[" + courseId + "] " + name + " (" + credits + " credits)";
    }

    public String getCourseId() { return courseId; }
    public String getName() { return name; }
    public int getCredits() { return credits; }
    public Faculty getFaculty() { return faculty; }
    public int getTargetYear() { return targetYear; }
    public CourseStatus getStatus() { return status; }
    public void setStatus(CourseStatus status) { this.status = status; }
    public List<Teacher> getTeachers() { return teachers; }
    public List<Lesson> getLessons() { return lessons; }
}
