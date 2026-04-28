package university.models.users;

import java.util.ArrayList;
import java.util.List;

public class Admin extends Employee {

    private List<String> actionLog;

    public Admin(String firstName, String lastName, String login, String password,
                 String email, int employeeId, double salary) {
        super(firstName, lastName, login, password, email, employeeId, salary);
        this.actionLog = new ArrayList<>();
    }

    public void addUser(User user) {
        university.patterns.Database.getInstance().addUser(user);
        logAction("Added user: " + user.getFullName());
    }

    public void removeUser(String userId) {
        university.patterns.Database.getInstance().removeUser(userId);
        logAction("Removed user with id: " + userId);
    }

    public void updateUser(User user) { logAction("Updated user: " + user.getFullName()); }

    public void logAction(String action) { actionLog.add(action); }

    public List<String> getActionLog() { return actionLog; }

    @Override
    public String getRole() { return "Admin"; }
}
