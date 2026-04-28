package university.models.communication;

import university.models.users.Employee;
import java.time.LocalDateTime;

public class Message {

    private Employee sender;
    private Employee receiver;
    private String content;
    private LocalDateTime sentAt;

    public Message(Employee sender, Employee receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.sentAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "[" + sentAt + "] From " + sender.getFullName()
                + " to " + receiver.getFullName() + ": " + content;
    }

    public Employee getSender() { return sender; }
    public Employee getReceiver() { return receiver; }
    public String getContent() { return content; }
    public LocalDateTime getSentAt() { return sentAt; }
}
