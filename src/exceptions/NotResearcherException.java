package university.exceptions;
public class NotResearcherException extends Exception {
    public NotResearcherException(String personName) {
        super(personName + " is not a Researcher and cannot join a ResearchProject.");
    }
}
