package university.models.communication;

import university.enums.RequestStatus;
import university.models.users.Employee;
import java.time.LocalDateTime;

public class Complaint {

    private Employee from;
    private Employee about;
    private String text;
    private LocalDateTime createdAt;
    private RequestStatus status;

    public Complaint(Employee from, Employee about, String text) {
        this.from = from;
        this.about = about;
        this.text = text;
        this.createdAt = LocalDateTime.now();
        this.status = RequestStatus.PENDING;
    }

    public Employee getFrom() { return from; }
    public Employee getAbout() { return about; }
    public String getText() { return text; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public RequestStatus getStatus() { return status; }
    public void setStatus(RequestStatus status) { this.status = status; }

    @Override
    public String toString() {
        return "Complaint from " + from.getFullName()
                + " about " + about.getFullName() + ": " + text;
    }
}
