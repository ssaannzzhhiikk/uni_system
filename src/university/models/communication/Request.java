package university.models.communication;

import university.enums.RequestStatus;
import university.models.users.Employee;
import java.time.LocalDateTime;

public class Request {

    private Employee requester;
    private String description;
    private RequestStatus status;
    private LocalDateTime createdAt;

    public Request(Employee requester, String description) {
        this.requester = requester;
        this.description = description;
        this.status = RequestStatus.PENDING;
        this.createdAt = LocalDateTime.now();
    }

    public Employee getRequester() { return requester; }
    public String getDescription() { return description; }
    public RequestStatus getStatus() { return status; }
    public void setStatus(RequestStatus status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    @Override
    public String toString() {
        return "Request from " + requester.getFullName()
                + " [" + status + "]: " + description;
    }
}
