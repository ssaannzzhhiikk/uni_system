package university.models.research;

import university.exceptions.NotResearcherException;
import university.interfaces.Researcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResearchProject {

    private String projectId;
    private String topic;
    private List<Researcher> participants;
    private List<ResearchPaper> publishedPapers;

    public ResearchProject(String projectId, String topic) {
        this.projectId = projectId;
        this.topic = topic;
        this.participants = new ArrayList<>();
        this.publishedPapers = new ArrayList<>();
    }

    public void addParticipant(Object person) throws NotResearcherException {
        if (!(person instanceof Researcher)) {
            throw new NotResearcherException(person.toString());
        }
        Researcher r = (Researcher) person;
        if (!participants.contains(r)) participants.add(r);
    }

    public void addPublishedPaper(ResearchPaper paper) { publishedPapers.add(paper); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResearchProject)) return false;
        return Objects.equals(projectId, ((ResearchProject) o).projectId);
    }

    @Override public int hashCode() { return Objects.hash(projectId); }

    @Override
    public String toString() {
        return "ResearchProject[" + projectId + "] topic: " + topic
                + ", participants: " + participants.size();
    }

    public String getProjectId() { return projectId; }
    public String getTopic() { return topic; }
    public List<Researcher> getParticipants() { return participants; }
    public List<ResearchPaper> getPublishedPapers() { return publishedPapers; }
}
