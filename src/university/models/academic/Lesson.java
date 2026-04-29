package university.models.academic;

import university.enums.LessonType;
import university.models.users.Teacher;
import java.time.LocalDateTime;

public class Lesson {

    private String lessonId;
    private LessonType type;
    private LocalDateTime dateTime;
    private String room;
    private Course course;
    private Teacher teacher;

    public Lesson(String lessonId, LessonType type, LocalDateTime dateTime,
                  String room, Course course, Teacher teacher) {
        this.lessonId = lessonId;
        this.type = type;
        this.dateTime = dateTime;
        this.room = room;
        this.course = course;
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return type + " | " + course.getName() + " | " + room + " | " + dateTime;
    }

    public String getLessonId() { return lessonId; }
    public LessonType getType() { return type; }
    public LocalDateTime getDateTime() { return dateTime; }
    public String getRoom() { return room; }
    public Course getCourse() { return course; }
    public Teacher getTeacher() { return teacher; }
}
