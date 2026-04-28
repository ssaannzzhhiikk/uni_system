package university.patterns;

import university.models.users.User;
import university.models.academic.Course;
import university.models.research.ResearchPaper;

import java.io.*;
import java.util.*;

public class Database implements Serializable {

    private static Database instance;

    private Map<String, User> users;
    private Map<String, Course> courses;
    private List<ResearchPaper> allPapers;

    private static final String FILE_PATH = "database.ser";

    private Database() {
        users = new HashMap<>();
        courses = new HashMap<>();
        allPapers = new ArrayList<>();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = loadFromFile();
        }
        return instance;
    }

    public void addUser(User user) { users.put(user.getId(), user); }
    public void removeUser(String id) { users.remove(id); }
    public User getUserById(String id) { return users.get(id); }
    public Collection<User> getAllUsers() { return users.values(); }

    public void addCourse(Course course) { courses.put(course.getCourseId(), course); }
    public Course getCourseById(String id) { return courses.get(id); }
    public Collection<Course> getAllCourses() { return courses.values(); }

    public void addResearchPaper(ResearchPaper paper) { allPapers.add(paper); }
    public List<ResearchPaper> getAllPapers() { return allPapers; }

    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.err.println("Failed to save database: " + e.getMessage());
        }
    }

    private static Database loadFromFile() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return (Database) ois.readObject();
            } catch (Exception e) {
                System.err.println("Failed to load database, creating new one.");
            }
        }
        return new Database();
    }
}
