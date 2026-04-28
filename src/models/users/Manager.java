package university.models.users;

import university.enums.Faculty;
import university.enums.ManagerType;
import university.exceptions.LowHIndexException;
import university.interfaces.Researcher;
import university.models.academic.Course;
import university.models.communication.News;
import university.models.communication.Request;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {

    private ManagerType managerType;
    private Faculty faculty;
    private List<Request> pendingRequests;
    private List<News> newsFeed;

    public Manager(String firstName, String lastName, String login, String password,
                   String email, int employeeId, double salary,
                   ManagerType managerType, Faculty faculty) {
        super(firstName, lastName, login, password, email, employeeId, salary);
        this.managerType = managerType;
        this.faculty = faculty;
        this.pendingRequests = new ArrayList<>();
        this.newsFeed = new ArrayList<>();
    }

    public void approveStudentRegistration(Student student, Course course) throws Exception {
        student.registerCourse(course);
    }

    public void assignTeacherToCourse(Teacher teacher, Course course) {
        teacher.assignCourse(course);
    }

    public void approveRequest(Request request) {
        request.setStatus(university.enums.RequestStatus.APPROVED);
    }

    public void rejectRequest(Request request) {
        request.setStatus(university.enums.RequestStatus.REJECTED);
    }

    public void postNews(News news) { newsFeed.add(news); }

    public void assignSupervisor(Student student, Researcher supervisor) throws LowHIndexException {
        if (student.getYear() != 4) {
            System.out.println("Only 4th year students can have a supervisor.");
            return;
        }
        if (supervisor.getHIndex() < 3) {
            String name = supervisor.toString();
            throw new LowHIndexException(name, supervisor.getHIndex());
        }
        student.setSupervisor(supervisor);
    }

    @Override
    public String getRole() { return "Manager"; }

    public ManagerType getManagerType() { return managerType; }
    public Faculty getFaculty() { return faculty; }
    public List<Request> getPendingRequests() { return pendingRequests; }
    public List<News> getNewsFeed() { return newsFeed; }
}
