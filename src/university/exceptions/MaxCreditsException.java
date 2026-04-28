package university.exceptions;
public class MaxCreditsException extends Exception {
    public MaxCreditsException() {
        super("Student cannot exceed 21 credits.");
    }
}
