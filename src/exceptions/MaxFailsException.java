package university.exceptions;
public class MaxFailsException extends Exception {
    public MaxFailsException() {
        super("Student cannot fail more than 3 times.");
    }
}
