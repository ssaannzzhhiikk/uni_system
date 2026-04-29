package university.exceptions;
public class MaxCreditsException extends Exception {
    public MaxCreditsException(int maxCredits) {
        super("Student cannot exceed " + maxCredits + " credits.");
    }
}