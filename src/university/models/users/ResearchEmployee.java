package university.models.users;

import university.interfaces.Researcher;
import university.models.research.ResearchPaper;
import university.models.research.ResearchProject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ResearchEmployee extends Employee implements Researcher {

    private List<ResearchPaper> papers;
    private List<ResearchProject> projects;

    public ResearchEmployee(String firstName, String lastName, String login, String password,
                            String email, int employeeId, double salary) {
        super(firstName, lastName, login, password, email, employeeId, salary);
        this.papers = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    @Override public void addPaper(ResearchPaper paper) { papers.add(paper); }
    @Override public void addProject(ResearchProject project) { projects.add(project); }
    @Override public List<ResearchPaper> getPapers() { return papers; }
    @Override public List<ResearchProject> getProjects() { return projects; }

    @Override
    public int getHIndex() {
        List<Integer> citations = new ArrayList<>();
        for (ResearchPaper p : papers) citations.add(p.getCitations());
        citations.sort(Comparator.reverseOrder());
        int h = 0;
        for (int i = 0; i < citations.size(); i++) {
            if (citations.get(i) >= i + 1) h = i + 1;
            else break;
        }
        return h;
    }

    @Override
    public void printPapers(Comparator<ResearchPaper> comparator) {
        papers.stream().sorted(comparator).forEach(System.out::println);
    }

    @Override
    public String getRole() { return "ResearchEmployee"; }
}
