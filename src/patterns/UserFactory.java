package university.patterns;

import university.enums.Faculty;
import university.enums.ManagerType;
import university.enums.TeacherTitle;
import university.models.users.*;

public class UserFactory {

    public static Student createStudent(String firstName, String lastName, String login,
                                        String password, String email,
                                        int studentId, int year, Faculty faculty) {
        return new Student(firstName, lastName, login, password, email, studentId, year, faculty);
    }

    public static Teacher createTeacher(String firstName, String lastName, String login,
                                        String password, String email,
                                        int employeeId, double salary,
                                        TeacherTitle title, Faculty faculty) {
        return new Teacher(firstName, lastName, login, password, email,
                employeeId, salary, title, faculty);
    }

    public static Manager createManager(String firstName, String lastName, String login,
                                        String password, String email,
                                        int employeeId, double salary,
                                        ManagerType type, Faculty faculty) {
        return new Manager(firstName, lastName, login, password, email,
                employeeId, salary, type, faculty);
    }

    public static Admin createAdmin(String firstName, String lastName, String login,
                                    String password, String email,
                                    int employeeId, double salary) {
        return new Admin(firstName, lastName, login, password, email, employeeId, salary);
    }
}
