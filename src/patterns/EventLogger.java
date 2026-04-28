package university.patterns;

import university.interfaces.Observer;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventLogger implements Observer {

    private static EventLogger instance;
    private List<String> logs;

    private EventLogger() {
        logs = new ArrayList<>();
    }

    public static EventLogger getInstance() {
        if (instance == null) instance = new EventLogger();
        return instance;
    }

    @Override
    public void onEvent(String event) {
        String entry = "[" + LocalDateTime.now() + "] " + event;
        logs.add(entry);
        System.out.println(entry);
    }

    public List<String> getLogs() { return logs; }

    public void printAllLogs() { logs.forEach(System.out::println); }
}
