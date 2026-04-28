package university.models.users;

import university.models.communication.Message;
import java.util.ArrayList;
import java.util.List;

public abstract class Employee extends User {

    private int employeeId;
    private double salary;
    private List<Message> inbox;

    public Employee(String firstName, String lastName, String login,
                    String password, String email, int employeeId, double salary) {
        super(firstName, lastName, login, password, email);
        this.employeeId = employeeId;
        this.salary = salary;
        this.inbox = new ArrayList<>();
    }

    public void receiveMessage(Message message) { inbox.add(message); }
    public List<Message> getInbox() { return inbox; }
    public int getEmployeeId() { return employeeId; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}
