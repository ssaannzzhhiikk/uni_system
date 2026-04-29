package university.models.communication;

import university.models.users.Manager;
import java.time.LocalDateTime;

public class News {

    private String title;
    private String content;
    private Manager author;
    private LocalDateTime publishedAt;

    public News(String title, String content, Manager author) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.publishedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "[NEWS] " + title + " | " + publishedAt + "\n" + content;
    }

    public String getTitle() { return title; }
    public String getContent() { return content; }
    public Manager getAuthor() { return author; }
    public LocalDateTime getPublishedAt() { return publishedAt; }
}
